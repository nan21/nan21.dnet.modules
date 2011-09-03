/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeCategory;

public class ProductAttributeCategoryService extends
        AbstractEntityService<ProductAttributeCategory> implements
        IProductAttributeCategoryService {

    public ProductAttributeCategoryService() {
        super();
    }

    public ProductAttributeCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeCategory> getEntityClass() {
        return ProductAttributeCategory.class;
    }

    public ProductAttributeCategory findByName(Long clientId, String name) {
        return (ProductAttributeCategory) this.em
                .createNamedQuery(ProductAttributeCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
