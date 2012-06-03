/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.entity;

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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Bookmark. */
@Entity
@Table(name = Bookmark.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Bookmark.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "OWNER", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Bookmark.NQ_FIND_BY_ID, query = "SELECT e FROM Bookmark e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Bookmark.NQ_FIND_BY_IDS, query = "SELECT e FROM Bookmark e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Bookmark.NQ_FIND_BY_NAME, query = "SELECT e FROM Bookmark e WHERE e.clientId = :pClientId and  e.owner = :pOwner and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Bookmark extends AbstractType {

    public static final String TABLE_NAME = "AD_BOOKMARK";
    public static final String SEQUENCE_NAME = "AD_BOOKMARK_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Bookmark.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Bookmark.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Bookmark.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;

    /** Title. */
    @Column(name = "TITLE", nullable = false, length = 255)
    @NotBlank
    private String title;

    /** Frame. */
    @Column(name = "FRAME", length = 255)
    private String frame;

    /** Bundle. */
    @Column(name = "BUNDLE", length = 255)
    private String bundle;

    /** SeparatorBefore. */
    @Column(name = "SEPARATORBEFORE")
    private Boolean separatorBefore;

    /** SeparatorAfter. */
    @Column(name = "SEPARATORAFTER")
    private Boolean separatorAfter;

    /** Owner. */
    @Column(name = "OWNER", nullable = false, length = 32)
    @NotBlank
    private String owner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bookmark.class)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
    private Bookmark parent;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrame() {
        return this.frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public Boolean getSeparatorBefore() {
        return this.separatorBefore;
    }

    public void setSeparatorBefore(Boolean separatorBefore) {
        this.separatorBefore = separatorBefore;
    }

    public Boolean getSeparatorAfter() {
        return this.separatorAfter;
    }

    public void setSeparatorAfter(Boolean separatorAfter) {
        this.separatorAfter = separatorAfter;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Transient
    public Boolean getLeafNode() {
        return (this.frame != null && !this.frame.equals(""));
    }

    public void setLeafNode(Boolean leafNode) {

    }

    public Bookmark getParent() {
        return this.parent;
    }

    public void setParent(Bookmark parent) {
        if (parent != null) {
            this.__validate_client_context__(parent.getClientId());
        }
        this.parent = parent;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
