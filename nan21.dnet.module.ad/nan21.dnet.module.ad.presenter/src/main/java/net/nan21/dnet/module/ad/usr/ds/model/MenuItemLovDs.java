/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.ds.filter.MenuItemRtLovDsFilter;

import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = MenuItem.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = MenuItemLovDs.fNAME) })
public class MenuItemLovDs extends AbstractTypeLov<MenuItem> {

    public static final String fTITLE = "title";

    @DsField()
    private String title;

    public MenuItemLovDs() {
        super();
    }

    public MenuItemLovDs(MenuItem e) {
        super(e);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
