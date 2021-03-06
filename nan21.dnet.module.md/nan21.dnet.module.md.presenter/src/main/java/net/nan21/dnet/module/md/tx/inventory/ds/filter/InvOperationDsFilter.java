/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class InvOperationDsFilter extends AbstractAuditableDsFilter {

    private Long itemId;

    private Long itemId_From;
    private Long itemId_To;

    private String itemCode;

    private String item;

    private Date eventDate;

    private Date eventDate_From;
    private Date eventDate_To;

    private Long inventoryId;

    private Long inventoryId_From;
    private Long inventoryId_To;

    private String inventory;

    private String inventoryName;

    private Long subInventoryId;

    private Long subInventoryId_From;
    private Long subInventoryId_To;

    private String subInventory;

    private Long locatorId;

    private Long locatorId_From;
    private Long locatorId_To;

    private String locator;

    private Long transactionId;

    private Long transactionId_From;
    private Long transactionId_To;

    private Long transactionLineId;

    private Long transactionLineId_From;
    private Long transactionLineId_To;

    private String direction;

    private Float quantity;

    private Float quantity_From;
    private Float quantity_To;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uom;

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

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public Long getInventoryId_From() {
        return this.inventoryId_From;
    }

    public Long getInventoryId_To() {
        return this.inventoryId_To;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setInventoryId_From(Long inventoryId_From) {
        this.inventoryId_From = inventoryId_From;
    }

    public void setInventoryId_To(Long inventoryId_To) {
        this.inventoryId_To = inventoryId_To;
    }

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getInventoryName() {
        return this.inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public Long getSubInventoryId() {
        return this.subInventoryId;
    }

    public Long getSubInventoryId_From() {
        return this.subInventoryId_From;
    }

    public Long getSubInventoryId_To() {
        return this.subInventoryId_To;
    }

    public void setSubInventoryId(Long subInventoryId) {
        this.subInventoryId = subInventoryId;
    }

    public void setSubInventoryId_From(Long subInventoryId_From) {
        this.subInventoryId_From = subInventoryId_From;
    }

    public void setSubInventoryId_To(Long subInventoryId_To) {
        this.subInventoryId_To = subInventoryId_To;
    }

    public String getSubInventory() {
        return this.subInventory;
    }

    public void setSubInventory(String subInventory) {
        this.subInventory = subInventory;
    }

    public Long getLocatorId() {
        return this.locatorId;
    }

    public Long getLocatorId_From() {
        return this.locatorId_From;
    }

    public Long getLocatorId_To() {
        return this.locatorId_To;
    }

    public void setLocatorId(Long locatorId) {
        this.locatorId = locatorId;
    }

    public void setLocatorId_From(Long locatorId_From) {
        this.locatorId_From = locatorId_From;
    }

    public void setLocatorId_To(Long locatorId_To) {
        this.locatorId_To = locatorId_To;
    }

    public String getLocator() {
        return this.locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public Long getTransactionId_From() {
        return this.transactionId_From;
    }

    public Long getTransactionId_To() {
        return this.transactionId_To;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionId_From(Long transactionId_From) {
        this.transactionId_From = transactionId_From;
    }

    public void setTransactionId_To(Long transactionId_To) {
        this.transactionId_To = transactionId_To;
    }

    public Long getTransactionLineId() {
        return this.transactionLineId;
    }

    public Long getTransactionLineId_From() {
        return this.transactionLineId_From;
    }

    public Long getTransactionLineId_To() {
        return this.transactionLineId_To;
    }

    public void setTransactionLineId(Long transactionLineId) {
        this.transactionLineId = transactionLineId;
    }

    public void setTransactionLineId_From(Long transactionLineId_From) {
        this.transactionLineId_From = transactionLineId_From;
    }

    public void setTransactionLineId_To(Long transactionLineId_To) {
        this.transactionLineId_To = transactionLineId_To;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

}
