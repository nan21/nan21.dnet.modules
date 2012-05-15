/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccDocLine.class, sort = {
        @SortField(field = AccDocLineCtxDs.fACCSCHEMAID),
        @SortField(field = AccDocLineCtxDs.fACCDOCID),
        @SortField(field = AccDocLineCtxDs.fSEQUENCENO) })
public class AccDocLineCtxDs extends AbstractAuditableDs<AccDocLine> {

    public static final String fACCDOCID = "accDocId";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fDOCUUID = "docUuid";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDBACCOUNT = "dbAccount";
    public static final String fCRACCOUNT = "crAccount";
    public static final String fDBAMOUNT = "dbAmount";
    public static final String fCRAMOUNT = "crAmount";

    @DsField(join = "left", path = "accDoc.id")
    private Long accDocId;

    @DsField(join = "left", path = "accDoc.accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accDoc.accSchema.code")
    private String accSchema;

    @DsField(join = "left", path = "accDoc.docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "accDoc.docType.name")
    private String docType;

    @DsField(join = "left", path = "accDoc.docUuid")
    private String docUuid;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String dbAccount;

    @DsField()
    private String crAccount;

    @DsField()
    private Float dbAmount;

    @DsField()
    private Float crAmount;

    public AccDocLineCtxDs() {
        super();
    }

    public AccDocLineCtxDs(AccDocLine e) {
        super(e);
    }

    public Long getAccDocId() {
        return this.accDocId;
    }

    public void setAccDocId(Long accDocId) {
        this.accDocId = accDocId;
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

    public String getDocUuid() {
        return this.docUuid;
    }

    public void setDocUuid(String docUuid) {
        this.docUuid = docUuid;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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

}
