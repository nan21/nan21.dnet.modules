/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

public interface IProductAttributeValueService extends
        IEntityService<ProductAttributeValue> {

    public ProductAttributeValue findByName(Product product, Attribute attribute);

    public ProductAttributeValue findByName(Long productId, Long attributeId);

    public List<ProductAttributeValue> findByProduct(Product product);

    public List<ProductAttributeValue> findByProductId(Long productId);

    public List<ProductAttributeValue> findByAttribute(Attribute attribute);

    public List<ProductAttributeValue> findByAttributeId(Long attributeId);

}
