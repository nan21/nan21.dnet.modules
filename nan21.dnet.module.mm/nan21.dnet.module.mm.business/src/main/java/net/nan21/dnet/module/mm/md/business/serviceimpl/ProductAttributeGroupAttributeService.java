/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeGroupAttributeService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroupAttribute;

public class ProductAttributeGroupAttributeService extends
        AbstractEntityService<ProductAttributeGroupAttribute> implements
        IProductAttributeGroupAttributeService {

    public ProductAttributeGroupAttributeService() {
        super();
    }

    public ProductAttributeGroupAttributeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeGroupAttribute> getEntityClass() {
        return ProductAttributeGroupAttribute.class;
    }

    public ProductAttributeGroupAttribute findByName(
            ProductAttributeGroup group, ProductAttribute attribute) {
        return (ProductAttributeGroupAttribute) this.em
                .createNamedQuery(
                        ProductAttributeGroupAttribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroup", group)
                .setParameter("pAttribute", attribute).getSingleResult();
    }

    public ProductAttributeGroupAttribute findByName(Long groupId,
            Long attributeId) {
        return (ProductAttributeGroupAttribute) this.em
                .createNamedQuery(
                        ProductAttributeGroupAttribute.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId)
                .setParameter("pAttributeId", attributeId).getSingleResult();
    }

    public List<ProductAttributeGroupAttribute> findByGroup(
            ProductAttributeGroup group) {
        return this.findByGroupId(group.getId());
    }

    public List<ProductAttributeGroupAttribute> findByGroupId(Long groupId) {
        return (List<ProductAttributeGroupAttribute>) this.em
                .createQuery(
                        "select e from ProductAttributeGroupAttribute e where e.clientId = :pClientId and e.group.id = :pGroupId",
                        ProductAttributeGroupAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupId", groupId).getResultList();
    }

    public List<ProductAttributeGroupAttribute> findByAttribute(
            ProductAttribute attribute) {
        return this.findByAttributeId(attribute.getId());
    }

    public List<ProductAttributeGroupAttribute> findByAttributeId(
            Long attributeId) {
        return (List<ProductAttributeGroupAttribute>) this.em
                .createQuery(
                        "select e from ProductAttributeGroupAttribute e where e.clientId = :pClientId and e.attribute.id = :pAttributeId",
                        ProductAttributeGroupAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAttributeId", attributeId).getResultList();
    }

}
