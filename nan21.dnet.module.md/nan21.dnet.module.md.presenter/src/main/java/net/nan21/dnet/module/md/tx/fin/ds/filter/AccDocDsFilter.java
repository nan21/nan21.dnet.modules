/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
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

    private Long periodId;

    private Long periodId_From;
    private Long periodId_To;

    private String period;

    private Long journalId;

    private Long journalId_From;
    private Long journalId_To;

    private String journal;

    private Long bpartnerId;

    private Long bpartnerId_From;
    private Long bpartnerId_To;

    private String bpartner;

    private String docNo;

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Date docDate;

    private Date docDate_From;
    private Date docDate_To;

    private Float docNetAmount;

    private Float docNetAmount_From;
    private Float docNetAmount_To;

    private Float docTaxAmount;

    private Float docTaxAmount_From;
    private Float docTaxAmount_To;

    private Float docAmount;

    private Float docAmount_From;
    private Float docAmount_To;

    private Long docCurrencyId;

    private Long docCurrencyId_From;
    private Long docCurrencyId_To;

    private String docCurrency;

    private Float dbAmount;

    private Float dbAmount_From;
    private Float dbAmount_To;

    private Float crAmount;

    private Float crAmount_From;
    private Float crAmount_To;

    private Float difference;

    private Float difference_From;
    private Float difference_To;

    private Boolean posted;

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

    public Long getJournalId() {
        return this.journalId;
    }

    public Long getJournalId_From() {
        return this.journalId_From;
    }

    public Long getJournalId_To() {
        return this.journalId_To;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public void setJournalId_From(Long journalId_From) {
        this.journalId_From = journalId_From;
    }

    public void setJournalId_To(Long journalId_To) {
        this.journalId_To = journalId_To;
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

    public Float getDocNetAmount() {
        return this.docNetAmount;
    }

    public Float getDocNetAmount_From() {
        return this.docNetAmount_From;
    }

    public Float getDocNetAmount_To() {
        return this.docNetAmount_To;
    }

    public void setDocNetAmount(Float docNetAmount) {
        this.docNetAmount = docNetAmount;
    }

    public void setDocNetAmount_From(Float docNetAmount_From) {
        this.docNetAmount_From = docNetAmount_From;
    }

    public void setDocNetAmount_To(Float docNetAmount_To) {
        this.docNetAmount_To = docNetAmount_To;
    }

    public Float getDocTaxAmount() {
        return this.docTaxAmount;
    }

    public Float getDocTaxAmount_From() {
        return this.docTaxAmount_From;
    }

    public Float getDocTaxAmount_To() {
        return this.docTaxAmount_To;
    }

    public void setDocTaxAmount(Float docTaxAmount) {
        this.docTaxAmount = docTaxAmount;
    }

    public void setDocTaxAmount_From(Float docTaxAmount_From) {
        this.docTaxAmount_From = docTaxAmount_From;
    }

    public void setDocTaxAmount_To(Float docTaxAmount_To) {
        this.docTaxAmount_To = docTaxAmount_To;
    }

    public Float getDocAmount() {
        return this.docAmount;
    }

    public Float getDocAmount_From() {
        return this.docAmount_From;
    }

    public Float getDocAmount_To() {
        return this.docAmount_To;
    }

    public void setDocAmount(Float docAmount) {
        this.docAmount = docAmount;
    }

    public void setDocAmount_From(Float docAmount_From) {
        this.docAmount_From = docAmount_From;
    }

    public void setDocAmount_To(Float docAmount_To) {
        this.docAmount_To = docAmount_To;
    }

    public Long getDocCurrencyId() {
        return this.docCurrencyId;
    }

    public Long getDocCurrencyId_From() {
        return this.docCurrencyId_From;
    }

    public Long getDocCurrencyId_To() {
        return this.docCurrencyId_To;
    }

    public void setDocCurrencyId(Long docCurrencyId) {
        this.docCurrencyId = docCurrencyId;
    }

    public void setDocCurrencyId_From(Long docCurrencyId_From) {
        this.docCurrencyId_From = docCurrencyId_From;
    }

    public void setDocCurrencyId_To(Long docCurrencyId_To) {
        this.docCurrencyId_To = docCurrencyId_To;
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

    public Float getDifference() {
        return this.difference;
    }

    public Float getDifference_From() {
        return this.difference_From;
    }

    public Float getDifference_To() {
        return this.difference_To;
    }

    public void setDifference(Float difference) {
        this.difference = difference;
    }

    public void setDifference_From(Float difference_From) {
        this.difference_From = difference_From;
    }

    public void setDifference_To(Float difference_To) {
        this.difference_To = difference_To;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

}
