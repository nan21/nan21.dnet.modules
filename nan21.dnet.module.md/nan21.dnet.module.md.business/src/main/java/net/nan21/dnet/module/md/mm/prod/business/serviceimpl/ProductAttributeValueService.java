/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeValueService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

public class ProductAttributeValueService extends
        AbstractEntityService<ProductAttributeValue> implements
        IProductAttributeValueService {

    public ProductAttributeValueService() {
        super();
    }

    public ProductAttributeValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeValue> getEntityClass() {
        return ProductAttributeValue.class;
    }

    public ProductAttributeValue findByName(Product product, Attribute attribute) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(ProductAttributeValue.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProduct", product)
                .setParameter("pAttribute", attribute).getSingleResult();
    }

    public ProductAttributeValue findByName(Long productId, Long attributeId) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(
                        ProductAttributeValue.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId)
                .setParameter("pAttributeId", attributeId).getSingleResult();
    }

    public List<ProductAttributeValue> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAttributeValue> findByProductId(Long productId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.clientId = :pClientId and e.product.id = :pProductId",
                        ProductAttributeValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductAttributeValue> findByAttribute(Attribute attribute) {
        return this.findByAttributeId(attribute.getId());
    }

    public List<ProductAttributeValue> findByAttributeId(Long attributeId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.clientId = :pClientId and e.attribute.id = :pAttributeId",
                        ProductAttributeValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAttributeId", attributeId).getResultList();
    }

}
