/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchy;

import net.nan21.dnet.module.mm.md.domain.entity.ProductCategoryHierarchyItem;

public interface IProductCategoryHierarchyItemService extends
        IEntityService<ProductCategoryHierarchyItem> {

    public List<ProductCategoryHierarchyItem> findByHierarchy(
            ProductCategoryHierarchy hierarchy);

    public List<ProductCategoryHierarchyItem> findByHierarchyId(Long hierarchyId);

    public List<ProductCategoryHierarchyItem> findByProduct(Product product);

    public List<ProductCategoryHierarchyItem> findByProductId(Long productId);

    public List<ProductCategoryHierarchyItem> findByParent(Product parent);

    public List<ProductCategoryHierarchyItem> findByParentId(Long parentId);

}
