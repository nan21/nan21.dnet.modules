package net.nan21.dnet.module.sc._businessdelegates.invoice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.acc.business.service.IAccItemAcctService;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalPeriodService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

public class PaymentOutToAccDocBD extends AbstractBusinessDelegate {

	IBusinessPartnerService bpService;
	IFiscalPeriodService periodService;
	IProductService prodService;
	IAccItemAcctService accItemAcctService;
	IFinancialAccountAcctService payAcctService;

	/**
	 * Un-post payment. Delete linked accounting document(s).
	 * 
	 * @param payment
	 * @throws Exception
	 */
	public void unPost(PaymentOut payment) throws Exception {
		try {
			this.em
					.createQuery(
							"delete from AccDoc t "
									+ " where t.docUuid = :invoiceUuid")
					.setParameter("invoiceUuid", payment.getUuid())
					.executeUpdate();
			payment.setPosted(false);
			this.em.merge(payment);
		} catch (Exception e) {
			if (e.getCause() != null
					&& e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				throw new RuntimeException(
						"Cannot unpost document `"
								+ payment.getCode()
								+ "`. The corresponding accounting document is already posted to great ledger.");
			} else {
				throw e;
			}
		}
	}

	/**
	 * Post payment to accounting. Generate accounting document(s).
	 * 
	 * @param payment
	 * @return
	 * @throws Exception
	 */
	public List<AccDoc> post(PaymentOut payment) throws Exception {
		List<AccDoc> result = new ArrayList<AccDoc>();
		// get org schemas , for each schema generate an acc-doc
		IAccSchemaService srv = (IAccSchemaService) this
				.findEntityService(AccSchema.class);
		List<AccSchema> schemas = srv.findAll();
		for (AccSchema schema : schemas) {
			AccDoc doc = this.generateAccDoc(payment, schema);
			result.add(doc);
			this.em.persist(doc);
		}
		payment.setPosted(true);
		this.em.merge(payment);
		return result;
	}

	/**
	 * Generate accounting document from payment.
	 * 
	 * @param payment
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc generateAccDoc(PaymentOut payment, AccSchema schema)
			throws Exception {

		if (payment.getLines() != null && payment.getLines().size() > 0) {
			return this.generateAccDocExpense(payment, schema);
		} else {
			return this.generateAccDocPayment(payment, schema);
		}
	}

	/**
	 * Create accounting document header based on payment document header data.
	 * 
	 * @param payment
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc createHeader(PaymentOut payment, AccSchema schema)
			throws Exception {
		AccDoc accDoc = new AccDoc();
		accDoc.setPeriod(getPeriodService().getPostingPeriod(
				payment.getDocDate(), payment.getFromOrg()));
		accDoc.setDocDate(payment.getDocDate());
		if (payment.getDocNo() != null) {
			accDoc.setDocNo(payment.getDocNo());
		} else {
			accDoc.setDocNo(payment.getCode());
		}
		accDoc.setOrg(payment.getFromOrg());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(payment.getUuid());
		accDoc.setDocType(payment.getPaymentMethod().getDocType());
		accDoc.setJournal(payment.getPaymentMethod().getDocType().getJournal());
		accDoc.setBpartner(payment.getBpartner());
		accDoc.setDocCurrency(payment.getCurrency());
		accDoc.setDocAmount(payment.getAmount());
		accDoc.setDocNetAmount(payment.getAmount());
		accDoc.setDocTaxAmount(0F);
		return accDoc;
	}

	/**
	 * Generate an expense payment if there are expense items attached to this
	 * payment. The financial account DB with the expense items CR
	 * 
	 * @param payment
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc generateAccDocExpense(PaymentOut payment, AccSchema schema)
			throws Exception {

		AccDoc accDoc = this.createHeader(payment, schema);

		Float totalCrAmount = 0F;
		Float totalDbAmount = 0F;

		int i = 1;
		// header line - financial account

		String crAccount = this.getPayAcctService().getPostingWithdrawalAcct(
				payment.getFromAccount(), schema);

		AccDocLine line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setSequenceNo(i++);
		line.setHeaderLine(true);
		line.setCrAccount(crAccount);
		line.setCrAmount(payment.getAmount());

		accDoc.setCrAmount(line.getCrAmount());
		accDoc.addToLines(line);

		totalCrAmount = line.getCrAmount();

		// detail line(s) - expense items

		String dbAccount = null;
		Collection<PaymentItem> items = payment.getLines();
		for (PaymentItem item : items) {

			if (item.getProduct() != null) {
				dbAccount = this.getProdService().getExpenseAcct(
						item.getProduct(), payment.getFromOrg(), schema);
			} else {
				dbAccount = this.getAccItemAcctService().getDbPostingAcct(
						item.getAccItem(), schema);
			}
			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);
			line.setSequenceNo(i++);
			itemLine.setDbAccount(dbAccount);
			itemLine.setDbAmount(item.getAmount());

			accDoc.addToLines(itemLine);
			totalDbAmount += itemLine.getDbAmount();
		}

		accDoc.setCrAmount(totalCrAmount);
		accDoc.setDbAmount(totalDbAmount);
		accDoc.setDifference(Math.abs(accDoc.getDbAmount()
				- accDoc.getCrAmount()));
		return accDoc;
	}

	/**
	 * Generate a payment for a vendor liability. Vendor DB with financial
	 * account CR.
	 * 
	 * @param payment
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc generateAccDocPayment(PaymentOut payment, AccSchema schema)
			throws Exception {

		AccDoc accDoc = this.createHeader(payment, schema);

		// header line - vendor

		int i = 1;
		String dbAccount = getBpService().getPostingVendorAcct(
				payment.getBpartner(), payment.getFromOrg(), schema);
		AccDocLine line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setSequenceNo(i++);
		line.setHeaderLine(true);
		line.setDbAccount(dbAccount);
		line.setDbAmount(payment.getAmount());

		accDoc.setDbAmount(line.getDbAmount());
		accDoc.addToLines(line);

		// detail line - financial account

		String crAccount = this.getPayAcctService().getPostingWithdrawalAcct(
				payment.getFromAccount(), schema);
		line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setSequenceNo(i++);
		line.setCrAccount(crAccount);
		line.setCrAmount(payment.getAmount());

		accDoc.setCrAmount(line.getCrAmount());
		accDoc.setDifference(Math.abs(accDoc.getDbAmount()
				- accDoc.getCrAmount()));
		accDoc.addToLines(line);

		return accDoc;
	}

	protected IBusinessPartnerService getBpService() throws Exception {
		if (this.bpService == null) {
			this.bpService = (IBusinessPartnerService) this
					.findEntityService(BusinessPartner.class);
		}
		return this.bpService;
	}

	public IFiscalPeriodService getPeriodService() throws Exception {
		if (this.periodService == null) {
			this.periodService = (IFiscalPeriodService) this
					.findEntityService(FiscalPeriod.class);
		}
		return this.periodService;
	}

	public IProductService getProdService() throws Exception {
		if (this.prodService == null) {
			this.prodService = (IProductService) this
					.findEntityService(Product.class);
		}
		return this.prodService;
	}

	public IAccItemAcctService getAccItemAcctService() throws Exception {
		if (this.accItemAcctService == null) {
			this.accItemAcctService = (IAccItemAcctService) this
					.findEntityService(AccItemAcct.class);
		}
		return this.accItemAcctService;
	}

	public IFinancialAccountAcctService getPayAcctService() throws Exception {
		if (this.payAcctService == null) {
			this.payAcctService = (IFinancialAccountAcctService) this
					.findEntityService(FinancialAccountAcct.class);
		}
		return this.payAcctService;
	}

}
