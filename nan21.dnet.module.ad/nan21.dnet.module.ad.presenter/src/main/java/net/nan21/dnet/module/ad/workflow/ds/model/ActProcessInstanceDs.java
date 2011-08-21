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

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActProcessInstanceHistory.class, jpqlWhere = " e.id in (select x.id from ActExecution x ) ", sort = { @SortField(field = ActProcessInstanceDs.fSTARTTIME, desc = true) })
public class ActProcessInstanceDs extends
        AbstractDsModel<ActProcessInstanceHistory> implements IModelWithId {

    public static final String fID = "id";
    public static final String fPROCESSINSTANCEID = "processInstanceId";
    public static final String fPROCESSID = "processId";
    public static final String fPROCESS = "process";
    public static final String fPROCESSVERSION = "processVersion";
    public static final String fSTARTTIME = "startTime";
    public static final String fSTARTEDBY = "startedBy";
    public static final String fSTARTACTION = "startAction";

    @DsField()
    private String id;

    @DsField()
    private String processInstanceId;

    @DsField(join = "left", path = "processDefinition.id")
    private String processId;

    @DsField(join = "left", path = "processDefinition.name")
    private String process;

    @DsField(join = "left", path = "processDefinition.version")
    private Long processVersion;

    @DsField()
    private Date startTime;

    @DsField()
    private String startedBy;

    @DsField()
    private String startAction;

    public ActProcessInstanceDs() {
        super();
    }

    public ActProcessInstanceDs(ActProcessInstanceHistory e) {
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

    public Long getProcessVersion() {
        return this.processVersion;
    }

    public void setProcessVersion(Long processVersion) {
        this.processVersion = processVersion;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

}
