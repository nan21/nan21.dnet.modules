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
public class ActTaskInstanceDs extends AbstractBaseDs<ActTaskInstanceHistory> {

    public static final String fID = "id";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";
    public static final String fCLIENTID = "clientId";
    public static final String fTASKKEY = "taskKey";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fEXECUTIONID = "executionId";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";
    public static final String fASSIGNEE = "assignee";
    public static final String fSTARTTIME = "startTime";
    public static final String fENDTIME = "endTime";
    public static final String fDURATION = "duration";
    public static final String fDURATIONTEXT = "durationText";
    public static final String fPRIORITY = "priority";
    public static final String fDUEDATE = "dueDate";

    @DsField()
    private String id;

    @DsField(join = "left", path = "processDefinition.id")
    private String processId;

    @DsField(join = "left", path = "processDefinition.name")
    private String process;

    @DsField(join = "left", path = "processDefinition.clientId")
    private Long clientId;

    @DsField(path = "taskDefinitionKey")
    private String taskKey;

    @DsField()
    private String processInstanceId;

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
    private Long priority;

    @DsField()
    private Date dueDate;

    public ActTaskInstanceDs() {
        super();
    }

    public ActTaskInstanceDs(ActTaskInstanceHistory e) {
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

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
