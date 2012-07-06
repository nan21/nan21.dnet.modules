/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentTermService;
import net.nan21.dnet.module.md.base.tx.business.service.ITxDocTypeService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

public class PurchaseInvoiceDsConv extends
        AbstractDsConverter<PurchaseInvoiceDs, PurchaseInvoice> implements
        IDsConverter<PurchaseInvoiceDs, PurchaseInvoice> {

    @Override
    protected void modelToEntityReferences(PurchaseInvoiceDs ds,
            PurchaseInvoice e, boolean isInsert) throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }

        if (ds.getPaymentMethodId() != null) {
            if (e.getPaymentMethod() == null
                    || !e.getPaymentMethod().getId()
                            .equals(ds.getPaymentMethodId())) {
                e.setPaymentMethod((PaymentMethod) this.em.find(
                        PaymentMethod.class, ds.getPaymentMethodId()));
            }
        } else {
            this.lookup_paymentMethod_PaymentMethod(ds, e);
        }

        if (ds.getPaymentTermId() != null) {
            if (e.getPaymentTerm() == null
                    || !e.getPaymentTerm().getId()
                            .equals(ds.getPaymentTermId())) {
                e.setPaymentTerm((PaymentTerm) this.em.find(PaymentTerm.class,
                        ds.getPaymentTermId()));
            }
        } else {
            this.lookup_paymentTerm_PaymentTerm(ds, e);
        }

        if (ds.getDocTypeId() != null) {
            if (e.getDocType() == null
                    || !e.getDocType().getId().equals(ds.getDocTypeId())) {
                e.setDocType((TxDocType) this.em.find(TxDocType.class,
                        ds.getDocTypeId()));
            }
        } else {
            this.lookup_docType_TxDocType(ds, e);
        }

        if (isInsert) {
            if (ds.getSupplierId() != null) {
                if (e.getSupplier() == null
                        || !e.getSupplier().getId().equals(ds.getSupplierId())) {
                    e.setSupplier((BusinessPartner) this.em.find(
                            BusinessPartner.class, ds.getSupplierId()));
                }
            } else {
                this.lookup_supplier_BusinessPartner(ds, e);
            }
        }

        if (isInsert) {
            if (ds.getCustomerId() != null) {
                if (e.getCustomer() == null
                        || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                    e.setCustomer((Organization) this.em.find(
                            Organization.class, ds.getCustomerId()));
                }
            } else {
                this.lookup_customer_Organization(ds, e);
            }
        }

        if (ds.getFromAccountId() != null) {
            if (e.getFromAccount() == null
                    || !e.getFromAccount().getId()
                            .equals(ds.getFromAccountId())) {
                e.setFromAccount((FinancialAccount) this.em.find(
                        FinancialAccount.class, ds.getFromAccountId()));
            }
        } else {
            this.lookup_fromAccount_FinancialAccount(ds, e);
        }

    }

    protected void lookup_currency_Currency(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getCurrency());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Currency` reference:  `currency` = "
                                + ds.getCurrency() + "  ");
            }
            e.setCurrency(x);

        } else {
            e.setCurrency(null);
        }
    }

    protected void lookup_paymentMethod_PaymentMethod(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getPaymentMethod() != null && !ds.getPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
                        .findByName(ds.getPaymentMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentMethod` reference:  `paymentMethod` = "
                                + ds.getPaymentMethod() + "  ");
            }
            e.setPaymentMethod(x);

        } else {
            e.setPaymentMethod(null);
        }
    }

    protected void lookup_paymentTerm_PaymentTerm(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getPaymentTerm() != null && !ds.getPaymentTerm().equals("")) {
            PaymentTerm x = null;
            try {
                x = ((IPaymentTermService) findEntityService(PaymentTerm.class))
                        .findByName(ds.getPaymentTerm());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PaymentTerm` reference:  `paymentTerm` = "
                                + ds.getPaymentTerm() + "  ");
            }
            e.setPaymentTerm(x);

        } else {
            e.setPaymentTerm(null);
        }
    }

    protected void lookup_docType_TxDocType(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getDocType() != null && !ds.getDocType().equals("")) {
            TxDocType x = null;
            try {
                x = ((ITxDocTypeService) findEntityService(TxDocType.class))
                        .findByName(ds.getDocType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `TxDocType` reference:  `docType` = "
                                + ds.getDocType() + "  ");
            }
            e.setDocType(x);

        } else {
            e.setDocType(null);
        }
    }

    protected void lookup_supplier_BusinessPartner(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getSupplier() != null && !ds.getSupplier().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getSupplier());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `supplier` = "
                                + ds.getSupplier() + "  ");
            }
            e.setSupplier(x);

        } else {
            e.setSupplier(null);
        }
    }

    protected void lookup_customer_Organization(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getCustomer() != null && !ds.getCustomer().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getCustomer());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `customer` = "
                                + ds.getCustomer() + "  ");
            }
            e.setCustomer(x);

        } else {
            e.setCustomer(null);
        }
    }

    protected void lookup_fromAccount_FinancialAccount(PurchaseInvoiceDs ds,
            PurchaseInvoice e) throws Exception {
        if (ds.getFromAccount() != null && !ds.getFromAccount().equals("")) {
            FinancialAccount x = null;
            try {
                x = ((IFinancialAccountService) findEntityService(FinancialAccount.class))
                        .findByName(ds.getFromAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `FinancialAccount` reference:  `fromAccount` = "
                                + ds.getFromAccount() + "  ");
            }
            e.setFromAccount(x);

        } else {
            e.setFromAccount(null);
        }
    }

}
