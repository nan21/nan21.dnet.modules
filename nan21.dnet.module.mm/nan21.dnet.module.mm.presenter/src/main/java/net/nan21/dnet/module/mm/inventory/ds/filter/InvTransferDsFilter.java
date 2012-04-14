/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class InvTransferDsFilter extends AbstractAuditableDsFilter {

    private Long docTypeId;

    private Long docTypeId_From;
    private Long docTypeId_To;

    private String docType;

    private Long transactionTypeId;

    private Long transactionTypeId_From;
    private Long transactionTypeId_To;

    private String transactionType;

    private Boolean hasFromInventory;

    private Boolean hasToInventory;

    private Long fromInventoryId;

    private Long fromInventoryId_From;
    private Long fromInventoryId_To;

    private String fromInventory;

    private Long toInventoryId;

    private Long toInventoryId_From;
    private Long toInventoryId_To;

    private String toInventory;

    private Boolean confirmed;

    private Boolean posted;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

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

    public Long getTransactionTypeId() {
        return this.transactionTypeId;
    }

    public Long getTransactionTypeId_From() {
        return this.transactionTypeId_From;
    }

    public Long getTransactionTypeId_To() {
        return this.transactionTypeId_To;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public void setTransactionTypeId_From(Long transactionTypeId_From) {
        this.transactionTypeId_From = transactionTypeId_From;
    }

    public void setTransactionTypeId_To(Long transactionTypeId_To) {
        this.transactionTypeId_To = transactionTypeId_To;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Boolean getHasFromInventory() {
        return this.hasFromInventory;
    }

    public void setHasFromInventory(Boolean hasFromInventory) {
        this.hasFromInventory = hasFromInventory;
    }

    public Boolean getHasToInventory() {
        return this.hasToInventory;
    }

    public void setHasToInventory(Boolean hasToInventory) {
        this.hasToInventory = hasToInventory;
    }

    public Long getFromInventoryId() {
        return this.fromInventoryId;
    }

    public Long getFromInventoryId_From() {
        return this.fromInventoryId_From;
    }

    public Long getFromInventoryId_To() {
        return this.fromInventoryId_To;
    }

    public void setFromInventoryId(Long fromInventoryId) {
        this.fromInventoryId = fromInventoryId;
    }

    public void setFromInventoryId_From(Long fromInventoryId_From) {
        this.fromInventoryId_From = fromInventoryId_From;
    }

    public void setFromInventoryId_To(Long fromInventoryId_To) {
        this.fromInventoryId_To = fromInventoryId_To;
    }

    public String getFromInventory() {
        return this.fromInventory;
    }

    public void setFromInventory(String fromInventory) {
        this.fromInventory = fromInventory;
    }

    public Long getToInventoryId() {
        return this.toInventoryId;
    }

    public Long getToInventoryId_From() {
        return this.toInventoryId_From;
    }

    public Long getToInventoryId_To() {
        return this.toInventoryId_To;
    }

    public void setToInventoryId(Long toInventoryId) {
        this.toInventoryId = toInventoryId;
    }

    public void setToInventoryId_From(Long toInventoryId_From) {
        this.toInventoryId_From = toInventoryId_From;
    }

    public void setToInventoryId_To(Long toInventoryId_To) {
        this.toInventoryId_To = toInventoryId_To;
    }

    public String getToInventory() {
        return this.toInventory;
    }

    public void setToInventory(String toInventory) {
        this.toInventory = toInventory;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
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

}
