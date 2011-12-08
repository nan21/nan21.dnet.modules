/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.business.service.IDeliveryMethodService;
import net.nan21.dnet.module.bp.base.business.service.IPaymentMethodService;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderStatusService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderTypeService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

public class SalesOrderDsConv extends
        AbstractDsConverter<SalesOrderDs, SalesOrder> implements
        IDsConverter<SalesOrderDs, SalesOrder> {

    protected void modelToEntityReferences(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getCurrencyId() != null) {
            if (e.getCurrency() == null
                    || !e.getCurrency().getId().equals(ds.getCurrencyId())) {
                e.setCurrency((Currency) this.em.find(Currency.class,
                        ds.getCurrencyId()));
            }
        } else {
            this.lookup_currency_Currency(ds, e);
        }
        if (ds.getDeliveryMethodId() != null) {
            if (e.getDeliveryMethod() == null
                    || !e.getDeliveryMethod().getId()
                            .equals(ds.getDeliveryMethodId())) {
                e.setDeliveryMethod((DeliveryMethod) this.em.find(
                        DeliveryMethod.class, ds.getDeliveryMethodId()));
            }
        } else {
            this.lookup_deliveryMethod_DeliveryMethod(ds, e);
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((SalesOrderType) this.em.find(SalesOrderType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_SalesOrderType(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((SalesOrderStatus) this.em.find(
                        SalesOrderStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_SalesOrderStatus(ds, e);
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
        if (ds.getCustomerId() != null) {
            if (e.getCustomer() == null
                    || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                e.setCustomer((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getCustomerId()));
            }
        } else {
            this.lookup_customer_BusinessPartner(ds, e);
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
        if (ds.getBillToId() != null) {
            if (e.getBillTo() == null
                    || !e.getBillTo().getId().equals(ds.getBillToId())) {
                e.setBillTo((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getBillToId()));
            }
        } else {
            this.lookup_billTo_BusinessPartner(ds, e);
        }
        if (ds.getShipToId() != null) {
            if (e.getShipTo() == null
                    || !e.getShipTo().getId().equals(ds.getShipToId())) {
                e.setShipTo((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getShipToId()));
            }
        } else {
            this.lookup_shipTo_BusinessPartner(ds, e);
        }
        if (ds.getBillToLocationId() != null) {
            if (e.getBillToLocation() == null
                    || !e.getBillToLocation().getId()
                            .equals(ds.getBillToLocationId())) {
                e.setBillToLocation((Location) this.em.find(Location.class,
                        ds.getBillToLocationId()));
            }
        }
        if (ds.getShipToLocationId() != null) {
            if (e.getShipToLocation() == null
                    || !e.getShipToLocation().getId()
                            .equals(ds.getShipToLocationId())) {
                e.setShipToLocation((Location) this.em.find(Location.class,
                        ds.getShipToLocationId()));
            }
        }
    }

    protected void lookup_currency_Currency(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getCurrency() != null && !ds.getCurrency().equals("")) {
            Currency x = null;
            try {
                x = ((ICurrencyService) findEntityService(Currency.class))
                        .findByCode(ds.getClientId(), ds.getCurrency());
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

    protected void lookup_deliveryMethod_DeliveryMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
        if (ds.getDeliveryMethod() != null
                && !ds.getDeliveryMethod().equals("")) {
            DeliveryMethod x = null;
            try {
                x = ((IDeliveryMethodService) findEntityService(DeliveryMethod.class))
                        .findByName(ds.getClientId(), ds.getDeliveryMethod());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `DeliveryMethod` reference:  `deliveryMethod` = "
                                + ds.getDeliveryMethod() + "  ");
            }
            e.setDeliveryMethod(x);

        } else {
            e.setDeliveryMethod(null);
        }
    }

    protected void lookup_type_SalesOrderType(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            SalesOrderType x = null;
            try {
                x = ((ISalesOrderTypeService) findEntityService(SalesOrderType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SalesOrderType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_status_SalesOrderStatus(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getStatus() != null && !ds.getStatus().equals("")) {
            SalesOrderStatus x = null;
            try {
                x = ((ISalesOrderStatusService) findEntityService(SalesOrderStatus.class))
                        .findByName(ds.getClientId(), ds.getStatus());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SalesOrderStatus` reference:  `status` = "
                                + ds.getStatus() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
        }
    }

    protected void lookup_paymentMethod_PaymentMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
        if (ds.getPaymentMethod() != null && !ds.getPaymentMethod().equals("")) {
            PaymentMethod x = null;
            try {
                x = ((IPaymentMethodService) findEntityService(PaymentMethod.class))
                        .findByName(ds.getClientId(), ds.getPaymentMethod());
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

    protected void lookup_customer_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getCustomerCode() != null && !ds.getCustomerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
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

    protected void lookup_supplier_Organization(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getSupplier() != null && !ds.getSupplier().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getClientId(), ds.getSupplier());
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

    protected void lookup_billTo_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getBillToCode() != null && !ds.getBillToCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getClientId(), ds.getBillToCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `billToCode` = "
                                + ds.getBillToCode() + "  ");
            }
            e.setBillTo(x);

        } else {
            e.setBillTo(null);
        }
    }

    protected void lookup_shipTo_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getShipToCode() != null && !ds.getShipToCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getClientId(), ds.getShipToCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `shipToCode` = "
                                + ds.getShipToCode() + "  ");
            }
            e.setShipTo(x);

        } else {
            e.setShipTo(null);
        }
    }

}
