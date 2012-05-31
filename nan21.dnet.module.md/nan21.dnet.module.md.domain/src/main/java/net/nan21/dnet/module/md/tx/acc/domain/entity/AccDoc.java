/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.domain.entity;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** AccDoc. */
@Entity
@Table(name = AccDoc.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AccDoc.NQ_FIND_BY_ID, query = "SELECT e FROM AccDoc e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AccDoc.NQ_FIND_BY_IDS, query = "SELECT e FROM AccDoc e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AccDoc extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_ACC_DOC";
    public static final String SEQUENCE_NAME = "TX_ACC_DOC_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AccDoc.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AccDoc.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** DocNo. */
    @Column(name = "DOCNO", length = 255)
    private String docNo;

    /** DocDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DOCDATE", nullable = false)
    @NotNull
    private Date docDate;

    /** DocUuid. */
    @Column(name = "DOCUUID", length = 36)
    private String docUuid;

    /** DocNetAmount. */
    @Column(name = "DOCNETAMOUNT", scale = 2)
    private Float docNetAmount;

    /** DocTaxAmount. */
    @Column(name = "DOCTAXAMOUNT", scale = 2)
    private Float docTaxAmount;

    /** DocAmount. */
    @Column(name = "DOCAMOUNT", scale = 2)
    private Float docAmount;

    /** DbAmount. */
    @Column(name = "DBAMOUNT", scale = 2)
    private Float dbAmount;

    /** CrAmount. */
    @Column(name = "CRAMOUNT", scale = 2)
    private Float crAmount;

    /** Difference. */
    @Column(name = "DIFFERENCE", scale = 2)
    private Float difference;

    /** Posted. */
    @Column(name = "POSTED", nullable = false)
    @NotNull
    private Boolean posted;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalPeriod.class)
    @JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID")
    private FiscalPeriod period;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccJournal.class)
    @JoinColumn(name = "JOURNAL_ID", referencedColumnName = "ID")
    private AccJournal journal;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "DOCCURRENCY_ID", referencedColumnName = "ID")
    private Currency docCurrency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
    @JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
    private TxDocType docType;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = AccDocLine.class, mappedBy = "accDoc", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<AccDocLine> lines;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocUuid() {
        return this.docUuid;
    }

    public void setDocUuid(String docUuid) {
        this.docUuid = docUuid;
    }

    public Float getDocNetAmount() {
        return this.docNetAmount;
    }

    public void setDocNetAmount(Float docNetAmount) {
        this.docNetAmount = docNetAmount;
    }

    public Float getDocTaxAmount() {
        return this.docTaxAmount;
    }

    public void setDocTaxAmount(Float docTaxAmount) {
        this.docTaxAmount = docTaxAmount;
    }

    public Float getDocAmount() {
        return this.docAmount;
    }

    public void setDocAmount(Float docAmount) {
        this.docAmount = docAmount;
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

    public Float getDifference() {
        return this.difference;
    }

    public void setDifference(Float difference) {
        this.difference = difference;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
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

    public AccJournal getJournal() {
        return this.journal;
    }

    public void setJournal(AccJournal journal) {
        this.journal = journal;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public Currency getDocCurrency() {
        return this.docCurrency;
    }

    public void setDocCurrency(Currency docCurrency) {
        this.docCurrency = docCurrency;
    }

    public TxDocType getDocType() {
        return this.docType;
    }

    public void setDocType(TxDocType docType) {
        this.docType = docType;
    }

    public Collection<AccDocLine> getLines() {
        return this.lines;
    }

    public void setLines(Collection<AccDocLine> lines) {
        this.lines = lines;
    }

    public void addToLines(AccDocLine e) {
        if (this.lines == null) {
            this.lines = new ArrayList<AccDocLine>();
        }
        e.setAccDoc(this);
        this.lines.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getPosted() == null) {
            event.updateAttributeWithObject("posted", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
