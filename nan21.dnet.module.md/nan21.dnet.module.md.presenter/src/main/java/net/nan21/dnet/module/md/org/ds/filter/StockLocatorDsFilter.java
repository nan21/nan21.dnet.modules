/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class StockLocatorDsFilter extends AbstractTypeDsFilter {

    private Long subInventoryId;

    private Long subInventoryId_From;
    private Long subInventoryId_To;

    private String subInventory;

    private Long locatorTypeId;

    private Long locatorTypeId_From;
    private Long locatorTypeId_To;

    private String locatorType;

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

    public Long getLocatorTypeId() {
        return this.locatorTypeId;
    }

    public Long getLocatorTypeId_From() {
        return this.locatorTypeId_From;
    }

    public Long getLocatorTypeId_To() {
        return this.locatorTypeId_To;
    }

    public void setLocatorTypeId(Long locatorTypeId) {
        this.locatorTypeId = locatorTypeId;
    }

    public void setLocatorTypeId_From(Long locatorTypeId_From) {
        this.locatorTypeId_From = locatorTypeId_From;
    }

    public void setLocatorTypeId_To(Long locatorTypeId_To) {
        this.locatorTypeId_To = locatorTypeId_To;
    }

    public String getLocatorType() {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType) {
        this.locatorType = locatorType;
    }

}
