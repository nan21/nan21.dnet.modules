/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Product attachments.
 * Read only reference fields are a temporary hack due to the fact that the 
 * SINGLE_TABLE inheritance DDL generation cannot update the root table 
 * 
 */
@Entity
@Table(name = Attachment.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Attachment.NQ_FIND_BY_ID, query = "SELECT e FROM Attachment e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Attachment.NQ_FIND_BY_IDS, query = "SELECT e FROM Attachment e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Attachment extends AbstractAuditable {

    public static final String TABLE_NAME = "AD_ATCH";
    public static final String SEQUENCE_NAME = "AD_ATCH_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Attachment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Attachment.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Name. */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Location. */
    @Column(name = "LOCATION", length = 400)
    private String location;

    /** ContentType. */
    @Column(name = "CONTENTTYPE", length = 4)
    private String contentType;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

    /** TargetType. */
    @Column(name = "TARGETTYPE", length = 255)
    private String targetType;

    /** TargetUuid. */
    @Column(name = "TARGETUUID", length = 36)
    private String targetUuid;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AttachmentType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private AttachmentType type;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Transient
    public String getUrl() {

        if (this.location != null) {
            if (this.location.startsWith("http")) {
                return this.location;
            } else {
                return this.type.getBaseUrl() + "/" + this.location;
            }
        } else {
            return this.type.getBaseUrl() + "/" + this.id + "."
                    + this.contentType;
        }
    }

    public void setUrl(String url) {

    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetUuid() {
        return this.targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public AttachmentType getType() {
        return this.type;
    }

    public void setType(AttachmentType type) {
        if (type != null) {
            this.__validate_client_context__(type.getClientId());
        }
        this.type = type;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
