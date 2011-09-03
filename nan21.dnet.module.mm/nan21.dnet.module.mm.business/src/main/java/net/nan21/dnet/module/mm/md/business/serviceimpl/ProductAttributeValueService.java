/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeValueService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;

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

    public ProductAttributeValue findByName(Long clientId, Product product,
            ProductAttribute attribute) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(ProductAttributeValue.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pProduct", product)
                .setParameter("pAttribute", attribute).getSingleResult();
    }

    public ProductAttributeValue findByName(Long clientId, Long productId,
            Long attributeId) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(
                        ProductAttributeValue.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pProductId", productId)
                .setParameter("pAttributeId", attributeId).getSingleResult();
    }

    public List<ProductAttributeValue> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAttributeValue> findByProductId(Long productId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.product.id = :pProductId",
                        ProductAttributeValue.class)
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductAttributeValue> findByAttribute(
            ProductAttribute attribute) {
        return this.findByAttributeId(attribute.getId());
    }

    public List<ProductAttributeValue> findByAttributeId(Long attributeId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.attribute.id = :pAttributeId",
                        ProductAttributeValue.class)
                .setParameter("pAttributeId", attributeId).getResultList();
    }

}
