/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.business.service.IDeliveryMethodService;
import net.nan21.dnet.module.bd.tx.business.service.IPaymentMethodService;
import net.nan21.dnet.module.bd.tx.business.service.IPaymentTermService;
import net.nan21.dnet.module.bd.tx.business.service.ITxDocTypeService;
import net.nan21.dnet.module.bd.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.business.service.IPriceListService;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

public class SalesOrderDsConv extends
        AbstractDsConverter<SalesOrderDs, SalesOrder> implements
        IDsConverter<SalesOrderDs, SalesOrder> {

    @Override
    protected void modelToEntityReferences(SalesOrderDs ds, SalesOrder e,
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

        if (ds.getPriceListId() != null) {
            if (e.getPriceList() == null
                    || !e.getPriceList().getId().equals(ds.getPriceListId())) {
                e.setPriceList((PriceList) this.em.find(PriceList.class,
                        ds.getPriceListId()));
            }
        } else {
            this.lookup_priceList_PriceList(ds, e);
        }

        if (ds.getInventoryId() != null) {
            if (e.getInventory() == null
                    || !e.getInventory().getId().equals(ds.getInventoryId())) {
                e.setInventory((Organization) this.em.find(Organization.class,
                        ds.getInventoryId()));
            }
        } else {
            this.lookup_inventory_Organization(ds, e);
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

        if (ds.getBillToContactId() != null) {
            if (e.getBillToContact() == null
                    || !e.getBillToContact().getId()
                            .equals(ds.getBillToContactId())) {
                e.setBillToContact((Contact) this.em.find(Contact.class,
                        ds.getBillToContactId()));
            }
        }

        if (ds.getShipToContactId() != null) {
            if (e.getShipToContact() == null
                    || !e.getShipToContact().getId()
                            .equals(ds.getShipToContactId())) {
                e.setShipToContact((Contact) this.em.find(Contact.class,
                        ds.getShipToContactId()));
            }
        }

    }

    protected void lookup_currency_Currency(SalesOrderDs ds, SalesOrder e)
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

    protected void lookup_priceList_PriceList(SalesOrderDs ds, SalesOrder e)
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

    protected void lookup_inventory_Organization(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getInventory() != null && !ds.getInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `inventory` = "
                                + ds.getInventory() + "  ");
            }
            e.setInventory(x);

        } else {
            e.setInventory(null);
        }
    }

    protected void lookup_docType_TxDocType(SalesOrderDs ds, SalesOrder e)
            throws Exception {
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

    protected void lookup_deliveryMethod_DeliveryMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
        if (ds.getDeliveryMethod() != null
                && !ds.getDeliveryMethod().equals("")) {
            DeliveryMethod x = null;
            try {
                x = ((IDeliveryMethodService) findEntityService(DeliveryMethod.class))
                        .findByName(ds.getDeliveryMethod());
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

    protected void lookup_paymentMethod_PaymentMethod(SalesOrderDs ds,
            SalesOrder e) throws Exception {
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

    protected void lookup_paymentTerm_PaymentTerm(SalesOrderDs ds, SalesOrder e)
            throws Exception {
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

    protected void lookup_customer_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
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

    protected void lookup_supplier_Organization(SalesOrderDs ds, SalesOrder e)
            throws Exception {
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

    protected void lookup_billTo_BusinessPartner(SalesOrderDs ds, SalesOrder e)
            throws Exception {
        if (ds.getBillToCode() != null && !ds.getBillToCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getBillToCode());
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
                        .findByCode(ds.getShipToCode());
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
