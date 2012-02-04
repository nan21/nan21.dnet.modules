/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ActProcessInstanceDsFilter extends AbstractDsFilter implements
        IModelWithId {

    private String id;

    private String processInstanceId;

    private String processId;

    private String process;

    private Long processVersion;

    private Long processVersion_From;
    private Long processVersion_To;

    private Date startTime;

    private Date startTime_From;
    private Date startTime_To;

    private String startedBy;

    private String startAction;

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

    public Long getProcessVersion_From() {
        return this.processVersion_From;
    }

    public Long getProcessVersion_To() {
        return this.processVersion_To;
    }

    public void setProcessVersion(Long processVersion) {
        this.processVersion = processVersion;
    }

    public void setProcessVersion_From(Long processVersion_From) {
        this.processVersion_From = processVersion_From;
    }

    public void setProcessVersion_To(Long processVersion_To) {
        this.processVersion_To = processVersion_To;
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
