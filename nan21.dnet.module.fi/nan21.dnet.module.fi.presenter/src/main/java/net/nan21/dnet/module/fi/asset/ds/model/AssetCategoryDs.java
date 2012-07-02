/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AssetCategory.class, sort = { @SortField(field = AssetCategoryDs.fNAME) })
public class AssetCategoryDs extends AbstractTypeWithCodeDs<AssetCategory> {

    public AssetCategoryDs() {
        super();
    }

    public AssetCategoryDs(AssetCategory e) {
        super(e);
    }

}
