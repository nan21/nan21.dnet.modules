/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class MenuDsFilter extends AbstractTypeDsFilter {

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
