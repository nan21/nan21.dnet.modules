/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

@Ds(entity = SysTimer.class, sort = { @SortField(field = SysTimerDs.fNAME) })
public class SysTimerDs extends AbstractTypeDs<SysTimer> {

    public static final String fJOBCTXID = "jobCtxId";
    public static final String fJOBCTX = "jobCtx";
    public static final String fSTARTTIME = "startTime";
    public static final String fENDTIME = "endTime";
    public static final String fTYPE = "type";
    public static final String fCRONEXPRESSION = "cronExpression";
    public static final String fREPEATCOUNT = "repeatCount";
    public static final String fREPEATINTERVAL = "repeatInterval";
    public static final String fREPEATINTERVALTYPE = "repeatIntervalType";

    @DsField(join = "left", path = "jobCtx.id")
    private Long jobCtxId;

    @DsField(join = "left", path = "jobCtx.name")
    private String jobCtx;

    @DsField()
    private Date startTime;

    @DsField()
    private Date endTime;

    @DsField()
    private String type;

    @DsField()
    private String cronExpression;

    @DsField()
    private Integer repeatCount;

    @DsField()
    private Integer repeatInterval;

    @DsField()
    private String repeatIntervalType;

    public SysTimerDs() {
        super();
    }

    public SysTimerDs(SysTimer e) {
        super(e);
    }

    public Long getJobCtxId() {
        return this.jobCtxId;
    }

    public void setJobCtxId(Long jobCtxId) {
        this.jobCtxId = jobCtxId;
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

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public String getRepeatIntervalType() {
        return this.repeatIntervalType;
    }

    public void setRepeatIntervalType(String repeatIntervalType) {
        this.repeatIntervalType = repeatIntervalType;
    }

}
