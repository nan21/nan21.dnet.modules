/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductCategoryService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;

public class ProductCategoryService extends
        AbstractEntityService<ProductCategory> implements
        IProductCategoryService {

    public ProductCategoryService() {
        super();
    }

    public ProductCategoryService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductCategory> getEntityClass() {
        return ProductCategory.class;
    }

    public ProductCategory findByCode(String code) {
        return (ProductCategory) this.em
                .createNamedQuery(ProductCategory.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public ProductCategory findByName(String name) {
        return (ProductCategory) this.em
                .createNamedQuery(ProductCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductCategory> findByProducts(Product products) {
        return this.findByProductsId(products.getId());
    }

    public List<ProductCategory> findByProductsId(Long productsId) {
        return (List<ProductCategory>) this.em
                .createQuery(
                        "select distinct e from ProductCategory e , IN (e.products) c where e.clientId = :pClientId and c.id = :pProductsId",
                        ProductCategory.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProductsId", productsId).getResultList();
    }

}
