/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.tx.business.service.ITxDocSequenceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocSequence;

public class TxDocSequenceService extends AbstractEntityService<TxDocSequence>
        implements ITxDocSequenceService {

    public TxDocSequenceService() {
        super();
    }

    public TxDocSequenceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<TxDocSequence> getEntityClass() {
        return TxDocSequence.class;
    }

    public TxDocSequence findByName(String name) {
        return (TxDocSequence) this.em
                .createNamedQuery(TxDocSequence.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
