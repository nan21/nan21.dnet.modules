/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.acc.business.service.IAccJournalService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.acc.domain.entity.AccJournal;

public class AccJournalService extends AbstractEntityService<AccJournal>
        implements IAccJournalService {

    public AccJournalService() {
        super();
    }

    public AccJournalService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccJournal> getEntityClass() {
        return AccJournal.class;
    }

    public AccJournal findByName(String name) {
        return (AccJournal) this.em
                .createNamedQuery(AccJournal.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
