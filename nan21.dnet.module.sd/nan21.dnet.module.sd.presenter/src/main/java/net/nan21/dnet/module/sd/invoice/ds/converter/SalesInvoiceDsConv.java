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
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceStatusService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceTypeService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

public class SalesInvoiceDsConv extends
        AbstractDsConverter<SalesInvoiceDs, SalesInvoice> implements
        IDsConverter<SalesInvoiceDs, SalesInvoice> {

    @Override
    protected void modelToEntityReferences(SalesInvoiceDs ds, SalesInvoice e,
            boolean isInsert) throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((SalesInvoiceType) this.em.find(
                        SalesInvoiceType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_SalesInvoiceType(ds, e);
        }

        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((SalesInvoiceStatus) this.em.find(
                        SalesInvoiceStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_SalesInvoiceStatus(ds, e);
        }

        if (ds.getSupplierId() != null) {
            if (e.getSupplier() == null
                    || !e.getSupplier().getId().equals(ds.getSupplierId())) {
                e.setSupplier((Organization) this.em.find(Organization.class,
                        ds.getSupplierId()));
            }
        } else {
            this.lookup_supplier_Organization(ds, e);
        }

        if (ds.getCustomerId() != null) {
            if (e.getCustomer() == null
                    || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                e.setCustomer((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getCustomerId()));
            }
        } else {
            this.lookup_customer_BusinessPartner(ds, e);
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

    protected void lookup_type_SalesInvoiceType(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            SalesInvoiceType x = null;
            try {
                x = ((ISalesInvoiceTypeService) findEntityService(SalesInvoiceType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SalesInvoiceType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_SalesInvoiceStatus(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            SalesInvoiceStatus x = null;
            try {
                x = ((ISalesInvoiceStatusService) findEntityService(SalesInvoiceStatus.class))
                        .findByName(ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SalesInvoiceStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
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
