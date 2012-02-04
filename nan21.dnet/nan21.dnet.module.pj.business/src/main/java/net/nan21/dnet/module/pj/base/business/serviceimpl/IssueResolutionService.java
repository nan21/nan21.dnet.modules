/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueResolutionService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;

public class IssueResolutionService extends
        AbstractEntityService<IssueResolution> implements
        IIssueResolutionService {

    public IssueResolutionService() {
        super();
    }

    public IssueResolutionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueResolution> getEntityClass() {
        return IssueResolution.class;
    }

    public IssueResolution findByName(Long clientId, String name) {
        return (IssueResolution) this.em
                .createNamedQuery(IssueResolution.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
