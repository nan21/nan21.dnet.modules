/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
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

    protected void modelToEntityAttributes(SalesInvoiceDs ds, SalesInvoice e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDocNo(ds.getDocNo());
        e.setDocDate(ds.getDocDate());
        e.setTotalNetAmount(ds.getTotalNetAmount());
        e.setTotalTaxAmount(ds.getTotalTaxAmount());
        e.setTotalAmount(ds.getTotalAmount());
        e.setClassName(ds.getClassName());
    }

    protected void modelToEntityReferences(SalesInvoiceDs ds, SalesInvoice e)
            throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
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

    protected void lookup_type_SalesInvoiceType(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            SalesInvoiceType x = null;
            try {
                x = ((ISalesInvoiceTypeService) getService(ISalesInvoiceTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
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
                x = ((ISalesInvoiceStatusService) getService(ISalesInvoiceStatusService.class))
                        .findByName(ds.getClientId(), ds.getStatus());
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

    protected void lookup_customer_BusinessPartner(SalesInvoiceDs ds,
            SalesInvoice e) throws Exception {
        if (ds.getCustomerCode() != null && !ds.getCustomerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                        .findByCode(ds.getClientId(), ds.getCustomerCode());
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

    @Override
    public void entityToModel(SalesInvoice e, SalesInvoiceDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDocNo(e.getDocNo());
        ds.setDocDate(e.getDocDate());
        ds.setTotalNetAmount(e.getTotalNetAmount());
        ds.setTotalTaxAmount(e.getTotalTaxAmount());
        ds.setTotalAmount(e.getTotalAmount());
        ds.setClassName(e.getClassName());
        ds.setStatusId(((e.getStatus() != null)) ? e.getStatus().getId() : null);
        ds.setStatus(((e.getStatus() != null)) ? e.getStatus().getName() : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setCurrencyId(((e.getCurrency() != null)) ? e.getCurrency().getId()
                : null);
        ds.setCurrencyCode(((e.getCurrency() != null)) ? e.getCurrency()
                .getCode() : null);
        ds.setCustomerId(((e.getCustomer() != null)) ? e.getCustomer().getId()
                : null);
        ds.setCustomerCode(((e.getCustomer() != null)) ? e.getCustomer()
                .getCode() : null);
        ds.setBillToLocationId(((e.getBillToLocation() != null)) ? e
                .getBillToLocation().getId() : null);
        ds.setBillToLocation(((e.getBillToLocation() != null)) ? e
                .getBillToLocation().getAsString() : null);
        ds.setBillToContactId(((e.getBillToContact() != null)) ? e
                .getBillToContact().getId() : null);
        ds.setBillToContact(((e.getBillToContact() != null)) ? e
                .getBillToContact().getName() : null);
        ds.setSupplierId(((e.getSupplier() != null)) ? e.getSupplier().getId()
                : null);
        ds.setSupplierCode(((e.getSupplier() != null)) ? e.getSupplier()
                .getCode() : null);
        ds.setSalesOrderId(((e.getSalesOrder() != null)) ? e.getSalesOrder()
                .getId() : null);
    }

}
