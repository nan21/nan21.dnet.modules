/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;

public class IssueStatusService extends AbstractEntityService<IssueStatus>
        implements IIssueStatusService {

    public IssueStatusService() {
        super();
    }

    public IssueStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueStatus> getEntityClass() {
        return IssueStatus.class;
    }

    public IssueStatus findByName(Long clientId, String name) {
        return (IssueStatus) this.em
                .createNamedQuery(IssueStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
