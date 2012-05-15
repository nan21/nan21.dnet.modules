/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeType;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public interface IProductAttributeService extends
        IEntityService<ProductAttribute> {

    public ProductAttribute findByName(String name);

    public List<ProductAttribute> findByType(ProductAttributeType type);

    public List<ProductAttribute> findByTypeId(Long typeId);

    public List<ProductAttribute> findByUom(Uom uom);

    public List<ProductAttribute> findByUomId(Long uomId);

}
