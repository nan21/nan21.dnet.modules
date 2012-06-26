/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActProcessInstanceHistory.class, jpqlWhere = " e.endTime is not null ", sort = { @SortField(field = ActProcessInstanceHistoryDs.fENDTIME, desc = true) })
public class ActProcessInstanceHistoryDs extends
        AbstractBaseDs<ActProcessInstanceHistory> {

    public static final String fID = "id";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";
    public static final String fPROCESSVERSION = "processVersion";
    public static final String fCLIENTID = "clientId";
    public static final String fSTARTTIME = "startTime";
    public static final String fENDTIME = "endTime";
    public static final String fDURATION = "duration";
    public static final String fSTARTEDBY = "startedBy";
    public static final String fSTARTACTION = "startAction";
    public static final String fENDACTION = "endAction";

    @DsField()
    private String id;

    @DsField()
    private String processInstanceId;

    @DsField(join = "left", path = "processDefinition.id")
    private String processId;

    @DsField(join = "left", path = "processDefinition.name")
    private String process;

    @DsField(join = "left", path = "processDefinition.procDefVersion")
    private Integer processVersion;

    @DsField(join = "left", path = "processDefinition.clientId")
    private Long clientId;

    @DsField(jpqlFilter = " e.endTime >= :startTime")
    private Date startTime;

    @DsField(jpqlFilter = " e.startTime <= :endTime")
    private Date endTime;

    @DsField()
    private Long duration;

    @DsField()
    private String startedBy;

    @DsField()
    private String startAction;

    @DsField()
    private String endAction;

    public ActProcessInstanceHistoryDs() {
        super();
    }

    public ActProcessInstanceHistoryDs(ActProcessInstanceHistory e) {
        super(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
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

    public Integer getProcessVersion() {
        return this.processVersion;
    }

    public void setProcessVersion(Integer processVersion) {
        this.processVersion = processVersion;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getStartedBy() {
        return this.startedBy;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
    }

    public String getStartAction() {
        return this.startAction;
    }

    public void setStartAction(String startAction) {
        this.startAction = startAction;
    }

    public String getEndAction() {
        return this.endAction;
    }

    public void setEndAction(String endAction) {
        this.endAction = endAction;
    }

}
