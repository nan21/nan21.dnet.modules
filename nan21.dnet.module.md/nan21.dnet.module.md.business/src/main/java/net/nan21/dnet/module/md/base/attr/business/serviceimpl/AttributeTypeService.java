/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeTypeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeType;

public class AttributeTypeService extends AbstractEntityService<AttributeType>
        implements IAttributeTypeService {

    public AttributeTypeService() {
        super();
    }

    public AttributeTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AttributeType> getEntityClass() {
        return AttributeType.class;
    }

    public AttributeType findByName(String name) {
        return (AttributeType) this.em
                .createNamedQuery(AttributeType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<AttributeType> findByCategory(AttributeCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<AttributeType> findByCategoryId(Long categoryId) {
        return (List<AttributeType>) this.em
                .createQuery(
                        "select e from AttributeType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        AttributeType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
