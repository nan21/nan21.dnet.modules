/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;

public class IssueTaskTypeService extends AbstractEntityService<IssueTaskType>
        implements IIssueTaskTypeService {

    public IssueTaskTypeService() {
        super();
    }

    public IssueTaskTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueTaskType> getEntityClass() {
        return IssueTaskType.class;
    }

    public IssueTaskType findByName(Long clientId, String name) {
        return (IssueTaskType) this.em
                .createNamedQuery(IssueTaskType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
