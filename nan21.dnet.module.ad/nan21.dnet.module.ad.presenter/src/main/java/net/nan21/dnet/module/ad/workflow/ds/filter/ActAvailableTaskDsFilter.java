/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActAvailableTaskDsFilter extends AbstractBaseDsFilter {

    private String id;

    private String processId;

    private String process;

    private String taskKey;

    private String processInstanceId;

    private String executionId;

    private String name;

    private String description;

    private String owner;

    private Date startTime;

    private Date startTime_From;
    private Date startTime_To;

    private Integer priority;

    private Integer priority_From;
    private Integer priority_To;

    private Date dueDate;

    private Date dueDate_From;
    private Date dueDate_To;

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

    public Date getStartTime_From() {
        return this.startTime_From;
    }

    public Date getStartTime_To() {
        return this.startTime_To;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStartTime_From(Date startTime_From) {
        this.startTime_From = startTime_From;
    }

    public void setStartTime_To(Date startTime_To) {
        this.startTime_To = startTime_To;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public Integer getPriority_From() {
        return this.priority_From;
    }

    public Integer getPriority_To() {
        return this.priority_To;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPriority_From(Integer priority_From) {
        this.priority_From = priority_From;
    }

    public void setPriority_To(Integer priority_To) {
        this.priority_To = priority_To;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Date getDueDate_From() {
        return this.dueDate_From;
    }

    public Date getDueDate_To() {
        return this.dueDate_To;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDate_From(Date dueDate_From) {
        this.dueDate_From = dueDate_From;
    }

    public void setDueDate_To(Date dueDate_To) {
        this.dueDate_To = dueDate_To;
    }

}
