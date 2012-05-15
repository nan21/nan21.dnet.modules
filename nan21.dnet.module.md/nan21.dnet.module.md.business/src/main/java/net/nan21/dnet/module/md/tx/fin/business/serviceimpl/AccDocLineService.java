/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.tx.fin.business.service.IAccDocLineService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

public class AccDocLineService extends AbstractEntityService<AccDocLine>
        implements IAccDocLineService {

    public AccDocLineService() {
        super();
    }

    public AccDocLineService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccDocLine> getEntityClass() {
        return AccDocLine.class;
    }

    public List<AccDocLine> findByAccDoc(AccDoc accDoc) {
        return this.findByAccDocId(accDoc.getId());
    }

    public List<AccDocLine> findByAccDocId(Long accDocId) {
        return (List<AccDocLine>) this.em
                .createQuery(
                        "select e from AccDocLine e where e.clientId = :pClientId and e.accDoc.id = :pAccDocId",
                        AccDocLine.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccDocId", accDocId).getResultList();
    }

}
