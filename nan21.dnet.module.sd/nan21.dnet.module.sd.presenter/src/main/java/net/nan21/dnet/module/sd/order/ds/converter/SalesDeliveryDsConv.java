/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.fin.business.service.IFinDocTypeService;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;

public class SalesDeliveryDsConv extends
        AbstractDsConverter<SalesDeliveryDs, SalesInventoryTransaction>
        implements IDsConverter<SalesDeliveryDs, SalesInventoryTransaction> {

    @Override
    protected void modelToEntityReferences(SalesDeliveryDs ds,
            SalesInventoryTransaction e, boolean isInsert) throws Exception {

        if (ds.getCustomerId() != null) {
            if (e.getCustomer() == null
                    || !e.getCustomer().getId().equals(ds.getCustomerId())) {
                e.setCustomer((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getCustomerId()));
            }
        } else {
            this.lookup_customer_BusinessPartner(ds, e);
        }

        if (ds.getDocTypeId() != null) {
            if (e.getDocType() == null
                    || !e.getDocType().getId().equals(ds.getDocTypeId())) {
                e.setDocType((FinDocType) this.em.find(FinDocType.class,
                        ds.getDocTypeId()));
            }
        } else {
            this.lookup_docType_FinDocType(ds, e);
        }

        if (ds.getTransactionTypeId() != null) {
            if (e.getTransactionType() == null
                    || !e.getTransactionType().getId()
                            .equals(ds.getTransactionTypeId())) {
                e.setTransactionType((InvTransactionType) this.em.find(
                        InvTransactionType.class, ds.getTransactionTypeId()));
            }
        } else {
            this.lookup_transactionType_InvTransactionType(ds, e);
        }

        if (ds.getCarrierId() != null) {
            if (e.getToInventory() == null
                    || !e.getToInventory().getId().equals(ds.getCarrierId())) {
                e.setToInventory((Organization) this.em.find(
                        Organization.class, ds.getCarrierId()));
            }
        } else {
            this.lookup_toInventory_Organization(ds, e);
        }

        if (ds.getWarehouseId() != null) {
            if (e.getFromInventory() == null
                    || !e.getFromInventory().getId()
                            .equals(ds.getWarehouseId())) {
                e.setFromInventory((Organization) this.em.find(
                        Organization.class, ds.getWarehouseId()));
            }
        } else {
            this.lookup_fromInventory_Organization(ds, e);
        }

    }

    protected void lookup_customer_BusinessPartner(SalesDeliveryDs ds,
            SalesInventoryTransaction e) throws Exception {
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

    protected void lookup_docType_FinDocType(SalesDeliveryDs ds,
            SalesInventoryTransaction e) throws Exception {
        if (ds.getDocType() != null && !ds.getDocType().equals("")) {
            FinDocType x = null;
            try {
                x = ((IFinDocTypeService) findEntityService(FinDocType.class))
                        .findByName(ds.getDocType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `FinDocType` reference:  `docType` = "
                                + ds.getDocType() + "  ");
            }
            e.setDocType(x);

        } else {
            e.setDocType(null);
        }
    }

    protected void lookup_transactionType_InvTransactionType(
            SalesDeliveryDs ds, SalesInventoryTransaction e) throws Exception {
        if (ds.getTransactionType() != null
                && !ds.getTransactionType().equals("")) {
            InvTransactionType x = null;
            try {
                x = ((IInvTransactionTypeService) findEntityService(InvTransactionType.class))
                        .findByName(ds.getTransactionType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `InvTransactionType` reference:  `transactionType` = "
                                + ds.getTransactionType() + "  ");
            }
            e.setTransactionType(x);

        } else {
            e.setTransactionType(null);
        }
    }

    protected void lookup_toInventory_Organization(SalesDeliveryDs ds,
            SalesInventoryTransaction e) throws Exception {
        if (ds.getCarrier() != null && !ds.getCarrier().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByName(ds.getCarrier());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `carrier` = "
                                + ds.getCarrier() + "  ");
            }
            e.setToInventory(x);

        } else {
            e.setToInventory(null);
        }
    }

    protected void lookup_fromInventory_Organization(SalesDeliveryDs ds,
            SalesInventoryTransaction e) throws Exception {
        if (ds.getWarehouse() != null && !ds.getWarehouse().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByName(ds.getWarehouse());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `warehouse` = "
                                + ds.getWarehouse() + "  ");
            }
            e.setFromInventory(x);

        } else {
            e.setFromInventory(null);
        }
    }

}
