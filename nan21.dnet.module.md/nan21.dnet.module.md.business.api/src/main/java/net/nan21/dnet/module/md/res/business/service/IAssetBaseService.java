/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

import net.nan21.dnet.module.md.res.domain.entity.AssetBase;

public interface IAssetBaseService extends IEntityService<AssetBase> {

    public AssetBase findByCode(String code);

    public List<AssetBase> findByOrg(Organization org);

    public List<AssetBase> findByOrgId(Long orgId);

    public List<AssetBase> findByProduct(Product product);

    public List<AssetBase> findByProductId(Long productId);

}
