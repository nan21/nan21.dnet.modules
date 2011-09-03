/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;

public interface IProductAttributeGroupService extends
        IEntityService<ProductAttributeGroup> {

    public ProductAttributeGroup findByName(Long clientId, String name);

    public List<ProductAttributeGroup> findByAttributes(
            ProductAttribute attributes);

    public List<ProductAttributeGroup> findByAttributesId(Long attributesId);

}
