/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

public interface IAssetService extends IEntityService<Asset> {

    public List<Asset> findByCategory(AssetCategory category);

    public List<Asset> findByCategoryId(Long categoryId);

}
