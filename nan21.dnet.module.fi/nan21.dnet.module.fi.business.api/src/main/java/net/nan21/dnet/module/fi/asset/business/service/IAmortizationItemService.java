/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import net.nan21.dnet.module.fi.asset.domain.entity.AmortizationItem;

public interface IAmortizationItemService extends
        IEntityService<AmortizationItem> {

    public List<AmortizationItem> findByAsset(Asset asset);

    public List<AmortizationItem> findByAssetId(Long assetId);

    public List<AmortizationItem> findByCurrency(Currency currency);

    public List<AmortizationItem> findByCurrencyId(Long currencyId);

}
