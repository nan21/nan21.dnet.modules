/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public interface IProductAttributeService extends
        IEntityService<ProductAttribute> {

    public ProductAttribute findByName(Product product,
            AttributeGroupAttribute groupAttribute);

    public ProductAttribute findByName(Long productId, Long groupAttributeId);

    public List<ProductAttribute> findByProduct(Product product);

    public List<ProductAttribute> findByProductId(Long productId);

    public List<ProductAttribute> findByGroupAttribute(
            AttributeGroupAttribute groupAttribute);

    public List<ProductAttribute> findByGroupAttributeId(Long groupAttributeId);

}
