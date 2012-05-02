/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.tx.fin.business.service.IAccOperationService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccOperation;

public class AccOperationService extends AbstractEntityService<AccOperation>
        implements IAccOperationService {

    public AccOperationService() {
        super();
    }

    public AccOperationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccOperation> getEntityClass() {
        return AccOperation.class;
    }

    public List<AccOperation> findByAccDocLine(AccDocLine accDocLine) {
        return this.findByAccDocLineId(accDocLine.getId());
    }

    public List<AccOperation> findByAccDocLineId(Long accDocLineId) {
        return (List<AccOperation>) this.em
                .createQuery(
                        "select e from AccOperation e where e.clientId = :pClientId and e.accDocLine.id = :pAccDocLineId",
                        AccOperation.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccDocLineId", accDocLineId).getResultList();
    }

}
