/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;

public class ProductAttributeGroupService extends
        AbstractEntityService<ProductAttributeGroup> {

    public ProductAttributeGroupService() {
        super();
    }

    public ProductAttributeGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeGroup> getEntityClass() {
        return ProductAttributeGroup.class;
    }

    public ProductAttributeGroup findByName(Long clientId, String name) {
        return (ProductAttributeGroup) this.em
                .createNamedQuery(ProductAttributeGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductAttributeGroup> findByAttributes(
            ProductAttribute attributes) {
        return this.findByAttributesId(attributes.getId());
    }

    public List<ProductAttributeGroup> findByAttributesId(Long attributesId) {
        return (List<ProductAttributeGroup>) this.em
                .createQuery(
                        "select e from ProductAttributeGroup e where e.attributes.id = :pAttributesId",
                        ProductAttributeGroup.class)
                .setParameter("pAttributesId", attributesId).getResultList();
    }

}
