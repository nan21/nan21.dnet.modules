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
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;

@Ds(entity = ProductCategory.class, sort = { @SortField(field = ProductCategoryDs.fNAME) })
public class ProductCategoryDs extends AbstractTypeWithCodeDs<ProductCategory> {

    public static final String fFOLDER = "folder";
    public static final String fICONURL = "iconUrl";

    @DsField()
    private Boolean folder;

    @DsField()
    private String iconUrl;

    public ProductCategoryDs() {
        super();
    }

    public ProductCategoryDs(ProductCategory e) {
        super(e);
    }

    public Boolean getFolder() {
        return this.folder;
    }

    public void setFolder(Boolean folder) {
        this.folder = folder;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
