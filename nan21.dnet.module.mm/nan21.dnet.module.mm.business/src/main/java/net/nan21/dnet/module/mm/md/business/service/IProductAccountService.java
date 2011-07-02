/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;

import net.nan21.dnet.module.mm.md.domain.entity.ProductAccount;

public interface IProductAccountService extends IEntityService<ProductAccount> {

    public ProductAccount findByCode(Long clientId, Product product,
            Organization organization);

    public ProductAccount findByCode(Long clientId, Long productId,
            Long organizationId);

    public List<ProductAccount> findByOrganization(Organization organization);

    public List<ProductAccount> findByOrganizationId(Long organizationId);

    public List<ProductAccount> findByGroup(ProductAccountGroup group);

    public List<ProductAccount> findByGroupId(Long groupId);

    public List<ProductAccount> findByProduct(Product product);

    public List<ProductAccount> findByProductId(Long productId);

}
