/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.domain.entity;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** 
 Communication channels value. Set phone number , messenger account, etc according to the selected type.  
 */
@Entity
@Table(name = CommunicationChannel.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = CommunicationChannel.NQ_FIND_BY_ID, query = "SELECT e FROM CommunicationChannel e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CommunicationChannel.NQ_FIND_BY_IDS, query = "SELECT e FROM CommunicationChannel e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CommunicationChannel extends AbstractAuditable {

    public static final String TABLE_NAME = "BD_CMNC_MTD";
    public static final String SEQUENCE_NAME = "BD_CMNC_MTD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CommunicationChannel.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CommunicationChannel.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", length = 255)
    private String value;

    /** ValidFrom. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDFROM")
    private Date validFrom;

    /** ValidTo. */
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDTO")
    private Date validTo;

    /** TargetUuid. */
    @Column(name = "TARGETUUID", length = 36)
    private String targetUuid;

    /** TargetType. */
    @Column(name = "TARGETTYPE", length = 255)
    private String targetType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CommunicationChannelType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private CommunicationChannelType type;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getTargetUuid() {
        return this.targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public CommunicationChannelType getType() {
        return this.type;
    }

    public void setType(CommunicationChannelType type) {
        if (type != null) {
            this.__validate_client_context__(type.getClientId());
        }
        this.type = type;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
