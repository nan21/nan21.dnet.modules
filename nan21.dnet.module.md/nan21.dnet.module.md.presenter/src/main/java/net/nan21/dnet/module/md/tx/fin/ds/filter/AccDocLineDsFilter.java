/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AccDocLineDsFilter extends AbstractAuditableDsFilter {

    private Long accDocId;

    private Long accDocId_From;
    private Long accDocId_To;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dbAccount;

    private String crAccount;

    private Float dbAmount;

    private Float dbAmount_From;
    private Float dbAmount_To;

    private Float crAmount;

    private Float crAmount_From;
    private Float crAmount_To;

    public Long getAccDocId() {
        return this.accDocId;
    }

    public Long getAccDocId_From() {
        return this.accDocId_From;
    }

    public Long getAccDocId_To() {
        return this.accDocId_To;
    }

    public void setAccDocId(Long accDocId) {
        this.accDocId = accDocId;
    }

    public void setAccDocId_From(Long accDocId_From) {
        this.accDocId_From = accDocId_From;
    }

    public void setAccDocId_To(Long accDocId_To) {
        this.accDocId_To = accDocId_To;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public Integer getSequenceNo_From() {
        return this.sequenceNo_From;
    }

    public Integer getSequenceNo_To() {
        return this.sequenceNo_To;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public void setSequenceNo_From(Integer sequenceNo_From) {
        this.sequenceNo_From = sequenceNo_From;
    }

    public void setSequenceNo_To(Integer sequenceNo_To) {
        this.sequenceNo_To = sequenceNo_To;
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

}
