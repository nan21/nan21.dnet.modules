/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
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

/** ActAttachment. */
@Entity
@Table(name = ActAttachment.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ActAttachment.NQ_FIND_BY_ID, query = "SELECT e FROM ActAttachment e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActAttachment.NQ_FIND_BY_IDS, query = "SELECT e FROM ActAttachment e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActAttachment implements Serializable, IModelWithId {

    public static final String TABLE_NAME = "ACT_HI_ATTACHMENT";
    public static final String SEQUENCE_NAME = "ACT_HI_ATTACHMENT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActAttachment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActAttachment.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_")
    private Integer revision;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Description. */
    @Column(name = "DESCRIPTION_", length = 4000)
    private String description;

    /** Type. */
    @Column(name = "TYPE_", length = 255)
    private String type;

    /** Url. */
    @Column(name = "URL_", length = 255)
    private String url;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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
