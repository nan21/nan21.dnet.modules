/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class SalesInvoiceItemDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

    private Long invoiceId;

    private Long invoiceId_From;
    private Long invoiceId_To;

    private Long itemId;

    private Long itemId_From;
    private Long itemId_To;

    private String itemCode;

    private String itemName;

    private Float quantity;

    private Float quantity_From;
    private Float quantity_To;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uomCode;

    private Float unitPrice;

    private Float unitPrice_From;
    private Float unitPrice_To;

    private Float netAmount;

    private Float netAmount_From;
    private Float netAmount_To;

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
    }

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public Long getInvoiceId_From() {
        return this.invoiceId_From;
    }

    public Long getInvoiceId_To() {
        return this.invoiceId_To;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceId_From(Long invoiceId_From) {
        this.invoiceId_From = invoiceId_From;
    }

    public void setInvoiceId_To(Long invoiceId_To) {
        this.invoiceId_To = invoiceId_To;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public Long getItemId_From() {
        return this.itemId_From;
    }

    public Long getItemId_To() {
        return this.itemId_To;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemId_From(Long itemId_From) {
        this.itemId_From = itemId_From;
    }

    public void setItemId_To(Long itemId_To) {
        this.itemId_To = itemId_To;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public Float getQuantity_From() {
        return this.quantity_From;
    }

    public Float getQuantity_To() {
        return this.quantity_To;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setQuantity_From(Float quantity_From) {
        this.quantity_From = quantity_From;
    }

    public void setQuantity_To(Float quantity_To) {
        this.quantity_To = quantity_To;
    }

    public Long getUomId() {
        return this.uomId;
    }

    public Long getUomId_From() {
        return this.uomId_From;
    }

    public Long getUomId_To() {
        return this.uomId_To;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public void setUomId_From(Long uomId_From) {
        this.uomId_From = uomId_From;
    }

    public void setUomId_To(Long uomId_To) {
        this.uomId_To = uomId_To;
    }

    public String getUomCode() {
        return this.uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public Float getUnitPrice_From() {
        return this.unitPrice_From;
    }

    public Float getUnitPrice_To() {
        return this.unitPrice_To;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitPrice_From(Float unitPrice_From) {
        this.unitPrice_From = unitPrice_From;
    }

    public void setUnitPrice_To(Float unitPrice_To) {
        this.unitPrice_To = unitPrice_To;
    }

    public Float getNetAmount() {
        return this.netAmount;
    }

    public Float getNetAmount_From() {
        return this.netAmount_From;
    }

    public Float getNetAmount_To() {
        return this.netAmount_To;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public void setNetAmount_From(Float netAmount_From) {
        this.netAmount_From = netAmount_From;
    }

    public void setNetAmount_To(Float netAmount_To) {
        this.netAmount_To = netAmount_To;
    }

}
