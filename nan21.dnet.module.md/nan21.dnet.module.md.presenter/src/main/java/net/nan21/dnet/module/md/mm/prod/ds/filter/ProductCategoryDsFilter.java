/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ProductCategoryDsFilter extends AbstractTypeWithCodeDsFilter {

    private Boolean folder;

    private String iconUrl;

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
