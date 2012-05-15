/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class WfDefNodeDsFilter extends AbstractTypeDsFilter {

    private String assignToUser;

    private String assignToGroup;

    private Boolean startWithPrevious;

    private String taskType;

    private Long processId;

    private Long processId_From;
    private Long processId_To;

    private String process;

    public String getAssignToUser() {
        return this.assignToUser;
    }

    public void setAssignToUser(String assignToUser) {
        this.assignToUser = assignToUser;
    }

    public String getAssignToGroup() {
        return this.assignToGroup;
    }

    public void setAssignToGroup(String assignToGroup) {
        this.assignToGroup = assignToGroup;
    }

    public Boolean getStartWithPrevious() {
        return this.startWithPrevious;
    }

    public void setStartWithPrevious(Boolean startWithPrevious) {
        this.startWithPrevious = startWithPrevious;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Long getProcessId() {
        return this.processId;
    }

    public Long getProcessId_From() {
        return this.processId_From;
    }

    public Long getProcessId_To() {
        return this.processId_To;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public void setProcessId_From(Long processId_From) {
        this.processId_From = processId_From;
    }

    public void setProcessId_To(Long processId_To) {
        this.processId_To = processId_To;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

}
