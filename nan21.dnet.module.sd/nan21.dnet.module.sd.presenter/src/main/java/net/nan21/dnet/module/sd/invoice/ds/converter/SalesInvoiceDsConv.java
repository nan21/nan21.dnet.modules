/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;
import net.nan21.dnet.module.mm.price.business.service.IPriceListService;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public class SalesInvoiceDsConv extends
        AbstractDsConverter<SalesInvoiceDs, SalesInvoice> implements
        IDsConverter<SalesInvoiceDs, SalesInvoice> {

    @Override
    protected void modelToEntityReferences(SalesInvoiceDs ds, SalesInvoice e,
            boolean isInsert) throws Exception {

        if (isInsert) {
            if (ds.getCurrencyId() != null) {
                if (e.getCurrency() == null
                        || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                    e.setCurrency((Currency) this.em.find(Currency.class,
                            ds.getCurrencyId()));
                }
            } else {
                this.lookup_currency_Currency(ds, e);
            }
        }

        if (ds.getPriceListId() != null) {
            if (e.getPriceList() == null
                    || !e.getPriceList().getId().equals(ds.getPriceListId())) {
                e.setPriceList((PriceList) this.em.find(PriceList.class,
                        ds.getPriceListId()));
            }
        } else {
            this.lookup_priceList_PriceList(ds, e);
        }

        if (isInsert) {
            if (ds.getSupplierId() != null) {
                if (e.getSupplier() == null
                        || !e.getSupplier().getId().equals(ds.getSupplierId())) {
                    e.setSupplier((Organization) this.em.find(
                            Organization.class, ds.getSupplierId()));
                }
            } else {
                this.lookup_supplier_Organization(ds, e);
            }
        }

        if (isInsert) {
            if (ds.getCustomerId() != null) {
                if (e.getCustomer() == null
                        || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                    e.setCustomer((BusinessPartner) this.em.find(
                            BusinessPartner.class, ds.getCustomerId()));
                }
            } else {
                this.lookup_customer_BusinessPartner(ds, e);
            }
        }

        if (ds.getBillToContactId() != null) {
            if (e.getBillToContact() == null
                    || !e.getBillToContact().getId()
                            .equals(ds.getBillToContactId())) {
                e.setBillToContact((Contact) this.em.find(Contact.class,
                        ds.getBillToContactId()));
            }
        }

        if (ds.getBillToLocationId() != null) {
            if (e.getBillToLocation() == null
                    || !e.getBillToLocation().getId()
                            .equals(ds.getBillToLocationId())) {
                e.setBillToLocation((Location) this.em.find(Location.class,
                        ds.getBillToLocationId()));
            }
        }

    }

    protected void lookup_currency_Currency(SalesInvoiceDs ds, SalesInvoice e)
            throws Exception {
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

    protected void lookup_priceList_PriceList(SalesInvoiceDs ds, SalesInvoice e)
            throws Exception {
        if (ds.getPriceList() != null && !ds.getPriceList().equals("")) {
            PriceList x = null;
            try {
                x = ((IPriceListService) findEntityService(PriceList.class))
                        .findByName(ds.getPriceList());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PriceList` reference:  `priceList` = "
                                + ds.getPriceList() + "  ");
            }
            e.setPriceList(x);

        } else {
            e.setPriceList(null);
        }
    }

    protected void lookup_supplier_Organization(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getSupplier() != null && !ds.getSupplier().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getSupplier());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `supplier` = "
                                + ds.getSupplier() + "  ");
            }
            e.setSupplier(x);

        } else {
            e.setSupplier(null);
        }
    }

    protected void lookup_customer_BusinessPartner(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getCustomerCode() != null && !ds.getCustomerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getCustomerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `customerCode` = "
                                + ds.getCustomerCode() + "  ");
            }
            e.setCustomer(x);

        } else {
            e.setCustomer(null);
        }
    }

}
