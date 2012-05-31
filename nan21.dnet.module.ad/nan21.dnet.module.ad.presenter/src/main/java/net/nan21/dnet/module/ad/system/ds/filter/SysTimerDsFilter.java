/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class SysTimerDsFilter extends AbstractTypeDsFilter {

    private Long jobCtxId;

    private Long jobCtxId_From;
    private Long jobCtxId_To;

    private String jobCtx;

    private Date startTime;

    private Date startTime_From;
    private Date startTime_To;

    private Date endTime;

    private Date endTime_From;
    private Date endTime_To;

    private String type;

    private String cronExpression;

    private Integer repeatCount;

    private Integer repeatCount_From;
    private Integer repeatCount_To;

    private Integer repeatInterval;

    private Integer repeatInterval_From;
    private Integer repeatInterval_To;

    private String repeatIntervalType;

    public Long getJobCtxId() {
        return this.jobCtxId;
    }

    public Long getJobCtxId_From() {
        return this.jobCtxId_From;
    }

    public Long getJobCtxId_To() {
        return this.jobCtxId_To;
    }

    public void setJobCtxId(Long jobCtxId) {
        this.jobCtxId = jobCtxId;
    }

    public void setJobCtxId_From(Long jobCtxId_From) {
        this.jobCtxId_From = jobCtxId_From;
    }

    public void setJobCtxId_To(Long jobCtxId_To) {
        this.jobCtxId_To = jobCtxId_To;
    }

    public String getJobCtx() {
        return this.jobCtx;
    }

    public void setJobCtx(String jobCtx) {
        this.jobCtx = jobCtx;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCronExpression() {
        return this.cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getRepeatCount() {
        return this.repeatCount;
    }

    public Integer getRepeatCount_From() {
        return this.repeatCount_From;
    }

    public Integer getRepeatCount_To() {
        return this.repeatCount_To;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void setRepeatCount_From(Integer repeatCount_From) {
        this.repeatCount_From = repeatCount_From;
    }

    public void setRepeatCount_To(Integer repeatCount_To) {
        this.repeatCount_To = repeatCount_To;
    }

    public Integer getRepeatInterval() {
        return this.repeatInterval;
    }

    public Integer getRepeatInterval_From() {
        return this.repeatInterval_From;
    }

    public Integer getRepeatInterval_To() {
        return this.repeatInterval_To;
    }

    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public void setRepeatInterval_From(Integer repeatInterval_From) {
        this.repeatInterval_From = repeatInterval_From;
    }

    public void setRepeatInterval_To(Integer repeatInterval_To) {
        this.repeatInterval_To = repeatInterval_To;
    }

    public String getRepeatIntervalType() {
        return this.repeatIntervalType;
    }

    public void setRepeatIntervalType(String repeatIntervalType) {
        this.repeatIntervalType = repeatIntervalType;
    }

}
