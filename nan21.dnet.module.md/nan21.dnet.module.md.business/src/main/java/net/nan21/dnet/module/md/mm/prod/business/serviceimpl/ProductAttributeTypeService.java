/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeTypeService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeCategory;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeType;

public class ProductAttributeTypeService extends
        AbstractEntityService<ProductAttributeType> implements
        IProductAttributeTypeService {

    public ProductAttributeTypeService() {
        super();
    }

    public ProductAttributeTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeType> getEntityClass() {
        return ProductAttributeType.class;
    }

    public ProductAttributeType findByName(String name) {
        return (ProductAttributeType) this.em
                .createNamedQuery(ProductAttributeType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductAttributeType> findByCategory(
            ProductAttributeCategory category) {
        return this.findByCategoryId(category.getId());
    }

    public List<ProductAttributeType> findByCategoryId(Long categoryId) {
        return (List<ProductAttributeType>) this.em
                .createQuery(
                        "select e from ProductAttributeType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
                        ProductAttributeType.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCategoryId", categoryId).getResultList();
    }

}
