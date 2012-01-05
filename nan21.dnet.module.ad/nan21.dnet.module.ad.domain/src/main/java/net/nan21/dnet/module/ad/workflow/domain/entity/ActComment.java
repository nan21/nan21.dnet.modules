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

/** ActComment. */
@Entity
@Table(name = ActComment.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ActComment.NQ_FIND_BY_ID, query = "SELECT e FROM ActComment e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActComment.NQ_FIND_BY_IDS, query = "SELECT e FROM ActComment e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActComment implements Serializable, IModelWithId {

    public static final String TABLE_NAME = "ACT_HI_COMMENT";
    public static final String SEQUENCE_NAME = "ACT_HI_COMMENT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActComment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActComment.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Type. */
    @Column(name = "TYPE_", length = 255)
    private String type;

    /** StartTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME_", nullable = false)
    @NotNull
    private Date startTime;

    /** Message. */
    @Column(name = "MESSAGE_", length = 4000)
    private String message;

    /** FullMessage. */
    @Column(name = "FULL_MSG_", length = 4000)
    private String fullMessage;

    /** Time. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_")
    private Date time;

    /** Action. */
    @Column(name = "ACTION_", length = 255)
    private String action;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_", length = 255)
    private String processInstanceId;

    /** TaskId. */
    @Column(name = "TASK_ID_", length = 255)
    private String taskId;

    /** UserId. */
    @Column(name = "USER_ID_", length = 255)
    private String userId;

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

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFullMessage() {
        return this.fullMessage;
    }

    public void setFullMessage(String fullMessage) {
        this.fullMessage = fullMessage;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
