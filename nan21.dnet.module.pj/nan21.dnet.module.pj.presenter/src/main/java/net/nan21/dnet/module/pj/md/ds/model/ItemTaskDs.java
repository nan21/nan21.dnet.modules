/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.pj.md.domain.entity.ItemTask;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ItemTask.class)
public class ItemTaskDs extends AbstractDsModel<ItemTask> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fSUMMARY = "summary";
    public static final String fDESCRIPTION = "description";
    public static final String fITEMID = "itemId";
    public static final String fITEM = "item";
    public static final String fPRIORITYID = "priorityId";
    public static final String fPRIORITY = "priority";
    public static final String fPRIORITYSORTVALUE = "prioritySortValue";
    public static final String fITEMBUSINESSOBJECT = "itemBusinessObject";
    public static final String fITEMCLASSNAME = "itemClassName";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUS = "status";
    public static final String fASSIGNEEID = "assigneeId";
    public static final String fASSIGNEE = "assignee";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField()
    private String summary;

    @DsField()
    private String description;

    @DsField(join = "left", path = "item.id")
    private Long itemId;

    @DsField(join = "left", path = "item.summary")
    private String item;

    @DsField(join = "left", path = "item.priority.id")
    private Long priorityId;

    @DsField(join = "left", path = "item.priority.name")
    private String priority;

    @DsField(join = "left", path = "item.priority.sortValue")
    private Integer prioritySortValue;

    @DsField(join = "left", fetch = false, path = "item.businessObject")
    private String itemBusinessObject;

    @DsField(join = "left", fetch = false, path = "item.className")
    private String itemClassName;

    @DsField(join = "left", path = "type.id")
    private Long typeId;

    @DsField(join = "left", path = "type.name")
    private String type;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String status;

    @DsField(join = "left", path = "assignee.id")
    private Long assigneeId;

    @DsField(join = "left", path = "assignee.member.name")
    private String assignee;

    public ItemTaskDs() {
        super();
    }

    public ItemTaskDs(ItemTask e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getPrioritySortValue() {
        return this.prioritySortValue;
    }

    public void setPrioritySortValue(Integer prioritySortValue) {
        this.prioritySortValue = prioritySortValue;
    }

    public String getItemBusinessObject() {
        return this.itemBusinessObject;
    }

    public void setItemBusinessObject(String itemBusinessObject) {
        this.itemBusinessObject = itemBusinessObject;
    }

    public String getItemClassName() {
        return this.itemClassName;
    }

    public void setItemClassName(String itemClassName) {
        this.itemClassName = itemClassName;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAssigneeId() {
        return this.assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

}
