/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class MenuItemRtLovDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private String name;

    private Boolean active;

    private String description;

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

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