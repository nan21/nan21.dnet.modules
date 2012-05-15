/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccDoc.class, sort = { @SortField(field = AccDocDs.fDOCDATE) })
public class AccDocDs extends AbstractAuditableDs<AccDoc> {

    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";
    public static final String fJOURNALID = "journalId";
    public static final String fJOURNAL = "journal";
    public static final String fBPARTNERID = "bpartnerId";
    public static final String fBPARTNER = "bpartner";
    public static final String fDOCNO = "docNo";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fDOCDATE = "docDate";
    public static final String fDOCNETAMOUNT = "docNetAmount";
    public static final String fDOCTAXAMOUNT = "docTaxAmount";
    public static final String fDOCAMOUNT = "docAmount";
    public static final String fDOCCURRENCYID = "docCurrencyId";
    public static final String fDOCCURRENCY = "docCurrency";
    public static final String fDBAMOUNT = "dbAmount";
    public static final String fCRAMOUNT = "crAmount";
    public static final String fDIFFERENCE = "difference";
    public static final String fPOSTED = "posted";

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "period.id")
    private Long periodId;

    @DsField(join = "left", path = "period.code")
    private String period;

    @DsField(join = "left", path = "journal.id")
    private Long journalId;

    @DsField(join = "left", path = "journal.name")
    private String journal;

    @DsField(join = "left", path = "bpartner.id")
    private Long bpartnerId;

    @DsField(join = "left", path = "bpartner.name")
    private String bpartner;

    @DsField()
    private String docNo;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField()
    private Date docDate;

    @DsField()
    private Float docNetAmount;

    @DsField()
    private Float docTaxAmount;

    @DsField()
    private Float docAmount;

    @DsField(join = "left", path = "docCurrency.id")
    private Long docCurrencyId;

    @DsField(join = "left", path = "docCurrency.code")
    private String docCurrency;

    @DsField()
    private Float dbAmount;

    @DsField()
    private Float crAmount;

    @DsField()
    private Float difference;

    @DsField()
    private Boolean posted;

    public AccDocDs() {
        super();
    }

    public AccDocDs(AccDoc e) {
        super(e);
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getAccSchemaId() {
        return this.accSchemaId;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public String getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(String accSchema) {
        this.accSchema = accSchema;
    }

    public Long getPeriodId() {
        return this.periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Long getJournalId() {
        return this.journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public String getJournal() {
        return this.journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Long getBpartnerId() {
        return this.bpartnerId;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

    public String getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(String bpartner) {
        this.bpartner = bpartner;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Long getDocTypeId() {
        return this.docTypeId;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
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

    public Long getDocCurrencyId() {
        return this.docCurrencyId;
    }

    public void setDocCurrencyId(Long docCurrencyId) {
        this.docCurrencyId = docCurrencyId;
    }

    public String getDocCurrency() {
        return this.docCurrency;
    }

    public void setDocCurrency(String docCurrency) {
        this.docCurrency = docCurrency;
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

}
