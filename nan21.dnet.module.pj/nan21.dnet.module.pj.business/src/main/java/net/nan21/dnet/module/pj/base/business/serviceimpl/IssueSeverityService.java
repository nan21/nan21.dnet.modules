/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueSeverityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;

public class IssueSeverityService extends AbstractEntityService<IssueSeverity>
        implements IIssueSeverityService {

    public IssueSeverityService() {
        super();
    }

    public IssueSeverityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueSeverity> getEntityClass() {
        return IssueSeverity.class;
    }

    public IssueSeverity findByName(String name) {
        return (IssueSeverity) this.em
                .createNamedQuery(IssueSeverity.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
