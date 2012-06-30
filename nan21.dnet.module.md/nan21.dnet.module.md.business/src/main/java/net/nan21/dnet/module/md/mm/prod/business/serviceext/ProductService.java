/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceext;

import java.util.List;

import net.nan21.dnet.module.md._businessdelegates.mm.prod.SynchronizeProductAttributeBD;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

public class ProductService extends
		net.nan21.dnet.module.md.mm.prod.business.serviceimpl.ProductService
		implements IProductService {

	@Override
	protected void postInsert(List<Product> list) throws Exception {
		for (Product product : list) {
			if (product.getAttributeSet() != null) {
				this.getBusinessDelegate(SynchronizeProductAttributeBD.class)
						.addAttributesToProduct(product);
			}  
		}
	}

	@Override
	protected void postUpdate(List<Product> list) throws Exception {
		for (Product product : list) {
			if (product.getAttributeSet() != null) {
				this.getBusinessDelegate(SynchronizeProductAttributeBD.class)
						.synchronizeProductAttributes(product);
			} else {
				// TODO: delete the attribute values
			}
		}
	}

}
