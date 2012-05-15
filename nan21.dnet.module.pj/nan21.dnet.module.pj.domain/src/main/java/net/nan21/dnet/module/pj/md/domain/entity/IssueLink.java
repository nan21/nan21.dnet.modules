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
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** IssueLink. */
@Entity
@Table(name = IssueLink.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = IssueLink.NQ_FIND_BY_ID, query = "SELECT e FROM IssueLink e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = IssueLink.NQ_FIND_BY_IDS, query = "SELECT e FROM IssueLink e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class IssueLink extends AbstractAuditable {

    public static final String TABLE_NAME = "PJ_ISSUE_LINK";
    public static final String SEQUENCE_NAME = "PJ_ISSUE_LINK_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "IssueLink.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "IssueLink.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
    @JoinColumn(name = "SOURCEISSUE_ID", referencedColumnName = "ID")
    private Issue sourceIssue;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
    @JoinColumn(name = "TARGETISSUE_ID", referencedColumnName = "ID")
    private Issue targetIssue;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueLinkType.class)
    @JoinColumn(name = "LINKTYPE_ID", referencedColumnName = "ID")
    private IssueLinkType linkType;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issue getSourceIssue() {
        return this.sourceIssue;
    }

    public void setSourceIssue(Issue sourceIssue) {
        this.sourceIssue = sourceIssue;
    }

    public Issue getTargetIssue() {
        return this.targetIssue;
    }

    public void setTargetIssue(Issue targetIssue) {
        this.targetIssue = targetIssue;
    }

    public IssueLinkType getLinkType() {
        return this.linkType;
    }

    public void setLinkType(IssueLinkType linkType) {
        this.linkType = linkType;
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
