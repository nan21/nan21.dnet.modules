/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductCategoryHierarchyItemService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchy;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchyItem;

public class ProductCategoryHierarchyItemService extends
        AbstractEntityService<ProductCategoryHierarchyItem> implements
        IProductCategoryHierarchyItemService {

    public ProductCategoryHierarchyItemService() {
        super();
    }

    public ProductCategoryHierarchyItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductCategoryHierarchyItem> getEntityClass() {
        return ProductCategoryHierarchyItem.class;
    }

    public List<ProductCategoryHierarchyItem> findByHierarchy(
            ProductCategoryHierarchy hierarchy) {
        return this.findByHierarchyId(hierarchy.getId());
    }

    public List<ProductCategoryHierarchyItem> findByHierarchyId(Long hierarchyId) {
        return (List<ProductCategoryHierarchyItem>) this.em
                .createQuery(
                        "select e from ProductCategoryHierarchyItem e where e.hierarchy.id = :pHierarchyId",
                        ProductCategoryHierarchyItem.class)
                .setParameter("pHierarchyId", hierarchyId).getResultList();
    }

    public List<ProductCategoryHierarchyItem> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductCategoryHierarchyItem> findByProductId(Long productId) {
        return (List<ProductCategoryHierarchyItem>) this.em
                .createQuery(
                        "select e from ProductCategoryHierarchyItem e where e.product.id = :pProductId",
                        ProductCategoryHierarchyItem.class)
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductCategoryHierarchyItem> findByParent(Product parent) {
        return this.findByParentId(parent.getId());
    }

    public List<ProductCategoryHierarchyItem> findByParentId(Long parentId) {
        return (List<ProductCategoryHierarchyItem>) this.em
                .createQuery(
                        "select e from ProductCategoryHierarchyItem e where e.parent.id = :pParentId",
                        ProductCategoryHierarchyItem.class)
                .setParameter("pParentId", parentId).getResultList();
    }

}
