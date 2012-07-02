/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategoryAcct;

public interface IAssetCategoryAcctService extends
        IEntityService<AssetCategoryAcct> {

    public AssetCategoryAcct findByAccount_schema(AssetCategory assetCategory,
            AccSchema accSchema);

    public AssetCategoryAcct findByAccount_schema(Long assetCategoryId,
            Long accSchemaId);

    public List<AssetCategoryAcct> findByAssetCategory(
            AssetCategory assetCategory);

    public List<AssetCategoryAcct> findByAssetCategoryId(Long assetCategoryId);

    public List<AssetCategoryAcct> findByAccSchema(AccSchema accSchema);

    public List<AssetCategoryAcct> findByAccSchemaId(Long accSchemaId);

    public List<AssetCategoryAcct> findByDeprecAccount(Account deprecAccount);

    public List<AssetCategoryAcct> findByDeprecAccountId(Long deprecAccountId);

    public List<AssetCategoryAcct> findByAcmlDeprecAccount(
            Account acmlDeprecAccount);

    public List<AssetCategoryAcct> findByAcmlDeprecAccountId(
            Long acmlDeprecAccountId);

}
