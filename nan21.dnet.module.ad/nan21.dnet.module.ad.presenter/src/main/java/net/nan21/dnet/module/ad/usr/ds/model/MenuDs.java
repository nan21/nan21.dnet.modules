/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;

@Ds(entity = Menu.class, sort = { @SortField(field = MenuDs.fNAME) })
public class MenuDs extends AbstractTypeDs<Menu> {

    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fTITLE = "title";

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String title;

    public MenuDs() {
        super();
    }

    public MenuDs(Menu e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
