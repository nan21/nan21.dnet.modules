/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachment;

public interface IProductAttachmentService extends
        IEntityService<ProductAttachment> {

    public List<ProductAttachment> findByProduct(Product product);

    public List<ProductAttachment> findByProductId(Long productId);

}
