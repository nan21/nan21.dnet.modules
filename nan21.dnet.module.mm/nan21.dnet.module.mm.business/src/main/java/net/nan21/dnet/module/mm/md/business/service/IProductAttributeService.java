/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

public interface IProductAttributeService extends
        IEntityService<ProductAttribute> {

    public ProductAttribute findByName(Long clientId, String name);

    public List<ProductAttribute> findByType(ProductAttributeType type);

    public List<ProductAttribute> findByTypeId(Long typeId);

    public List<ProductAttribute> findByUomType(UomType uomType);

    public List<ProductAttribute> findByUomTypeId(Long uomTypeId);

    public List<ProductAttribute> findByGroups(ProductAttributeGroup groups);

    public List<ProductAttribute> findByGroupsId(Long groupsId);

}
