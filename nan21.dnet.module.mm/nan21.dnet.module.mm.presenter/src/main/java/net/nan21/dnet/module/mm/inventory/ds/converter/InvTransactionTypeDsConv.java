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

    @Override
    protected void modelToEntityReferences(InvTransactionTypeDs ds,
            InvTransactionType e, boolean isInsert) throws Exception {

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
                x = ((IInvTransactionActionService) findEntityService(InvTransactionAction.class))
                        .findByName(ds.getAction());
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
                x = ((IInvTransactionSourceTypeService) findEntityService(InvTransactionSourceType.class))
                        .findByName(ds.getSourceType());
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

}
