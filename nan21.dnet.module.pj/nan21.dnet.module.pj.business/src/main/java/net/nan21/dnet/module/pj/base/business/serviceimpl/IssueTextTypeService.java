/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTextTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;

public class IssueTextTypeService extends AbstractEntityService<IssueTextType>
        implements IIssueTextTypeService {

    public IssueTextTypeService() {
        super();
    }

    public IssueTextTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueTextType> getEntityClass() {
        return IssueTextType.class;
    }

    public IssueTextType findByName(Long clientId, String name) {
        return (IssueTextType) this.em
                .createNamedQuery(IssueTextType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
