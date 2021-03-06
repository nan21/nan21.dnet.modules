/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.domain.entity;

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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** AccOperation. */
@Entity
@Table(name = AccOperation.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AccOperation.NQ_FIND_BY_ID, query = "SELECT e FROM AccOperation e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AccOperation.NQ_FIND_BY_IDS, query = "SELECT e FROM AccOperation e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AccOperation extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_ACC_OPR";
    public static final String SEQUENCE_NAME = "TX_ACC_OPR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AccOperation.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AccOperation.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** HeaderLine. */
    @Column(name = "HEADERLINE", nullable = false)
    @NotNull
    private Boolean headerLine;

    /** EventDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENTDATE", nullable = false)
    @NotNull
    private Date eventDate;

    /** DbAccount. */
    @Column(name = "DBACCOUNT", length = 255)
    private String dbAccount;

    /** CrAccount. */
    @Column(name = "CRACCOUNT", length = 255)
    private String crAccount;

    /** DbAmount. */
    @Column(name = "DBAMOUNT", scale = 2)
    private Float dbAmount;

    /** CrAmount. */
    @Column(name = "CRAMOUNT", scale = 2)
    private Float crAmount;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalPeriod.class)
    @JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID")
    private FiscalPeriod period;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccDoc.class)
    @JoinColumn(name = "ACCDOC_ID", referencedColumnName = "ID")
    private AccDoc accDoc;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccDocLine.class)
    @JoinColumn(name = "ACCDOCLINE_ID", referencedColumnName = "ID")
    private AccDocLine accDocLine;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHeaderLine() {
        return this.headerLine;
    }

    public void setHeaderLine(Boolean headerLine) {
        this.headerLine = headerLine;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDbAccount() {
        return this.dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

    public String getCrAccount() {
        return this.crAccount;
    }

    public void setCrAccount(String crAccount) {
        this.crAccount = crAccount;
    }

    public Float getDbAmount() {
        return this.dbAmount;
    }

    public void setDbAmount(Float dbAmount) {
        this.dbAmount = dbAmount;
    }

    public Float getCrAmount() {
        return this.crAmount;
    }

    public void setCrAmount(Float crAmount) {
        this.crAmount = crAmount;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        if (org != null) {
            this.__validate_client_context__(org.getClientId());
        }
        this.org = org;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        if (accSchema != null) {
            this.__validate_client_context__(accSchema.getClientId());
        }
        this.accSchema = accSchema;
    }

    public FiscalPeriod getPeriod() {
        return this.period;
    }

    public void setPeriod(FiscalPeriod period) {
        if (period != null) {
            this.__validate_client_context__(period.getClientId());
        }
        this.period = period;
    }

    public AccDoc getAccDoc() {
        return this.accDoc;
    }

    public void setAccDoc(AccDoc accDoc) {
        if (accDoc != null) {
            this.__validate_client_context__(accDoc.getClientId());
        }
        this.accDoc = accDoc;
    }

    public AccDocLine getAccDocLine() {
        return this.accDocLine;
    }

    public void setAccDocLine(AccDocLine accDocLine) {
        if (accDocLine != null) {
            this.__validate_client_context__(accDocLine.getClientId());
        }
        this.accDocLine = accDocLine;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getHeaderLine() == null) {
            event.updateAttributeWithObject("headerLine", false);
        }
    }

}
