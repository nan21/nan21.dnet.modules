/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

public interface IProductAttributeService extends
        IEntityService<ProductAttribute> {

    public ProductAttribute findByName(Long clientId, String name);

    public List<ProductAttribute> findByType(ProductAttributeType type);

    public List<ProductAttribute> findByTypeId(Long typeId);

    public List<ProductAttribute> findByUom(Uom uom);

    public List<ProductAttribute> findByUomId(Long uomId);

}
