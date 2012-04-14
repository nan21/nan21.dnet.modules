/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActProcessInstanceHistoryDsFilter extends AbstractBaseDsFilter {

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

    private Date endTime;

    private Date endTime_From;
    private Date endTime_To;

    private Long duration;

    private Long duration_From;
    private Long duration_To;

    private String startedBy;

    private String startAction;

    private String endAction;

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

    public Date getEndTime() {
        return this.endTime;
    }

    public Date getEndTime_From() {
        return this.endTime_From;
    }

    public Date getEndTime_To() {
        return this.endTime_To;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setEndTime_From(Date endTime_From) {
        this.endTime_From = endTime_From;
    }

    public void setEndTime_To(Date endTime_To) {
        this.endTime_To = endTime_To;
    }

    public Long getDuration() {
        return this.duration;
    }

    public Long getDuration_From() {
        return this.duration_From;
    }

    public Long getDuration_To() {
        return this.duration_To;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public void setDuration_From(Long duration_From) {
        this.duration_From = duration_From;
    }

    public void setDuration_To(Long duration_To) {
        this.duration_To = duration_To;
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
