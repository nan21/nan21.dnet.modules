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

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroupAttribute;

public interface IProductAttributeGroupAttributeService extends
        IEntityService<ProductAttributeGroupAttribute> {

    public ProductAttributeGroupAttribute findByName(Long clientId,
            ProductAttributeGroup group, ProductAttribute attribute);

    public ProductAttributeGroupAttribute findByName(Long clientId,
            Long groupId, Long attributeId);

    public List<ProductAttributeGroupAttribute> findByGroup(
            ProductAttributeGroup group);

    public List<ProductAttributeGroupAttribute> findByGroupId(Long groupId);

    public List<ProductAttributeGroupAttribute> findByAttribute(
            ProductAttribute attribute);

    public List<ProductAttributeGroupAttribute> findByAttributeId(
            Long attributeId);

}
