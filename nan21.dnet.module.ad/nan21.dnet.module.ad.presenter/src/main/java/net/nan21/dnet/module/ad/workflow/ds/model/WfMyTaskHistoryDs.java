/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfTaskInstance;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WfTaskInstance.class)
public class WfMyTaskHistoryDs extends AbstractDsModel<WfTaskInstance>
        implements IModelWithId {

    public static final String fID = "id";
    public static final String fPROCESSID = "processId";
    public static final String fTASKKEY = "taskKey";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fEXECUTIONID = "executionId";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";
    public static final String fOWNER = "owner";
    public static final String fSTARTTIME = "startTime";
    public static final String fENDTIME = "endTime";
    public static final String fDURATION = "duration";
    public static final String fDELETEREASON = "deleteReason";
    public static final String fPRIORITY = "priority";
    public static final String fDUEDATE = "dueDate";

    @DsField()
    private String id;

    @DsField()
    private String processId;

    @DsField()
    private String taskKey;

    @DsField()
    private String processInstanceId;

    @DsField()
    private String executionId;

    @DsField()
    private String name;

    @DsField()
    private String description;

    @DsField(path = "assignee")
    private String owner;

    @DsField()
    private Date startTime;

    @DsField()
    private Date endTime;

    @DsField()
    private Long duration;

    @DsField()
    private String deleteReason;

    @DsField()
    private Long priority;

    @DsField()
    private Date dueDate;

    public WfMyTaskHistoryDs() {
        super();
    }

    public WfMyTaskHistoryDs(WfTaskInstance e) {
        super(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public String getProcessId() {
        return this.processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTaskKey() {
        return this.taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecutionId() {
        return this.executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getDeleteReason() {
        return this.deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public Long getPriority() {
        return this.priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
