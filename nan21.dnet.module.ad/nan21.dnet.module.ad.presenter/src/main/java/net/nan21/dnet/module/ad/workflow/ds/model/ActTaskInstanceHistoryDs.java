/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActTaskInstanceHistory.class)
public class ActTaskInstanceHistoryDs extends
        AbstractBaseDs<ActTaskInstanceHistory> {

    public static final String fID = "id";
    public static final String fTASKDEFINITIONKEY = "taskDefinitionKey";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fPROCESSDEFINITIONID = "processDefinitionId";
    public static final String fCLIENTID = "clientId";
    public static final String fEXECUTIONID = "executionId";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";
    public static final String fASSIGNEE = "assignee";
    public static final String fSTARTTIME = "startTime";
    public static final String fENDTIME = "endTime";
    public static final String fDURATION = "duration";
    public static final String fDURATIONTEXT = "durationText";
    public static final String fDELETEREASON = "deleteReason";
    public static final String fPRIORITY = "priority";
    public static final String fDUEDATE = "dueDate";

    @DsField()
    private String id;

    @DsField()
    private String taskDefinitionKey;

    @DsField()
    private String processInstanceId;

    @DsField(join = "left", path = "processDefinition.id")
    private String processDefinitionId;

    @DsField(join = "left", path = "processDefinition.clientId")
    private Long clientId;

    @DsField()
    private String executionId;

    @DsField()
    private String name;

    @DsField()
    private String description;

    @DsField()
    private String assignee;

    @DsField()
    private Date startTime;

    @DsField()
    private Date endTime;

    @DsField()
    private Long duration;

    @DsField(fetch = false)
    private String durationText;

    @DsField()
    private String deleteReason;

    @DsField()
    private Long priority;

    @DsField()
    private Date dueDate;

    public ActTaskInstanceHistoryDs() {
        super();
    }

    public ActTaskInstanceHistoryDs(ActTaskInstanceHistory e) {
        super(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public String getTaskDefinitionKey() {
        return this.taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId() {
        return this.processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
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

    public String getDurationText() {
        return this.durationText;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
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
