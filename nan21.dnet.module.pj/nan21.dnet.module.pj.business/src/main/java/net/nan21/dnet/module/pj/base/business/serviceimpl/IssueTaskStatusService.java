/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

public class IssueTaskStatusService extends
        AbstractEntityService<IssueTaskStatus> implements
        IIssueTaskStatusService {

    public IssueTaskStatusService() {
        super();
    }

    public IssueTaskStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueTaskStatus> getEntityClass() {
        return IssueTaskStatus.class;
    }

    public IssueTaskStatus findByName(String name) {
        return (IssueTaskStatus) this.em
                .createNamedQuery(IssueTaskStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
