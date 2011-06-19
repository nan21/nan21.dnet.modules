/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;

import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;

public interface IProductCategoryService extends
        IEntityService<ProductCategory> {

    public ProductCategory findByCode(Long clientId, String code);

    public ProductCategory findByName(Long clientId, String name);

    public List<ProductCategory> findByParent(ProductCategory parent);

    public List<ProductCategory> findByParentId(Long parentId);

    public List<ProductCategory> findByProducts(Product products);

    public List<ProductCategory> findByProductsId(Long productsId);

}
