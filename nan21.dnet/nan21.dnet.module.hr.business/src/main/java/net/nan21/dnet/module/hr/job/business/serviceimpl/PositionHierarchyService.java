/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IPositionHierarchyService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.PositionHierarchy;

public class PositionHierarchyService extends
        AbstractEntityService<PositionHierarchy> implements
        IPositionHierarchyService {

    public PositionHierarchyService() {
        super();
    }

    public PositionHierarchyService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PositionHierarchy> getEntityClass() {
        return PositionHierarchy.class;
    }

    public PositionHierarchy findByName(Long clientId, String name) {
        return (PositionHierarchy) this.em
                .createNamedQuery(PositionHierarchy.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
