/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class AttributeDsFilter extends AbstractTypeDsFilter {

    private String title;

    private Long categoryId;

    private Long categoryId_From;
    private Long categoryId_To;

    private String category;

    private String dataType;

    private String listOfvalues;

    private Long uomId;

    private Long uomId_From;
    private Long uomId_To;

    private String uom;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public Long getCategoryId_From() {
        return this.categoryId_From;
    }

    public Long getCategoryId_To() {
        return this.categoryId_To;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }

    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getListOfvalues() {
        return this.listOfvalues;
    }

    public void setListOfvalues(String listOfvalues) {
        this.listOfvalues = listOfvalues;
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
