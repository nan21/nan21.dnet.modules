/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.acc.business.service.IAccJournalService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

public class TxDocTypeDsConv extends
        AbstractDsConverter<TxDocTypeDs, TxDocType> implements
        IDsConverter<TxDocTypeDs, TxDocType> {

    @Override
    protected void modelToEntityReferences(TxDocTypeDs ds, TxDocType e,
            boolean isInsert) throws Exception {

        if (ds.getJournalId() != null) {
            if (e.getJournal() == null
                    || !e.getJournal().getId().equals(ds.getJournalId())) {
                e.setJournal((AccJournal) this.em.find(AccJournal.class,
                        ds.getJournalId()));
            }
        } else {
            this.lookup_journal_AccJournal(ds, e);
        }

    }

    protected void lookup_journal_AccJournal(TxDocTypeDs ds, TxDocType e)
            throws Exception {
        if (ds.getJournal() != null && !ds.getJournal().equals("")) {
            AccJournal x = null;
            try {
                x = ((IAccJournalService) findEntityService(AccJournal.class))
                        .findByName(ds.getJournal());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccJournal` reference:  `journal` = "
                                + ds.getJournal() + "  ");
            }
            e.setJournal(x);

        } else {
            e.setJournal(null);
        }
    }

}
