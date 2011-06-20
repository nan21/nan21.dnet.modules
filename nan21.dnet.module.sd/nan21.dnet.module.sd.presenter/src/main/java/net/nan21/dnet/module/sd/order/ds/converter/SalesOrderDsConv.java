/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.service.ICurrencyService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.service.IDeliveryMethodService;
import net.nan21.dnet.module.bp.base.domain.service.IPaymentMethodService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.service.IBusinessPartnerService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;
import net.nan21.dnet.module.sd.order.domain.service.ISalesOrderStatusService;
import net.nan21.dnet.module.sd.order.domain.service.ISalesOrderTypeService;
import net.nan21.dnet.module.sd.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.price.domain.service.IPriceListService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

public class SalesOrderDsConv extends
        AbstractDsConverter<SalesOrderDs, SalesOrder> implements
        IDsConverter<SalesOrderDs, SalesOrder> {

    protected void modelToEntityAttributes(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDocNo(ds.getDocNo());
        e.setDocDate(ds.getDocDate());
        e.setTotalAmount(ds.getTotalAmount());
        e.setTotalNetAmount(ds.getTotalNetAmount());
        e.setTotalTaxAmount(ds.getTotalTaxAmount());
        e.setClassName(ds.getClassName());
    }

    protected void modelToEntityReferences(SalesOrderDs ds, SalesOrder e)
            throws Exception {

        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.getReference(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }
        if (ds.getPriceListId() != null) {
            if (e.getPriceList() == null
                    || !e.getPriceList().getId().equals(ds.getPriceListId())) {
                e.setPriceList((PriceList) this.em.getReference(
                        PriceList.class, ds.getPriceListId()));
            }
        } else {
            this.lookup_priceList_PriceList(ds, e);
        }
        if (ds.getDeliveryMethodId() != null) {
            if (e.getDeliveryMethod() == null
                    || !e.getDeliveryMethod().getId()
                            .equals(ds.getDeliveryMethodId())) {
                e.setDeliveryMethod((DeliveryMethod) this.em.getReference(
                        DeliveryMethod.class, ds.getDeliveryMethodId()));
            }
        } else {
            this.lookup_deliveryMethod_DeliveryMethod(ds, e);
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((SalesOrderType) this.em.getReference(
                        SalesOrderType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_SalesOrderType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((SalesOrderStatus) this.em.getReference(
                        SalesOrderStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_SalesOrderStatus(ds, e);
        }
        if (ds.getPaymentMethodId() != null) {
            if (e.getPaymentMethod() == null
                    || !e.getPaymentMethod().getId()
                            .equals(ds.getPaymentMethodId())) {
                e.setPaymentMethod((PaymentMethod) this.em.getReference(
                        PaymentMethod.class, ds.getPaymentMethodId()));
            }
        } else {
            this.lookup_paymentMethod_PaymentMethod(ds, e);
        }
        if (ds.getCustomerId() != null) {
            if (e.getCustomer() == null
                    || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                e.setCustomer((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getCustomerId()));
            }
        } else {
            this.lookup_customer_BusinessPartner(ds, e);
        }
        if (ds.getSupplierId() != null) {
            if (e.getSupplier() == null
                    || !e.getSupplier().getId().equals(ds.getSupplierId())) {
                e.setSupplier((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getSupplierId()));
            }
        } else {
            this.lookup_supplier_BusinessPartner(ds, e);
        }
        if (ds.getBillToId() != null) {
            if (e.getBillTo() == null
                    || !e.getBillTo().getId().equals(ds.getBillToId())) {
                e.setBillTo((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getBillToId()));
            }
        } else {
            this.lookup_billTo_BusinessPartner(ds, e);
        }
        if (ds.getShipToId() != null) {
            if (e.getShipTo() == null
                    || !e.getShipTo().getId().equals(ds.getShipToId())) {
                e.setShipTo((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getShipToId()));
            }
        } else {
            this.lookup_shipTo_BusinessPartner(ds, e);
        }
        if (ds.getBillToLocationId() != null) {
            if (e.getBillToLocation() == null
                    || !e.getBillToLocation().getId()
                            .equals(ds.getBillToLocationId())) {
                e.setBillToLocation((Location) this.em.getReference(
                        Location.class, ds.getBillToLocationId()));
            }
        }
        if (ds.getShipToLocationId() != null) {
            if (e.getShipToLocation() == null
                    || !e.getShipToLocation().getId()
                            .equals(ds.getShipToLocationId())) {
                e.setShipToLocation((Location) this.em.getReference(
                        Location.class, ds.getShipToLocationId()));
            }
        }
    }

    protected void lookup_currency_Currency(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        Currency x = null;
        try {
            x = ((ICurrencyService) getService(ICurrencyService.class))
                    .findByCode(ds.getClientId(), ds.getCurrencyCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCurrency(x);
    }

    protected void lookup_priceList_PriceList(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        PriceList x = null;
        try {
            x = ((IPriceListService) getService(IPriceListService.class))
                    .findByName(ds.getClientId(), ds.getPriceListName());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setPriceList(x);
    }

    protected void lookup_deliveryMethod_DeliveryMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
        DeliveryMethod x = null;
        try {
            x = ((IDeliveryMethodService) getService(IDeliveryMethodService.class))
                    .findByName(ds.getClientId(), ds.getDeliveryMethod());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setDeliveryMethod(x);
    }

    protected void lookup_type_SalesOrderType(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        SalesOrderType x = null;
        try {
            x = ((ISalesOrderTypeService) getService(ISalesOrderTypeService.class))
                    .findByName(ds.getClientId(), ds.getType());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setType(x);
    }

    protected void lookup_status_SalesOrderStatus(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        SalesOrderStatus x = null;
        try {
            x = ((ISalesOrderStatusService) getService(ISalesOrderStatusService.class))
                    .findByName(ds.getClientId(), ds.getStatus());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setStatus(x);
    }

    protected void lookup_paymentMethod_PaymentMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
        PaymentMethod x = null;
        try {
            x = ((IPaymentMethodService) getService(IPaymentMethodService.class))
                    .findByName(ds.getClientId(), ds.getPaymentMethod());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setPaymentMethod(x);
    }

    protected void lookup_customer_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getCustomerCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCustomer(x);
    }

    protected void lookup_supplier_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getSupplierCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setSupplier(x);
    }

    protected void lookup_billTo_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getBillToCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setBillTo(x);
    }

    protected void lookup_shipTo_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        BusinessPartner x = null;
        try {
            x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                    .findByCode(ds.getClientId(), ds.getShipToCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setShipTo(x);
    }

    @Override
    public void entityToModel(SalesOrder e, SalesOrderDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDocNo(e.getDocNo());
        ds.setDocDate(e.getDocDate());
        ds.setTotalAmount(e.getTotalAmount());
        ds.setTotalNetAmount(e.getTotalNetAmount());
        ds.setTotalTaxAmount(e.getTotalTaxAmount());
        ds.setClassName(e.getClassName());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setStatusId(((e.getStatus() != null)) ? e.getStatus().getId() : null);
        ds.setStatus(((e.getStatus() != null)) ? e.getStatus().getName() : null);
        ds.setCustomerId(((e.getCustomer() != null)) ? e.getCustomer().getId()
                : null);
        ds.setCustomerCode(((e.getCustomer() != null)) ? e.getCustomer()
                .getCode() : null);
        ds.setCurrencyId(((e.getCurrency() != null)) ? e.getCurrency().getId()
                : null);
        ds.setCurrencyCode(((e.getCurrency() != null)) ? e.getCurrency()
                .getCode() : null);
        ds.setPriceListId(((e.getPriceList() != null)) ? e.getPriceList()
                .getId() : null);
        ds.setPriceListName(((e.getPriceList() != null)) ? e.getPriceList()
                .getName() : null);
        ds.setPaymentMethodId(((e.getPaymentMethod() != null)) ? e
                .getPaymentMethod().getId() : null);
        ds.setPaymentMethod(((e.getPaymentMethod() != null)) ? e
                .getPaymentMethod().getName() : null);
        ds.setDeliveryMethodId(((e.getDeliveryMethod() != null)) ? e
                .getDeliveryMethod().getId() : null);
        ds.setDeliveryMethod(((e.getDeliveryMethod() != null)) ? e
                .getDeliveryMethod().getName() : null);
        ds.setSupplierId(((e.getSupplier() != null)) ? e.getSupplier().getId()
                : null);
        ds.setSupplierCode(((e.getSupplier() != null)) ? e.getSupplier()
                .getCode() : null);
        ds.setBillToId(((e.getBillTo() != null)) ? e.getBillTo().getId() : null);
        ds.setBillToCode(((e.getBillTo() != null)) ? e.getBillTo().getCode()
                : null);
        ds.setBillToLocationId(((e.getBillToLocation() != null)) ? e
                .getBillToLocation().getId() : null);
        ds.setBillToLocation(((e.getBillToLocation() != null)) ? e
                .getBillToLocation().getAsString() : null);
        ds.setShipToId(((e.getShipTo() != null)) ? e.getShipTo().getId() : null);
        ds.setShipToCode(((e.getShipTo() != null)) ? e.getShipTo().getCode()
                : null);
        ds.setShipToLocationId(((e.getShipToLocation() != null)) ? e
                .getShipToLocation().getId() : null);
        ds.setShipToLocation(((e.getShipToLocation() != null)) ? e
                .getShipToLocation().getAsString() : null);
    }

}
