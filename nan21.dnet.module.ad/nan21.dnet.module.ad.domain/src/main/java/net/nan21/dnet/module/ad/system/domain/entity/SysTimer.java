/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** SysTimer. */
@Entity
@Table(name = SysTimer.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = SysTimer.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "JOBCTX_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SysTimer.NQ_FIND_BY_ID, query = "SELECT e FROM SysTimer e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysTimer.NQ_FIND_BY_IDS, query = "SELECT e FROM SysTimer e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysTimer.NQ_FIND_BY_NAME, query = "SELECT e FROM SysTimer e WHERE e.clientId = :pClientId and  e.jobCtx = :pJobCtx and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SysTimer.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM SysTimer e WHERE e.clientId = :pClientId and  e.jobCtx.id = :pJobCtxId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SysTimer extends AbstractType {

    public static final String TABLE_NAME = "AD_SYS_TIMER";
    public static final String SEQUENCE_NAME = "AD_SYS_TIMER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SysTimer.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SysTimer.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "SysTimer.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "SysTimer.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Type. */
    @Column(name = "TYPE", nullable = false, length = 16)
    @NotBlank
    private String type;

    /** CronExpression. */
    @Column(name = "CRONEXPRESSION", length = 400)
    private String cronExpression;

    /** RepeatCount. */
    @Column(name = "REPEATCOUNT")
    private Integer repeatCount;

    /** RepeatInterval. */
    @Column(name = "REPEATINTERVAL")
    private Integer repeatInterval;

    /** RepeatIntervalType. */
    @Column(name = "REPEATINTERVALTYPE", length = 16)
    private String repeatIntervalType;

    /** StartTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTTIME", nullable = false)
    @NotNull
    private Date startTime;

    /** EndTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDTIME")
    private Date endTime;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SysJobCtx.class)
    @JoinColumn(name = "JOBCTX_ID", referencedColumnName = "ID")
    private SysJobCtx jobCtx;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SysJobCtx getJobCtx() {
        return this.jobCtx;
    }

    public void setJobCtx(SysJobCtx jobCtx) {
        if (jobCtx != null) {
            this.__validate_client_context__(jobCtx.getClientId());
        }
        this.jobCtx = jobCtx;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
