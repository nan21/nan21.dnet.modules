/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.fin.business.service.IFinDocTypeService;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

public class InvTransactionTypeDsConv extends
        AbstractDsConverter<InvTransactionTypeDs, InvTransactionType> implements
        IDsConverter<InvTransactionTypeDs, InvTransactionType> {

    @Override
    protected void modelToEntityReferences(InvTransactionTypeDs ds,
            InvTransactionType e, boolean isInsert) throws Exception {

        if (ds.getDocTypeId() != null) {
            if (e.getDocType() == null
                    || !e.getDocType().getId().equals(ds.getDocTypeId())) {
                e.setDocType((FinDocType) this.em.find(FinDocType.class,
                        ds.getDocTypeId()));
            }
        } else {
            this.lookup_docType_FinDocType(ds, e);
        }

    }

    protected void lookup_docType_FinDocType(InvTransactionTypeDs ds,
            InvTransactionType e) throws Exception {
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

}
