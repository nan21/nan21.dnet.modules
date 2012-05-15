/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

public class ProjectTypeService extends AbstractEntityService<ProjectType>
        implements IProjectTypeService {

    public ProjectTypeService() {
        super();
    }

    public ProjectTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectType> getEntityClass() {
        return ProjectType.class;
    }

    public ProjectType findByName(String name) {
        return (ProjectType) this.em
                .createNamedQuery(ProjectType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProjectType> findByCategory(ProjectCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<ProjectType> findByCategoryId(Long categoryId) {
        return (List<ProjectType>) this.em
                .createQuery(
                        "select e from ProjectType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        ProjectType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

    public List<ProjectType> findByProjectRoles(ProjectRole projectRoles) {
        return this.findByProjectRolesId(projectRoles.getId());
    }

    public List<ProjectType> findByProjectRolesId(Long projectRolesId) {
        return (List<ProjectType>) this.em
                .createQuery(
                        "select distinct e from ProjectType e , IN (e.projectRoles) c where e.clientId = :pClientId and c.id = :pProjectRolesId",
                        ProjectType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProjectRolesId", projectRolesId)
                .getResultList();
    }

    public List<ProjectType> findByItemTypes(IssueType itemTypes) {
        return this.findByItemTypesId(itemTypes.getId());
    }

    public List<ProjectType> findByItemTypesId(Long itemTypesId) {
        return (List<ProjectType>) this.em
                .createQuery(
                        "select distinct e from ProjectType e , IN (e.itemTypes) c where e.clientId = :pClientId and c.id = :pItemTypesId",
                        ProjectType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemTypesId", itemTypesId).getResultList();
    }

}
