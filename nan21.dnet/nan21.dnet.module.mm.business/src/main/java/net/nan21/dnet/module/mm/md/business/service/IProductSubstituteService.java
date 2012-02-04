/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.module.mm.md.domain.entity.ProductSubstitute;

public interface IProductSubstituteService extends
        IEntityService<ProductSubstitute> {

    public List<ProductSubstitute> findByRefProduct(Product refProduct);

    public List<ProductSubstitute> findByRefProductId(Long refProductId);

    public List<ProductSubstitute> findByEquivalence(Product equivalence);

    public List<ProductSubstitute> findByEquivalenceId(Long equivalenceId);

}
