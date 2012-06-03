/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;

public class AttributeCategoryService extends
        AbstractEntityService<AttributeCategory> implements
        IAttributeCategoryService {

    public AttributeCategoryService() {
        super();
    }

    public AttributeCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AttributeCategory> getEntityClass() {
        return AttributeCategory.class;
    }

    public AttributeCategory findByName(String name) {
        return (AttributeCategory) this.em
                .createNamedQuery(AttributeCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
