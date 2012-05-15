/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.domain.entity;

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
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** AccOperation. */
@Entity
@Table(name = AccOperation.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AccOperation.NQ_FIND_BY_ID, query = "SELECT e FROM AccOperation e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AccOperation.NQ_FIND_BY_IDS, query = "SELECT e FROM AccOperation e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AccOperation extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_ACC_OPERATION";
    public static final String SEQUENCE_NAME = "TX_ACC_OPERATION_SEQ";

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
    @Column(name = "DBACCOUNT", nullable = false, length = 255)
    @NotBlank
    private String dbAccount;

    /** CrAccount. */
    @Column(name = "CRACCOUNT", nullable = false, length = 255)
    @NotBlank
    private String crAccount;

    /** DbAmount. */
    @Column(name = "DBAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float dbAmount;

    /** CrAmount. */
    @Column(name = "CRAMOUNT", nullable = false, scale = 2)
    @NotNull
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
        this.org = org;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        this.accSchema = accSchema;
    }

    public FiscalPeriod getPeriod() {
        return this.period;
    }

    public void setPeriod(FiscalPeriod period) {
        this.period = period;
    }

    public AccDoc getAccDoc() {
        return this.accDoc;
    }

    public void setAccDoc(AccDoc accDoc) {
        this.accDoc = accDoc;
    }

    public AccDocLine getAccDocLine() {
        return this.accDocLine;
    }

    public void setAccDocLine(AccDocLine accDocLine) {
        this.accDocLine = accDocLine;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getHeaderLine() == null) {
            event.updateAttributeWithObject("headerLine", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
