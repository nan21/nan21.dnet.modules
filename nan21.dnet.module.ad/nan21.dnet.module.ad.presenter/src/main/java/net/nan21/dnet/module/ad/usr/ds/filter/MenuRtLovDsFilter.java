/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeLovFilter;

public class MenuRtLovDsFilter extends AbstractTypeLovFilter {

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
