/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

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

}
