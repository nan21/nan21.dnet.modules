/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.ds.filter.MenuRtLovDsFilter;

import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Menu.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = MenuLovDs.fNAME) })
public class MenuLovDs extends AbstractTypeLov<Menu> {

    public static final String fTITLE = "title";

    @DsField()
    private String title;

    public MenuLovDs() {
        super();
    }

    public MenuLovDs(Menu e) {
        super(e);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
