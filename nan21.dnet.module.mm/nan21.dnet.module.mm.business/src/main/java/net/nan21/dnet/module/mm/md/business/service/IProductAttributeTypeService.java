/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeCategory;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

public interface IProductAttributeTypeService extends
        IEntityService<ProductAttributeType> {

    public ProductAttributeType findByName(Long clientId, String name);

    public List<ProductAttributeType> findByCategory(
            ProductAttributeCategory category);

    public List<ProductAttributeType> findByCategoryId(Long categoryId);

}
