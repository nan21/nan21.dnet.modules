/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;

public class InvTransactionDsConv extends
        AbstractDsConverter<InvTransactionDs, InvTransaction> implements
        IDsConverter<InvTransactionDs, InvTransaction> {

    protected void modelToEntityAttributes(InvTransactionDs ds, InvTransaction e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setEventDate(ds.getEventDate());
    }

    protected void modelToEntityReferences(InvTransactionDs ds, InvTransaction e)
            throws Exception {

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
        if (ds.getFromInventoryId() != null) {
            if (e.getFromInventory() == null
                    || !e.getFromInventory().getId()
                            .equals(ds.getFromInventoryId())) {
                e.setFromInventory((Organization) this.em.find(
                        Organization.class, ds.getFromInventoryId()));
            }
        } else {
            this.lookup_fromInventory_Organization(ds, e);
        }
        if (ds.getToInventoryId() != null) {
            if (e.getToInventory() == null
                    || !e.getToInventory().getId()
                            .equals(ds.getToInventoryId())) {
                e.setToInventory((Organization) this.em.find(
                        Organization.class, ds.getToInventoryId()));
            }
        } else {
            this.lookup_toInventory_Organization(ds, e);
        }
    }

    protected void lookup_transactionType_InvTransactionType(
            InvTransactionDs ds, InvTransaction e) throws Exception {
        if (ds.getTransactionType() != null
                && !ds.getTransactionType().equals("")) {
            InvTransactionType x = null;
            try {
                x = ((IInvTransactionTypeService) getService(IInvTransactionTypeService.class))
                        .findByName(ds.getClientId(), ds.getTransactionType());
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

    protected void lookup_fromInventory_Organization(InvTransactionDs ds,
            InvTransaction e) throws Exception {
        if (ds.getFromInventory() != null && !ds.getFromInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) getService(IOrganizationService.class))
                        .findByName(ds.getClientId(), ds.getFromInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `fromInventory` = "
                                + ds.getFromInventory() + "  ");
            }
            e.setFromInventory(x);
        } else {
            e.setFromInventory(null);
        }
    }

    protected void lookup_toInventory_Organization(InvTransactionDs ds,
            InvTransaction e) throws Exception {
        if (ds.getToInventory() != null && !ds.getToInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) getService(IOrganizationService.class))
                        .findByName(ds.getClientId(), ds.getToInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `toInventory` = "
                                + ds.getToInventory() + "  ");
            }
            e.setToInventory(x);
        } else {
            e.setToInventory(null);
        }
    }

    @Override
    public void entityToModel(InvTransaction e, InvTransactionDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setEventDate(e.getEventDate());
        ds.setTransactionTypeId(((e.getTransactionType() != null)) ? e
                .getTransactionType().getId() : null);
        ds.setTransactionType(((e.getTransactionType() != null)) ? e
                .getTransactionType().getName() : null);
        ds.setFromInventoryId(((e.getFromInventory() != null)) ? e
                .getFromInventory().getId() : null);
        ds.setFromInventory(((e.getFromInventory() != null)) ? e
                .getFromInventory().getCode() : null);
        ds.setToInventoryId(((e.getToInventory() != null)) ? e.getToInventory()
                .getId() : null);
        ds.setToInventory(((e.getToInventory() != null)) ? e.getToInventory()
                .getCode() : null);
    }

}
