/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = MenuItem.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = MenuItemRtLovDs.fSEQUENCENO) })
public class MenuItemRtLovDs extends AbstractTypeDs<MenuItem> {

    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fMENUITEMID = "menuItemId";
    public static final String fMENUITEM = "menuItem";
    public static final String fMENUID = "menuId";
    public static final String fMENU = "menu";
    public static final String fTEXT = "text";
    public static final String fFRAME = "frame";
    public static final String fBUNDLE = "bundle";
    public static final String fLEAF = "leaf";

    @DsField()
    private Integer sequenceNo;

    @DsField(join = "left", path = "menuItem.id")
    private Long menuItemId;

    @DsField(join = "left", path = "menuItem.name")
    private String menuItem;

    @DsField(join = "left", path = "menu.id")
    private Long menuId;

    @DsField(join = "left", path = "menu.name")
    private String menu;

    @DsField(path = "title")
    private String text;

    @DsField()
    private String frame;

    @DsField()
    private String bundle;

    @DsField(fetch = false, path = "leafNode")
    private Boolean leaf;

    public MenuItemRtLovDs() {
        super();
    }

    public MenuItemRtLovDs(MenuItem e) {
        super(e);
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getMenuItemId() {
        return this.menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItem() {
        return this.menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenu() {
        return this.menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrame() {
        return this.frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public Boolean getLeaf() {
        return this.leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

}
