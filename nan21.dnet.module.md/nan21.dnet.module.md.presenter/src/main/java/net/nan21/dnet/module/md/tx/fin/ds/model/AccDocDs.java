/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccDoc.class)
public class AccDocDs extends AbstractAuditableDs<AccDoc> {

    public static final String fORGID = "orgId";
    public static final String fORG = "org";
    public static final String fACCSCHEMAID = "accSchemaId";
    public static final String fACCSCHEMA = "accSchema";
    public static final String fDOCNO = "docNo";
    public static final String fDOCTYPEID = "docTypeId";
    public static final String fDOCTYPE = "docType";
    public static final String fDOCDATE = "docDate";
    public static final String fDBAMOUNT = "dbAmount";
    public static final String fCRAMOUNT = "crAmount";

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    @DsField(join = "left", path = "accSchema.id")
    private Long accSchemaId;

    @DsField(join = "left", path = "accSchema.code")
    private String accSchema;

    @DsField()
    private String docNo;

    @DsField(join = "left", path = "docType.id")
    private Long docTypeId;

    @DsField(join = "left", path = "docType.name")
    private String docType;

    @DsField()
    private Date docDate;

    @DsField()
    private Float dbAmount;

    @DsField()
    private Float crAmount;

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
