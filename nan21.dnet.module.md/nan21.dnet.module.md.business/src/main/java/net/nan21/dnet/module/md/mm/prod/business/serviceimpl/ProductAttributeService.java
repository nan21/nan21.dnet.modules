/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public class ProductAttributeService extends
        AbstractEntityService<ProductAttribute> implements
        IProductAttributeService {

    public ProductAttributeService() {
        super();
    }

    public ProductAttributeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttribute> getEntityClass() {
        return ProductAttribute.class;
    }

    public ProductAttribute findByName(Product product,
            AttributeGroupAttribute groupAttribute) {
        return (ProductAttribute) this.em
                .createNamedQuery(ProductAttribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProduct", product)
                .setParameter("pGroupAttribute", groupAttribute)
                .getSingleResult();
    }

    public ProductAttribute findByName(Long productId, Long groupAttributeId) {
        return (ProductAttribute) this.em
                .createNamedQuery(ProductAttribute.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId)
                .setParameter("pGroupAttributeId", groupAttributeId)
                .getSingleResult();
    }

    public List<ProductAttribute> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAttribute> findByProductId(Long productId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.clientId = :pClientId and e.product.id = :pProductId",
                        ProductAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductAttribute> findByGroupAttribute(
            AttributeGroupAttribute groupAttribute) {
        return this.findByGroupAttributeId(groupAttribute.getId());
    }

    public List<ProductAttribute> findByGroupAttributeId(Long groupAttributeId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.clientId = :pClientId and e.groupAttribute.id = :pGroupAttributeId",
                        ProductAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupAttributeId", groupAttributeId)
                .getResultList();
    }

}
