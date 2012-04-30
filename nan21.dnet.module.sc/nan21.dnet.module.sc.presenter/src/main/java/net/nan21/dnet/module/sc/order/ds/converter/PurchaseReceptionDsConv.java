/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDs;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

public class PurchaseReceptionDsConv extends
        AbstractDsConverter<PurchaseReceptionDs, PurchaseInventoryTransaction>
        implements
        IDsConverter<PurchaseReceptionDs, PurchaseInventoryTransaction> {

    @Override
    protected void modelToEntityReferences(PurchaseReceptionDs ds,
            PurchaseInventoryTransaction e, boolean isInsert) throws Exception {

        if (ds.getSupplierId() != null) {
            if (e.getSupplier() == null
                    || !e.getSupplier().getId().equals(ds.getSupplierId())) {
                e.setSupplier((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getSupplierId()));
            }
        } else {
            this.lookup_supplier_BusinessPartner(ds, e);
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
            if (e.getFromInventory() == null
                    || !e.getFromInventory().getId().equals(ds.getCarrierId())) {
                e.setFromInventory((Organization) this.em.find(
                        Organization.class, ds.getCarrierId()));
            }
        } else {
            this.lookup_fromInventory_Organization(ds, e);
        }

        if (ds.getWarehouseId() != null) {
            if (e.getToInventory() == null
                    || !e.getToInventory().getId().equals(ds.getWarehouseId())) {
                e.setToInventory((Organization) this.em.find(
                        Organization.class, ds.getWarehouseId()));
            }
        } else {
            this.lookup_toInventory_Organization(ds, e);
        }

    }

    protected void lookup_supplier_BusinessPartner(PurchaseReceptionDs ds,
            PurchaseInventoryTransaction e) throws Exception {
        if (ds.getSupplierCode() != null && !ds.getSupplierCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getSupplierCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `supplierCode` = "
                                + ds.getSupplierCode() + "  ");
            }
            e.setSupplier(x);

        } else {
            e.setSupplier(null);
        }
    }

    protected void lookup_transactionType_InvTransactionType(
            PurchaseReceptionDs ds, PurchaseInventoryTransaction e)
            throws Exception {
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

    protected void lookup_fromInventory_Organization(PurchaseReceptionDs ds,
            PurchaseInventoryTransaction e) throws Exception {
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
            e.setFromInventory(x);

        } else {
            e.setFromInventory(null);
        }
    }

    protected void lookup_toInventory_Organization(PurchaseReceptionDs ds,
            PurchaseInventoryTransaction e) throws Exception {
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
            e.setToInventory(x);

        } else {
            e.setToInventory(null);
        }
    }

}
