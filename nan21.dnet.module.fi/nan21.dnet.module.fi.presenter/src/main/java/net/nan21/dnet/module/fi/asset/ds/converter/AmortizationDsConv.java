/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.fi.asset.business.service.IAssetService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs;
import net.nan21.dnet.module.fi.asset.domain.entity.Amortization;

public class AmortizationDsConv extends
        AbstractDsConverter<AmortizationDs, Amortization> implements
        IDsConverter<AmortizationDs, Amortization> {

    @Override
    protected void modelToEntityReferences(AmortizationDs ds, Amortization e,
            boolean isInsert) throws Exception {

        if (ds.getAssetId() != null) {
            if (e.getAsset() == null
                    || !e.getAsset().getId().equals(ds.getAssetId())) {
                e.setAsset((Asset) this.em.find(Asset.class, ds.getAssetId()));
            }
        } else {
            this.lookup_asset_Asset(ds, e);
        }

    }

    protected void lookup_asset_Asset(AmortizationDs ds, Amortization e)
            throws Exception {
        if (ds.getAsset() != null && !ds.getAsset().equals("")) {
            Asset x = null;
            try {
                x = ((IAssetService) findEntityService(Asset.class))
                        .findByCode(ds.getAsset());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Asset` reference:  `asset` = "
                                + ds.getAsset() + "  ");
            }
            e.setAsset(x);

        } else {
            e.setAsset(null);
        }
    }

}
