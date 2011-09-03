/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;

public interface IProductAttributeValueService extends
        IEntityService<ProductAttributeValue> {

    public ProductAttributeValue findByName(Long clientId, Product product,
            ProductAttribute attribute);

    public ProductAttributeValue findByName(Long clientId, Long productId,
            Long attributeId);

    public List<ProductAttributeValue> findByProduct(Product product);

    public List<ProductAttributeValue> findByProductId(Long productId);

    public List<ProductAttributeValue> findByAttribute(
            ProductAttribute attribute);

    public List<ProductAttributeValue> findByAttributeId(Long attributeId);

}
