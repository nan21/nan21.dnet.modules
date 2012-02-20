/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectRoleService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

public class ProjectRoleService extends AbstractEntityService<ProjectRole>
        implements IProjectRoleService {

    public ProjectRoleService() {
        super();
    }

    public ProjectRoleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectRole> getEntityClass() {
        return ProjectRole.class;
    }

    public ProjectRole findByName(String name) {
        return (ProjectRole) this.em
                .createNamedQuery(ProjectRole.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProjectRole> findByProjectTypes(ProjectType projectTypes) {
        return this.findByProjectTypesId(projectTypes.getId());
    }

    public List<ProjectRole> findByProjectTypesId(Long projectTypesId) {
        return (List<ProjectRole>) this.em
                .createQuery(
                        "select distinct e from ProjectRole e , IN (e.projectTypes) c where e.clientId = :pClientId and c.id = :pProjectTypesId",
                        ProjectRole.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProjectTypesId", projectTypesId)
                .getResultList();
    }

}
