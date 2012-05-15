/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueLinkTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;

public class IssueLinkTypeService extends AbstractEntityService<IssueLinkType>
        implements IIssueLinkTypeService {

    public IssueLinkTypeService() {
        super();
    }

    public IssueLinkTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueLinkType> getEntityClass() {
        return IssueLinkType.class;
    }

    public IssueLinkType findByName(String name) {
        return (IssueLinkType) this.em
                .createNamedQuery(IssueLinkType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
