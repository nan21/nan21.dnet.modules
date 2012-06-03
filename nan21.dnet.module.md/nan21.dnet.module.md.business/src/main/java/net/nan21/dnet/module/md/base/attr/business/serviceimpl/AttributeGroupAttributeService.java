/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeGroupAttributeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;

public class AttributeGroupAttributeService extends
        AbstractEntityService<AttributeGroupAttribute> implements
        IAttributeGroupAttributeService {

    public AttributeGroupAttributeService() {
        super();
    }

    public AttributeGroupAttributeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AttributeGroupAttribute> getEntityClass() {
        return AttributeGroupAttribute.class;
    }

    public AttributeGroupAttribute findByName(AttributeGroup group,
            Attribute attribute) {
        return (AttributeGroupAttribute) this.em
                .createNamedQuery(AttributeGroupAttribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroup", group)
                .setParameter("pAttribute", attribute).getSingleResult();
    }

    public AttributeGroupAttribute findByName(Long groupId, Long attributeId) {
        return (AttributeGroupAttribute) this.em
                .createNamedQuery(
                        AttributeGroupAttribute.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId)
                .setParameter("pAttributeId", attributeId).getSingleResult();
    }

    public List<AttributeGroupAttribute> findByGroup(AttributeGroup group) {
        return this.findByGroupId(group.getId());
    }

    public List<AttributeGroupAttribute> findByGroupId(Long groupId) {
        return (List<AttributeGroupAttribute>) this.em
                .createQuery(
                        "select e from AttributeGroupAttribute e where e.clientId = :pClientId and e.group.id = :pGroupId",
                        AttributeGroupAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId).getResultList();
    }

    public List<AttributeGroupAttribute> findByAttribute(Attribute attribute) {
        return this.findByAttributeId(attribute.getId());
    }

    public List<AttributeGroupAttribute> findByAttributeId(Long attributeId) {
        return (List<AttributeGroupAttribute>) this.em
                .createQuery(
                        "select e from AttributeGroupAttribute e where e.clientId = :pClientId and e.attribute.id = :pAttributeId",
                        AttributeGroupAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAttributeId", attributeId).getResultList();
    }

}
