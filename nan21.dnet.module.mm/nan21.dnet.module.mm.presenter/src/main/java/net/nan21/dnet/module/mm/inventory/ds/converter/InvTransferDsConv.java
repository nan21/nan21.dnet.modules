/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.fin.business.service.IFinDocTypeService;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionTypeService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransferDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransfer;

public class InvTransferDsConv extends
        AbstractDsConverter<InvTransferDs, InvTransfer> implements
        IDsConverter<InvTransferDs, InvTransfer> {

    @Override
    protected void modelToEntityReferences(InvTransferDs ds, InvTransfer e,
            boolean isInsert) throws Exception {

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

    protected void lookup_docType_FinDocType(InvTransferDs ds, InvTransfer e)
            throws Exception {
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

    protected void lookup_transactionType_InvTransactionType(InvTransferDs ds,
            InvTransfer e) throws Exception {
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

    protected void lookup_fromInventory_Organization(InvTransferDs ds,
            InvTransfer e) throws Exception {
        if (ds.getFromInventory() != null && !ds.getFromInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByName(ds.getFromInventory());
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

    protected void lookup_toInventory_Organization(InvTransferDs ds,
            InvTransfer e) throws Exception {
        if (ds.getToInventory() != null && !ds.getToInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByName(ds.getToInventory());
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

}
