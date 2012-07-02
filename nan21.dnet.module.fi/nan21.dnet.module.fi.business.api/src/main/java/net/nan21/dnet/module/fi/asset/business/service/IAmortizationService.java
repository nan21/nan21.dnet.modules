/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;

public interface IAmortizationService extends IEntityService<Amortization> {

    public Amortization findByAmort(Asset asset, Date postingDate);

    public Amortization findByAmort(Long assetId, Date postingDate);

    public List<Amortization> findByAsset(Asset asset);

    public List<Amortization> findByAssetId(Long assetId);

}
