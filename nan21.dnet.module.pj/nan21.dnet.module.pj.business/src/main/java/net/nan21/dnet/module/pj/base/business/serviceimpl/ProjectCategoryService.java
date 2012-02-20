/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;

public class ProjectCategoryService extends
        AbstractEntityService<ProjectCategory> implements
        IProjectCategoryService {

    public ProjectCategoryService() {
        super();
    }

    public ProjectCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectCategory> getEntityClass() {
        return ProjectCategory.class;
    }

    public ProjectCategory findByName(String name) {
        return (ProjectCategory) this.em
                .createNamedQuery(ProjectCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
