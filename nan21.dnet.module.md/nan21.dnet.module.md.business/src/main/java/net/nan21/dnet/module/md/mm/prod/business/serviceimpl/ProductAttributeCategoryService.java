/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeCategoryService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeCategory;

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

    public ProductAttributeCategory findByName(String name) {
        return (ProductAttributeCategory) this.em
                .createNamedQuery(ProductAttributeCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
