/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectStatus;

public class ProjectStatusService extends AbstractEntityService<ProjectStatus>
        implements IProjectStatusService {

    public ProjectStatusService() {
        super();
    }

    public ProjectStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectStatus> getEntityClass() {
        return ProjectStatus.class;
    }

    public ProjectStatus findByName(Long clientId, String name) {
        return (ProjectStatus) this.em
                .createNamedQuery(ProjectStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
