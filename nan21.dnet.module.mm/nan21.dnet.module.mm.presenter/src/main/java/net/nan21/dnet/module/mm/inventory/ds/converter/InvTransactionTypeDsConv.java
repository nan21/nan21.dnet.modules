/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionActionService;
import net.nan21.dnet.module.mm.inventory.business.service.IInvTransactionSourceTypeService;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionAction;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionSourceType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

public class InvTransactionTypeDsConv extends
        AbstractDsConverter<InvTransactionTypeDs, InvTransactionType> implements
        IDsConverter<InvTransactionTypeDs, InvTransactionType> {

    protected void modelToEntityAttributes(InvTransactionTypeDs ds,
            InvTransactionType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(InvTransactionTypeDs ds,
            InvTransactionType e) throws Exception {

        if (ds.getActionId() != null) {
            if (e.getAction() == null
                    || !e.getAction().getId().equals(ds.getActionId())) {
                e.setAction((InvTransactionAction) this.em.find(
                        InvTransactionAction.class, ds.getActionId()));
            }
        } else {
            this.lookup_action_InvTransactionAction(ds, e);
        }
        if (ds.getSourceTypeId() != null) {
            if (e.getSourceType() == null
                    || !e.getSourceType().getId().equals(ds.getSourceTypeId())) {
                e.setSourceType((InvTransactionSourceType) this.em.find(
                        InvTransactionSourceType.class, ds.getSourceTypeId()));
            }
        } else {
            this.lookup_sourceType_InvTransactionSourceType(ds, e);
        }
    }

    protected void lookup_action_InvTransactionAction(InvTransactionTypeDs ds,
            InvTransactionType e) throws Exception {
        if (ds.getAction() != null && !ds.getAction().equals("")) {
            InvTransactionAction x = null;
            try {
                x = ((IInvTransactionActionService) getService(IInvTransactionActionService.class))
                        .findByName(ds.getClientId(), ds.getAction());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `InvTransactionAction` reference:  `action` = "
                                + ds.getAction() + "  ");
            }
            e.setAction(x);
        } else {
            e.setAction(null);
        }
    }

    protected void lookup_sourceType_InvTransactionSourceType(
            InvTransactionTypeDs ds, InvTransactionType e) throws Exception {
        if (ds.getSourceType() != null && !ds.getSourceType().equals("")) {
            InvTransactionSourceType x = null;
            try {
                x = ((IInvTransactionSourceTypeService) getService(IInvTransactionSourceTypeService.class))
                        .findByName(ds.getClientId(), ds.getSourceType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `InvTransactionSourceType` reference:  `sourceType` = "
                                + ds.getSourceType() + "  ");
            }
            e.setSourceType(x);
        } else {
            e.setSourceType(null);
        }
    }

    @Override
    public void entityToModel(InvTransactionType e, InvTransactionTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSourceTypeId(((e.getSourceType() != null)) ? e.getSourceType()
                .getId() : null);
        ds.setSourceType(((e.getSourceType() != null)) ? e.getSourceType()
                .getName() : null);
        ds.setActionId(((e.getAction() != null)) ? e.getAction().getId() : null);
        ds.setAction(((e.getAction() != null)) ? e.getAction().getName() : null);
    }

}