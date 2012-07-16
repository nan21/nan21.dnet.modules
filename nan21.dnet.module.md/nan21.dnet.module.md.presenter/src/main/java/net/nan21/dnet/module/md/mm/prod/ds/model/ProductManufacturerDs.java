/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

@Ds(entity = ProductManufacturer.class, sort = { @SortField(field = ProductManufacturerDs.fNAME) })
public class ProductManufacturerDs extends
        AbstractTypeWithCodeDs<ProductManufacturer> {

    public static final String fICONURL = "iconUrl";

    @DsField()
    private String iconUrl;

    public ProductManufacturerDs() {
        super();
    }

    public ProductManufacturerDs(ProductManufacturer e) {
        super(e);
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
