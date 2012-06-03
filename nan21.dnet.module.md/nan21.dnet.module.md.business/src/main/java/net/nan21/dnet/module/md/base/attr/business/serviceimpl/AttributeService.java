/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;

public class AttributeService extends AbstractEntityService<Attribute>
        implements IAttributeService {

    public AttributeService() {
        super();
    }

    public AttributeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Attribute> getEntityClass() {
        return Attribute.class;
    }

    public Attribute findByName(String name) {
        return (Attribute) this.em.createNamedQuery(Attribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Attribute> findByType(AttributeType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Attribute> findByTypeId(Long typeId) {
        return (List<Attribute>) this.em
                .createQuery(
                        "select e from Attribute e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Attribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<Attribute> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<Attribute> findByUomId(Long uomId) {
        return (List<Attribute>) this.em
                .createQuery(
                        "select e from Attribute e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        Attribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

}
