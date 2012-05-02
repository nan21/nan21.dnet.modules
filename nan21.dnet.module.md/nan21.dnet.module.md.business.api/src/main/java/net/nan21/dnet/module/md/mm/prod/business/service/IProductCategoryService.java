/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;

public interface IProductCategoryService extends
        IEntityService<ProductCategory> {

    public ProductCategory findByCode(String code);

    public ProductCategory findByName(String name);

    public List<ProductCategory> findByCategory(ProductCategory category);

    public List<ProductCategory> findByCategoryId(Long categoryId);

    public List<ProductCategory> findByProducts(Product products);

    public List<ProductCategory> findByProductsId(Long productsId);

}
