/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** QuartzCronTrigger. */
@Entity
@Table(name = QuartzCronTrigger.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzCronTrigger {

    public static final String TABLE_NAME = "XT_QRTZ_CRON_TRIGGERS";
    public static final String SEQUENCE_NAME = "XT_QRTZ_CRON_TRIGGERS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /** SchedulerName. */
    @Column(name = "SCHED_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String schedulerName;

    /** TriggerName. */
    @Column(name = "TRIGGER_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String triggerName;

    /** TriggerGroup. */
    @Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
    @NotBlank
    @Id
    private String triggerGroup;

    /** CronExpression. */
    @Column(name = "CRON_EXPRESSION", nullable = false, length = 255)
    @NotBlank
    private String cronExpression;

    /** TimeZoneID. */
    @Column(name = "TIME_ZONE_ID", length = 255)
    private String timeZoneID;

    /* ============== getters - setters ================== */

    public String getSchedulerName() {
        return this.schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getCronExpression() {
        return this.cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneID() {
        return this.timeZoneID;
    }

    public void setTimeZoneID(String timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
