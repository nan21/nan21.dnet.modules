/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActDetailHistory. */
@Entity
@Table(name = "ACT_HI_DETAIL")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "ActDetailHistory.findById", query = "SELECT e FROM ActDetailHistory e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ActDetailHistory.findByIds", query = "SELECT e FROM ActDetailHistory e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActDetailHistory implements Serializable, IModelWithId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActDetailHistory.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActDetailHistory.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false)
    @NotBlank
    @Id
    @GeneratedValue
    private String id;

    /** Type. */
    @Column(name = "TYPE_")
    private String type;

    /** Name. */
    @Column(name = "NAME_", nullable = false)
    @NotBlank
    private String name;

    /** Time. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_")
    private Date time;

    /** Revision. */
    @Column(name = "REV_", nullable = false)
    @NotNull
    private Integer revision;

    /** ActivityInstanceId. */
    @Column(name = "ACT_INST_ID_")
    private String activityInstanceId;

    /** ExecutionId. */
    @Column(name = "EXECUTION_ID_")
    private String executionId;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_")
    private String processInstanceId;

    /** TaskId. */
    @Column(name = "TASK_ID_")
    private String taskId;

    /** ByteArrayId. */
    @Column(name = "BYTEARRAY_ID_")
    private String byteArrayId;

    /** DoubleValue. */
    @Column(name = "DOUBLE_", precision = 2)
    private Float doubleValue;

    /** TextValue. */
    @Column(name = "TEXT_")
    private String textValue;

    /** TextValue2. */
    @Column(name = "TEXT2_")
    private String textValue2;

    /** LongValue. */
    @Column(name = "LONG_")
    private Long longValue;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getActivityInstanceId() {
        return this.activityInstanceId;
    }

    public void setActivityInstanceId(String activityInstanceId) {
        this.activityInstanceId = activityInstanceId;
    }

    public String getExecutionId() {
        return this.executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getByteArrayId() {
        return this.byteArrayId;
    }

    public void setByteArrayId(String byteArrayId) {
        this.byteArrayId = byteArrayId;
    }

    public Float getDoubleValue() {
        return this.doubleValue;
    }

    public void setDoubleValue(Float doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getTextValue() {
        return this.textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue2() {
        return this.textValue2;
    }

    public void setTextValue2(String textValue2) {
        this.textValue2 = textValue2;
    }

    public Long getLongValue() {
        return this.longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
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
        ActDetailHistory e = (ActDetailHistory) event.getSource();

    }

}