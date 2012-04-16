/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActVariable. */
@Entity
@Table(name = ActVariable.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ActVariable.NQ_FIND_BY_ID, query = "SELECT e FROM ActVariable e WHERE  e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActVariable.NQ_FIND_BY_IDS, query = "SELECT e FROM ActVariable e WHERE  e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActVariable {

    public static final String TABLE_NAME = "ACT_RU_VARIABLE";
    public static final String SEQUENCE_NAME = "ACT_RU_VARIABLE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActVariable.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActVariable.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_", nullable = false)
    @NotNull
    private Integer revision;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Type. */
    @Column(name = "TYPE_", length = 255)
    private String type;

    /** ExecutionId. */
    @Column(name = "EXECUTION_ID_", length = 255)
    private String executionId;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_", length = 255)
    private String processInstanceId;

    /** TaskId. */
    @Column(name = "TASK_ID_", length = 255)
    private String taskId;

    /** ByteArrayId. */
    @Column(name = "BYTEARRAY_ID_", length = 255)
    private String byteArrayId;

    /** DoubleValue. */
    @Column(name = "DOUBLE_", scale = 2)
    private Float doubleValue;

    /** TextValue. */
    @Column(name = "TEXT_", length = 4000)
    private String textValue;

    /** TextValue2. */
    @Column(name = "TEXT2_", length = 4000)
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

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    }

}
