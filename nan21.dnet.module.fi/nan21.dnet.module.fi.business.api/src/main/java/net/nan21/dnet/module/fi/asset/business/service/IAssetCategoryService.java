/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

public interface IAssetCategoryService extends IEntityService<AssetCategory> {

    public AssetCategory findByCode(String code);

    public AssetCategory findByName(String name);

}
