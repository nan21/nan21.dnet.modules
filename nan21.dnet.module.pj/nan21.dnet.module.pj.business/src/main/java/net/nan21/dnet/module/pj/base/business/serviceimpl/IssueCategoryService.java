/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;

public class IssueCategoryService extends AbstractEntityService<IssueCategory>
        implements IIssueCategoryService {

    public IssueCategoryService() {
        super();
    }

    public IssueCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueCategory> getEntityClass() {
        return IssueCategory.class;
    }

    public IssueCategory findByName(Long clientId, String name) {
        return (IssueCategory) this.em
                .createNamedQuery(IssueCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
