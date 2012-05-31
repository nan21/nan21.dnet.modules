/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;

public interface IProductAccountService extends IEntityService<ProductAccount> {

    public ProductAccount findByProd_org(Product product, Organization org);

    public ProductAccount findByProd_org(Long productId, Long orgId);

    public List<ProductAccount> findByOrg(Organization org);

    public List<ProductAccount> findByOrgId(Long orgId);

    public List<ProductAccount> findByGroup(ProductAccountGroup group);

    public List<ProductAccount> findByGroupId(Long groupId);

    public List<ProductAccount> findByProduct(Product product);

    public List<ProductAccount> findByProductId(Long productId);

}
