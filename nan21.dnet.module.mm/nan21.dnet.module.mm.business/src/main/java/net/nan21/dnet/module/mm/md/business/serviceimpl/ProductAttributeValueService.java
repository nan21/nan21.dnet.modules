/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeValueService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroupAttribute;

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

    public ProductAttributeValue findByName(Product product,
            ProductAttributeGroupAttribute groupAttribute) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(ProductAttributeValue.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProduct", product)
                .setParameter("pGroupAttribute", groupAttribute)
                .getSingleResult();
    }

    public ProductAttributeValue findByName(Long productId,
            Long groupAttributeId) {
        return (ProductAttributeValue) this.em
                .createNamedQuery(
                        ProductAttributeValue.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId)
                .setParameter("pGroupAttributeId", groupAttributeId)
                .getSingleResult();
    }

    public List<ProductAttributeValue> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAttributeValue> findByProductId(Long productId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.clientId = :pClientId and  e.product.id = :pProductId",
                        ProductAttributeValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductAttributeValue> findByGroupAttribute(
            ProductAttributeGroupAttribute groupAttribute) {
        return this.findByGroupAttributeId(groupAttribute.getId());
    }

    public List<ProductAttributeValue> findByGroupAttributeId(
            Long groupAttributeId) {
        return (List<ProductAttributeValue>) this.em
                .createQuery(
                        "select e from ProductAttributeValue e where e.clientId = :pClientId and  e.groupAttribute.id = :pGroupAttributeId",
                        ProductAttributeValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGroupAttributeId", groupAttributeId)
                .getResultList();
    }

}
