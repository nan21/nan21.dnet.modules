/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class MenuItemRtLovDsFilter extends AbstractTypeDsFilter {

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private Long menuItemId;

    private Long menuItemId_From;
    private Long menuItemId_To;

    private String menuItem;

    private Long menuId;

    private Long menuId_From;
    private Long menuId_To;

    private String menu;

    private String text;

    private String frame;

    private String bundle;

    private Boolean leaf;

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
    }

    public Long getMenuItemId() {
        return this.menuItemId;
    }

    public Long getMenuItemId_From() {
        return this.menuItemId_From;
    }

    public Long getMenuItemId_To() {
        return this.menuItemId_To;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setMenuItemId_From(Long menuItemId_From) {
        this.menuItemId_From = menuItemId_From;
    }

    public void setMenuItemId_To(Long menuItemId_To) {
        this.menuItemId_To = menuItemId_To;
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

    public Long getMenuId_From() {
        return this.menuId_From;
    }

    public Long getMenuId_To() {
        return this.menuId_To;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public void setMenuId_From(Long menuId_From) {
        this.menuId_From = menuId_From;
    }

    public void setMenuId_To(Long menuId_To) {
        this.menuId_To = menuId_To;
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
