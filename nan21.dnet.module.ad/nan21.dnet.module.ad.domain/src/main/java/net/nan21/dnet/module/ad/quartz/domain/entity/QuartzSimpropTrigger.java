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

/** QuartzSimpropTrigger. */
@Entity
@Table(name = QuartzSimpropTrigger.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzSimpropTrigger {

    public static final String TABLE_NAME = "XT_QRTZ_SIMPROP_TRIGGERS";
    public static final String SEQUENCE_NAME = "XT_QRTZ_SIMPROP_TRIGGERS_SEQ";

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

    /** StrProp1. */
    @Column(name = "STR_PROP_1", length = 4000)
    private String strProp1;

    /** StrProp2. */
    @Column(name = "STR_PROP_2", length = 4000)
    private String strProp2;

    /** StrProp3. */
    @Column(name = "STR_PROP_3", length = 4000)
    private String strProp3;

    /** IntProp1. */
    @Column(name = "INT_PROP_1")
    private Integer intProp1;

    /** IntProp2. */
    @Column(name = "INT_PROP_2")
    private Integer intProp2;

    /** LongProp1. */
    @Column(name = "LONG_PROP_1")
    private Long longProp1;

    /** LongProp2. */
    @Column(name = "LONG_PROP_2")
    private Long longProp2;

    /** DecProp1. */
    @Column(name = "DEC_PROP_1")
    private Float decProp1;

    /** DecProp2. */
    @Column(name = "DEC_PROP_2")
    private Float decProp2;

    /** BoolProp1. */
    @Column(name = "BOOL_PROP_1", length = 1)
    private String boolProp1;

    /** BoolProp2. */
    @Column(name = "BOOL_PROP_2", length = 1)
    private String boolProp2;

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

    public String getStrProp1() {
        return this.strProp1;
    }

    public void setStrProp1(String strProp1) {
        this.strProp1 = strProp1;
    }

    public String getStrProp2() {
        return this.strProp2;
    }

    public void setStrProp2(String strProp2) {
        this.strProp2 = strProp2;
    }

    public String getStrProp3() {
        return this.strProp3;
    }

    public void setStrProp3(String strProp3) {
        this.strProp3 = strProp3;
    }

    public Integer getIntProp1() {
        return this.intProp1;
    }

    public void setIntProp1(Integer intProp1) {
        this.intProp1 = intProp1;
    }

    public Integer getIntProp2() {
        return this.intProp2;
    }

    public void setIntProp2(Integer intProp2) {
        this.intProp2 = intProp2;
    }

    public Long getLongProp1() {
        return this.longProp1;
    }

    public void setLongProp1(Long longProp1) {
        this.longProp1 = longProp1;
    }

    public Long getLongProp2() {
        return this.longProp2;
    }

    public void setLongProp2(Long longProp2) {
        this.longProp2 = longProp2;
    }

    public Float getDecProp1() {
        return this.decProp1;
    }

    public void setDecProp1(Float decProp1) {
        this.decProp1 = decProp1;
    }

    public Float getDecProp2() {
        return this.decProp2;
    }

    public void setDecProp2(Float decProp2) {
        this.decProp2 = decProp2;
    }

    public String getBoolProp1() {
        return this.boolProp1;
    }

    public void setBoolProp1(String boolProp1) {
        this.boolProp1 = boolProp1;
    }

    public String getBoolProp2() {
        return this.boolProp2;
    }

    public void setBoolProp2(String boolProp2) {
        this.boolProp2 = boolProp2;
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
