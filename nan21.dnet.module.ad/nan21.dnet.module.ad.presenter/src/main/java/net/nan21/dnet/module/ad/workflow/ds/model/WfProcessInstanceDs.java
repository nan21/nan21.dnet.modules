/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcessInstance;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = WfProcessInstance.class)
public class WfProcessInstanceDs extends AbstractDsModel<WfProcessInstance>
        implements IModelWithId {

    public static final String fID = "id";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";
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

    @DsField(join = "left", path = "process.id")
    private String processId;

    @DsField(join = "left", path = "process.name")
    private String process;

    @DsField()
    private Date startTime;

    @DsField()
    private Date endTime;

    @DsField()
    private Long duration;

    @DsField()
    private String startedBy;

    @DsField()
    private String startAction;

    @DsField()
    private String endAction;

    public WfProcessInstanceDs() {
        super();
    }

    public WfProcessInstanceDs(WfProcessInstance e) {
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
