/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;

public interface IAssetAcctService extends IEntityService<AssetAcct> {

    public AssetAcct findByAccount_schema(Asset asset, AccSchema accSchema);

    public AssetAcct findByAccount_schema(Long assetId, Long accSchemaId);

    public List<AssetAcct> findByAsset(Asset asset);

    public List<AssetAcct> findByAssetId(Long assetId);

    public List<AssetAcct> findByAccSchema(AccSchema accSchema);

    public List<AssetAcct> findByAccSchemaId(Long accSchemaId);

    public List<AssetAcct> findByDeprecAccount(Account deprecAccount);

    public List<AssetAcct> findByDeprecAccountId(Long deprecAccountId);

    public List<AssetAcct> findByAcmlDeprecAccount(Account acmlDeprecAccount);

    public List<AssetAcct> findByAcmlDeprecAccountId(Long acmlDeprecAccountId);

}
