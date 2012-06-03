/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeGroupService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;

public class AttributeGroupService extends
        AbstractEntityService<AttributeGroup> implements IAttributeGroupService {

    public AttributeGroupService() {
        super();
    }

    public AttributeGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AttributeGroup> getEntityClass() {
        return AttributeGroup.class;
    }

    public AttributeGroup findByName(String name) {
        return (AttributeGroup) this.em
                .createNamedQuery(AttributeGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
