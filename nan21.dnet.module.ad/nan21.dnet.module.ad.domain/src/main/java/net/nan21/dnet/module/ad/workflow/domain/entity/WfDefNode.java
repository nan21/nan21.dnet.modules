/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** WfDefNode. */
@Entity
@Table(name = WfDefNode.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = WfDefNode.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_ID, query = "SELECT e FROM WfDefNode e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_IDS, query = "SELECT e FROM WfDefNode e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_NAME, query = "SELECT e FROM WfDefNode e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class WfDefNode extends AbstractType {

    public static final String TABLE_NAME = "AD_WFDEF_NODE";
    public static final String SEQUENCE_NAME = "AD_WFDEF_NODE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "WfDefNode.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "WfDefNode.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "WfDefNode.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** AssignToUser. */
    @Column(name = "ASSIGNTOUSER", length = 400)
    private String assignToUser;

    /** AssignToGroup. */
    @Column(name = "ASSIGNTOGROUP", length = 400)
    private String assignToGroup;

    /** StartWithPrevious. */
    @Column(name = "STARTWITHPREVIOUS", nullable = false)
    @NotNull
    private Boolean startWithPrevious;

    /** TaskType. */
    @Column(name = "TASKTYPE", nullable = false, length = 16)
    @NotBlank
    private String taskType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfDefProcess.class)
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "ID")
    private WfDefProcess process;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = WfDefNodeField.class, mappedBy = "node", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<WfDefNodeField> fields;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignToUser() {
        return this.assignToUser;
    }

    public void setAssignToUser(String assignToUser) {
        this.assignToUser = assignToUser;
    }

    public String getAssignToGroup() {
        return this.assignToGroup;
    }

    public void setAssignToGroup(String assignToGroup) {
        this.assignToGroup = assignToGroup;
    }

    public Boolean getStartWithPrevious() {
        return this.startWithPrevious;
    }

    public void setStartWithPrevious(Boolean startWithPrevious) {
        this.startWithPrevious = startWithPrevious;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public WfDefProcess getProcess() {
        return this.process;
    }

    public void setProcess(WfDefProcess process) {
        this.process = process;
    }

    public Collection<WfDefNodeField> getFields() {
        return this.fields;
    }

    public void setFields(Collection<WfDefNodeField> fields) {
        this.fields = fields;
    }

    public void addToFields(WfDefNodeField e) {
        if (this.fields == null) {
            this.fields = new ArrayList<WfDefNodeField>();
        }
        e.setNode(this);
        this.fields.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.startWithPrevious == null) {
            event.updateAttributeWithObject("startWithPrevious", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
