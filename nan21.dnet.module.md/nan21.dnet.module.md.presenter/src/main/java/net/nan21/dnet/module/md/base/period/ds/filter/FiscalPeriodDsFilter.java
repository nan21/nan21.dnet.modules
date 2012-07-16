/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class FiscalPeriodDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long yearId;

    private Long yearId_From;
    private Long yearId_To;

    private String year;

    private String type;

    private Date startDate;

    private Date startDate_From;
    private Date startDate_To;

    private Date endDate;

    private Date endDate_From;
    private Date endDate_To;

    private Boolean posting;

    public Long getYearId() {
        return this.yearId;
    }

    public Long getYearId_From() {
        return this.yearId_From;
    }

    public Long getYearId_To() {
        return this.yearId_To;
    }

    public void setYearId(Long yearId) {
        this.yearId = yearId;
    }

    public void setYearId_From(Long yearId_From) {
        this.yearId_From = yearId_From;
    }

    public void setYearId_To(Long yearId_To) {
        this.yearId_To = yearId_To;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getStartDate_From() {
        return this.startDate_From;
    }

    public Date getStartDate_To() {
        return this.startDate_To;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartDate_From(Date startDate_From) {
        this.startDate_From = startDate_From;
    }

    public void setStartDate_To(Date startDate_To) {
        this.startDate_To = startDate_To;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getEndDate_From() {
        return this.endDate_From;
    }

    public Date getEndDate_To() {
        return this.endDate_To;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate_From(Date endDate_From) {
        this.endDate_From = endDate_From;
    }

    public void setEndDate_To(Date endDate_To) {
        this.endDate_To = endDate_To;
    }

    public Boolean getPosting() {
        return this.posting;
    }

    public void setPosting(Boolean posting) {
        this.posting = posting;
    }

}
