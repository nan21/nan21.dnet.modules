/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;

public class IssueTypeService extends AbstractEntityService<IssueType>
        implements IIssueTypeService {

    public IssueTypeService() {
        super();
    }

    public IssueTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueType> getEntityClass() {
        return IssueType.class;
    }

    public IssueType findByName(Long clientId, String name) {
        return (IssueType) this.em.createNamedQuery(IssueType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<IssueType> findByCategory(IssueCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<IssueType> findByCategoryId(Long categoryId) {
        return (List<IssueType>) this.em
                .createQuery(
                        "select e from IssueType e where e.category.id = :pCategoryId",
                        IssueType.class)
                .setParameter("pCategoryId", categoryId).getResultList();
    }

    public List<IssueType> findByProjectTypes(ProjectType projectTypes) {
        return this.findByProjectTypesId(projectTypes.getId());
    }

    public List<IssueType> findByProjectTypesId(Long projectTypesId) {
        return (List<IssueType>) this.em
                .createQuery(
                        "select distinct e from IssueType e , IN (e.projectTypes) c where c.id = :pProjectTypesId",
                        IssueType.class)
                .setParameter("pProjectTypesId", projectTypesId)
                .getResultList();
    }

}
