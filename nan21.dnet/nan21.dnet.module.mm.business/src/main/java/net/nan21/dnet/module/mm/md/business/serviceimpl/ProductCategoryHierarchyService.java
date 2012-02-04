/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductCategoryHierarchyService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchy;

public class ProductCategoryHierarchyService extends
        AbstractEntityService<ProductCategoryHierarchy> implements
        IProductCategoryHierarchyService {

    public ProductCategoryHierarchyService() {
        super();
    }

    public ProductCategoryHierarchyService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductCategoryHierarchy> getEntityClass() {
        return ProductCategoryHierarchy.class;
    }

    public ProductCategoryHierarchy findByName(Long clientId, String name) {
        return (ProductCategoryHierarchy) this.em
                .createNamedQuery(ProductCategoryHierarchy.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
