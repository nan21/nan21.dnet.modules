/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.base.tx.business.service.ITxDocTypeService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

public class TxDocTypeService extends AbstractEntityService<TxDocType>
        implements ITxDocTypeService {

    public TxDocTypeService() {
        super();
    }

    public TxDocTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TxDocType> getEntityClass() {
        return TxDocType.class;
    }

    public TxDocType findByName(String name) {
        return (TxDocType) this.em.createNamedQuery(TxDocType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<TxDocType> findByDocSequence(TxDocSequence docSequence) {
        return this.findByDocSequenceId(docSequence.getId());
    }

    public List<TxDocType> findByDocSequenceId(Long docSequenceId) {
        return (List<TxDocType>) this.em
                .createQuery(
                        "select e from TxDocType e where e.clientId = :pClientId and e.docSequence.id = :pDocSequenceId",
                        TxDocType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocSequenceId", docSequenceId).getResultList();
    }

    public List<TxDocType> findByJournal(AccJournal journal) {
        return this.findByJournalId(journal.getId());
    }

    public List<TxDocType> findByJournalId(Long journalId) {
        return (List<TxDocType>) this.em
                .createQuery(
                        "select e from TxDocType e where e.clientId = :pClientId and e.journal.id = :pJournalId",
                        TxDocType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJournalId", journalId).getResultList();
    }

}
