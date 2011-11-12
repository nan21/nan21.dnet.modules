/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssuePriorityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;

public class IssuePriorityService extends AbstractEntityService<IssuePriority>
        implements IIssuePriorityService {

    public IssuePriorityService() {
        super();
    }

    public IssuePriorityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssuePriority> getEntityClass() {
        return IssuePriority.class;
    }

    public IssuePriority findByName(Long clientId, String name) {
        return (IssuePriority) this.em
                .createNamedQuery(IssuePriority.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
