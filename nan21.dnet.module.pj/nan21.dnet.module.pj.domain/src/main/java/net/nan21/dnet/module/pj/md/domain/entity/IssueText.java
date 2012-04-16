/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** IssueText. */
@Entity
@Table(name = IssueText.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = IssueText.NQ_FIND_BY_ID, query = "SELECT e FROM IssueText e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = IssueText.NQ_FIND_BY_IDS, query = "SELECT e FROM IssueText e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class IssueText extends AbstractAuditable {

    public static final String TABLE_NAME = "PJ_ISSUE_TEXT";
    public static final String SEQUENCE_NAME = "PJ_ISSUE_TEXT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "IssueText.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "IssueText.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Content. */
    @Column(name = "CONTENT", length = 400)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
    @JoinColumn(name = "ISSUE_ID", referencedColumnName = "ID")
    private Issue issue;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTextType.class)
    @JoinColumn(name = "ISSUETEXTTYPE_ID", referencedColumnName = "ID")
    private IssueTextType issueTextType;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Issue getIssue() {
        return this.issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public IssueTextType getIssueTextType() {
        return this.issueTextType;
    }

    public void setIssueTextType(IssueTextType issueTextType) {
        this.issueTextType = issueTextType;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
