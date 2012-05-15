/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** IssueTask. */
@Entity
@Table(name = IssueTask.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = IssueTask.NQ_FIND_BY_ID, query = "SELECT e FROM IssueTask e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = IssueTask.NQ_FIND_BY_IDS, query = "SELECT e FROM IssueTask e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class IssueTask extends AbstractAuditable {

    public static final String TABLE_NAME = "PJ_ISSUE_TASK";
    public static final String SEQUENCE_NAME = "PJ_ISSUE_TASK_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "IssueTask.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "IssueTask.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
    @JoinColumn(name = "ISSUE_ID", referencedColumnName = "ID")
    private Issue issue;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTaskType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private IssueTaskType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTaskStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private IssueTaskStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectMember.class)
    @JoinColumn(name = "ASSIGNEE_ID", referencedColumnName = "ID")
    private ProjectMember assignee;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Issue getIssue() {
        return this.issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public IssueTaskType getType() {
        return this.type;
    }

    public void setType(IssueTaskType type) {
        this.type = type;
    }

    public IssueTaskStatus getStatus() {
        return this.status;
    }

    public void setStatus(IssueTaskStatus status) {
        this.status = status;
    }

    public ProjectMember getAssignee() {
        return this.assignee;
    }

    public void setAssignee(ProjectMember assignee) {
        this.assignee = assignee;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "T-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
