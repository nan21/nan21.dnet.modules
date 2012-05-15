/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccOperation;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccOperation.class, jpqlWhere = " e.headerLine = false ")
public class AccOperationDs extends AbstractAuditableDs<AccOperation> {

    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";
    public static final String fDOCNO = "docNo";
    public static final String fBPARTNERID = "bpartnerId";
    public static final String fBPARTNER = "bpartner";
    public static final String fEVENTDATE = "eventDate";
    public static final String fDBACCOUNT = "dbAccount";
    public static final String fCRACCOUNT = "crAccount";
    public static final String fDBAMOUNT = "dbAmount";
    public static final String fCRAMOUNT = "crAmount";
    public static final String fNOTES = "notes";
    public static final String fACCDOCLINEID = "accDocLineId";

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

    @DsField(join = "left", path = "accDoc.docNo")
    private String docNo;

    @DsField(join = "left", path = "accDoc.bpartner.id")
    private Long bpartnerId;

    @DsField(join = "left", path = "accDoc.bpartner.name")
    private String bpartner;

    @DsField()
    private Date eventDate;

    @DsField()
    private String dbAccount;

    @DsField()
    private String crAccount;

    @DsField()
    private Float dbAmount;

    @DsField()
    private Float crAmount;

    @DsField()
    private String notes;

    @DsField(join = "left", path = "accDocLine.id")
    private Long accDocLineId;

    public AccOperationDs() {
        super();
    }

    public AccOperationDs(AccOperation e) {
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

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
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

    public Long getAccDocLineId() {
        return this.accDocLineId;
    }

    public void setAccDocLineId(Long accDocLineId) {
        this.accDocLineId = accDocLineId;
    }

}
