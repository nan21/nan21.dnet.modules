/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AccOperationDsFilter extends AbstractAuditableDsFilter {

    private Long orgId;

    private Long orgId_From;
    private Long orgId_To;

    private String org;

    private Long accSchemaId;

    private Long accSchemaId_From;
    private Long accSchemaId_To;

    private String accSchema;

    private Long periodId;

    private Long periodId_From;
    private Long periodId_To;

    private String period;

    private String docNo;

    private Long bpartnerId;

    private Long bpartnerId_From;
    private Long bpartnerId_To;

    private String bpartner;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    private String dbAccount;

    private String crAccount;

    private Float dbAmount;

    private Float dbAmount_From;
    private Float dbAmount_To;

    private Float crAmount;

    private Float crAmount_From;
    private Float crAmount_To;

    private String notes;

    private Long accDocLineId;

    private Long accDocLineId_From;
    private Long accDocLineId_To;

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

    public Long getPeriodId() {
        return this.periodId;
    }

    public Long getPeriodId_From() {
        return this.periodId_From;
    }

    public Long getPeriodId_To() {
        return this.periodId_To;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public void setPeriodId_From(Long periodId_From) {
        this.periodId_From = periodId_From;
    }

    public void setPeriodId_To(Long periodId_To) {
        this.periodId_To = periodId_To;
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

    public Long getBpartnerId_From() {
        return this.bpartnerId_From;
    }

    public Long getBpartnerId_To() {
        return this.bpartnerId_To;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

    public void setBpartnerId_From(Long bpartnerId_From) {
        this.bpartnerId_From = bpartnerId_From;
    }

    public void setBpartnerId_To(Long bpartnerId_To) {
        this.bpartnerId_To = bpartnerId_To;
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

    public Date getEventDate_From() {
        return this.eventDate_From;
    }

    public Date getEventDate_To() {
        return this.eventDate_To;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDate_From(Date eventDate_From) {
        this.eventDate_From = eventDate_From;
    }

    public void setEventDate_To(Date eventDate_To) {
        this.eventDate_To = eventDate_To;
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

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getAccDocLineId() {
        return this.accDocLineId;
    }

    public Long getAccDocLineId_From() {
        return this.accDocLineId_From;
    }

    public Long getAccDocLineId_To() {
        return this.accDocLineId_To;
    }

    public void setAccDocLineId(Long accDocLineId) {
        this.accDocLineId = accDocLineId;
    }

    public void setAccDocLineId_From(Long accDocLineId_From) {
        this.accDocLineId_From = accDocLineId_From;
    }

    public void setAccDocLineId_To(Long accDocLineId_To) {
        this.accDocLineId_To = accDocLineId_To;
    }

}
