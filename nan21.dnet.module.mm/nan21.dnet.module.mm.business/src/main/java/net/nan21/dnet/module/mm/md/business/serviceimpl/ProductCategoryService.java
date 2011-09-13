/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
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

    public ProductCategory findByCode(Long clientId, String code) {
        return (ProductCategory) this.em
                .createNamedQuery(ProductCategory.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ProductCategory findByName(Long clientId, String name) {
        return (ProductCategory) this.em
                .createNamedQuery(ProductCategory.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductCategory> findByProducts(Product products) {
        return this.findByProductsId(products.getId());
    }

    public List<ProductCategory> findByProductsId(Long productsId) {
        return (List<ProductCategory>) this.em
                .createQuery(
                        "select e from ProductCategory e where e.products.id = :pProductsId",
                        ProductCategory.class)
                .setParameter("pProductsId", productsId).getResultList();
    }

}
