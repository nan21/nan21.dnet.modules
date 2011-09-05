/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm._businessextensions;

import java.util.List;

import net.nan21.dnet.module.mm._businessdelegates.md.SynchronizeProductAttribute;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

public class ProductService extends
		net.nan21.dnet.module.mm.md.business.serviceimpl.ProductService {

	@Override
	protected void postInsert(List<Product> list) throws Exception {
		for (Product product : list) {
			if (product.getAttributeGroup() != null) {
				this.getBusinessDelegate(SynchronizeProductAttribute.class)
				.addAttributesToProduct(product);
			}
		}
	}
	
	
	@Override
	protected void preUpdate(List<Product> list) throws Exception {
//		for (Product product : list) {
//			if (product.getAttributeGroup() != null) {
//				this.getBusinessDelegate(SynchronizeProductAttribute.class)
//				.synchronizeProductAttributes(product);
//			}
//		}
	}
	
	@Override
	protected void postUpdate(List<Product> list) throws Exception {
		for (Product product : list) {
			if (product.getAttributeGroup() != null) {
				this.getBusinessDelegate(SynchronizeProductAttribute.class)
				.synchronizeProductAttributes(product);
			}
		}
	}
}
