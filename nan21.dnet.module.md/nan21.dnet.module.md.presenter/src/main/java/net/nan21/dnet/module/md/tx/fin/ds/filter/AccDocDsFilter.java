/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AccDocDsFilter extends AbstractAuditableDsFilter {

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private String docNo;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private Float dbAmount;

    private Float dbAmount_From;
    private Float dbAmount_To;

    private Float crAmount;

    private Float crAmount_From;
    private Float crAmount_To;

    public Long getOrgId() {
        return this.orgId;
    }

    public Long getOrgId_From() {
        return this.orgId_From;
    }

    public Long getOrgId_To() {
        return this.orgId_To;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setOrgId_From(Long orgId_From) {
        this.orgId_From = orgId_From;
    }

    public void setOrgId_To(Long orgId_To) {
        this.orgId_To = orgId_To;
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

    public Long getAccSchemaId_From() {
        return this.accSchemaId_From;
    }

    public Long getAccSchemaId_To() {
        return this.accSchemaId_To;
    }

    public void setAccSchemaId(Long accSchemaId) {
        this.accSchemaId = accSchemaId;
    }

    public void setAccSchemaId_From(Long accSchemaId_From) {
        this.accSchemaId_From = accSchemaId_From;
    }

    public void setAccSchemaId_To(Long accSchemaId_To) {
        this.accSchemaId_To = accSchemaId_To;
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

    public Long getDocTypeId_From() {
        return this.docTypeId_From;
    }

    public Long getDocTypeId_To() {
        return this.docTypeId_To;
    }

    public void setDocTypeId(Long docTypeId) {
        this.docTypeId = docTypeId;
    }

    public void setDocTypeId_From(Long docTypeId_From) {
        this.docTypeId_From = docTypeId_From;
    }

    public void setDocTypeId_To(Long docTypeId_To) {
        this.docTypeId_To = docTypeId_To;
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

    public Date getDocDate_From() {
        return this.docDate_From;
    }

    public Date getDocDate_To() {
        return this.docDate_To;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public void setDocDate_From(Date docDate_From) {
        this.docDate_From = docDate_From;
    }

    public void setDocDate_To(Date docDate_To) {
        this.docDate_To = docDate_To;
    }

    public Float getDbAmount() {
        return this.dbAmount;
    }

    public Float getDbAmount_From() {
        return this.dbAmount_From;
    }

    public Float getDbAmount_To() {
        return this.dbAmount_To;
    }

    public void setDbAmount(Float dbAmount) {
        this.dbAmount = dbAmount;
    }

    public void setDbAmount_From(Float dbAmount_From) {
        this.dbAmount_From = dbAmount_From;
    }

    public void setDbAmount_To(Float dbAmount_To) {
        this.dbAmount_To = dbAmount_To;
    }

    public Float getCrAmount() {
        return this.crAmount;
    }

    public Float getCrAmount_From() {
        return this.crAmount_From;
    }

    public Float getCrAmount_To() {
        return this.crAmount_To;
    }

    public void setCrAmount(Float crAmount) {
        this.crAmount = crAmount;
    }

    public void setCrAmount_From(Float crAmount_From) {
        this.crAmount_From = crAmount_From;
    }

    public void setCrAmount_To(Float crAmount_To) {
        this.crAmount_To = crAmount_To;
    }

}
