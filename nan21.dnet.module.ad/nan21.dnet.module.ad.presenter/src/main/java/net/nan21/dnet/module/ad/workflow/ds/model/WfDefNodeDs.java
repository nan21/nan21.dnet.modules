/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WfDefNode.class, sort = { @SortField(field = WfDefNodeDs.fID) })
public class WfDefNodeDs extends AbstractTypeDs<WfDefNode> {

    public static final String fASSIGNTOUSER = "assignToUser";
    public static final String fASSIGNTOGROUP = "assignToGroup";
    public static final String fSTARTWITHPREVIOUS = "startWithPrevious";
    public static final String fTASKTYPE = "taskType";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";

    @DsField()
    private String assignToUser;

    @DsField()
    private String assignToGroup;

    @DsField()
    private Boolean startWithPrevious;

    @DsField()
    private String taskType;

    @DsField(join = "left", path = "process.id")
    private Long processId;

    @DsField(join = "left", path = "process.name")
    private String process;

    public WfDefNodeDs() {
        super();
    }

    public WfDefNodeDs(WfDefNode e) {
        super(e);
    }

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

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

}
