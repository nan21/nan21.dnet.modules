package net.nan21.dnet.module.sd._businessdelegates.invoice;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public class SalesInvoiceToAccDocBD extends AbstractBusinessDelegate {

	public List<AccDoc> postInvoice(SalesInvoice invoice) throws Exception {

		List<AccDoc> result = new ArrayList<AccDoc>();
		// get org schemas , for each schema generate an acc-doc
		IAccSchemaService srv = (IAccSchemaService) this
				.findEntityService(AccSchema.class);
		List<AccSchema> schemas = srv.findAll();
		for (AccSchema schema : schemas) {
			result.add(this.generateAccDoc(invoice, schema));
		}
		return result;

	}

	protected AccDoc generateAccDoc(SalesInvoice invoice, AccSchema schema)
			throws Exception {
		AccDoc doc = new AccDoc();
		doc.setDocDate(invoice.getDocDate());
		doc.setOrg(invoice.getSupplier());

		doc.setAccSchema(schema);
		return doc;

	}

}
