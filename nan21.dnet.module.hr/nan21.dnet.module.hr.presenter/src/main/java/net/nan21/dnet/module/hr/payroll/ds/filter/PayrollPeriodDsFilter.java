/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class PayrollPeriodDsFilter extends AbstractTypeDsFilter {

    private Long payrollId;

    private Long payrollId_From;
    private Long payrollId_To;

    private String payrollName;

    private Date startDate;

    private Date startDate_From;
    private Date startDate_To;

    private Date endDate;

    private Date endDate_From;
    private Date endDate_To;

    private Boolean processed;

    private Boolean closed;

    public Long getPayrollId() {
        return this.payrollId;
    }

    public Long getPayrollId_From() {
        return this.payrollId_From;
    }

    public Long getPayrollId_To() {
        return this.payrollId_To;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }

    public void setPayrollId_From(Long payrollId_From) {
        this.payrollId_From = payrollId_From;
    }

    public void setPayrollId_To(Long payrollId_To) {
        this.payrollId_To = payrollId_To;
    }

    public String getPayrollName() {
        return this.payrollName;
    }

    public void setPayrollName(String payrollName) {
        this.payrollName = payrollName;
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

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

}
