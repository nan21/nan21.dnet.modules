/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActTask.class, jpqlWhere = "(e.assignee is null )", sort = { @SortField(field = ActAvailableTaskDs.fSTARTTIME, desc = true) })
public class ActAvailableTaskDs extends AbstractDsModel<ActTask> implements
        IModelWithId {

    public static final String fID = "id";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";
    public static final String fTASKKEY = "taskKey";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fEXECUTIONID = "executionId";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";
    public static final String fOWNER = "owner";
    public static final String fSTARTTIME = "startTime";
    public static final String fPRIORITY = "priority";
    public static final String fDUEDATE = "dueDate";

    @DsField()
    private String id;

    @DsField(join = "left", path = "processDefinition.id")
    private String processId;

    @DsField(join = "left", path = "processDefinition.name")
    private String process;

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

    @DsField(path = "assignee")
    private String owner;

    @DsField(path = "createdAt")
    private Date startTime;

    @DsField()
    private Integer priority;

    @DsField()
    private Date dueDate;

    public ActAvailableTaskDs() {
        super();
    }

    public ActAvailableTaskDs(ActTask e) {
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

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
