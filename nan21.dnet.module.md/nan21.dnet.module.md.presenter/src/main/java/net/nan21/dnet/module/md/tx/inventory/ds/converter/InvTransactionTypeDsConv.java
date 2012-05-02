/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.tx.business.service.ITxDocTypeService;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeDs;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

public class InvTransactionTypeDsConv extends
        AbstractDsConverter<InvTransactionTypeDs, InvTransactionType> implements
        IDsConverter<InvTransactionTypeDs, InvTransactionType> {

    @Override
    protected void modelToEntityReferences(InvTransactionTypeDs ds,
            InvTransactionType e, boolean isInsert) throws Exception {

        if (ds.getDocTypeId() != null) {
            if (e.getDocType() == null
                    || !e.getDocType().getId().equals(ds.getDocTypeId())) {
                e.setDocType((TxDocType) this.em.find(TxDocType.class,
                        ds.getDocTypeId()));
            }
        } else {
            this.lookup_docType_TxDocType(ds, e);
        }

    }

    protected void lookup_docType_TxDocType(InvTransactionTypeDs ds,
            InvTransactionType e) throws Exception {
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

}
