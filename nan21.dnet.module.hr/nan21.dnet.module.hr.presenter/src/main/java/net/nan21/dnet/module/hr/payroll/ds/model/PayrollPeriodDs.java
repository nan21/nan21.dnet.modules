/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

@Ds(entity = PayrollPeriod.class, sort = { @SortField(field = PayrollPeriodDs.fNAME) })
public class PayrollPeriodDs extends AbstractTypeDs<PayrollPeriod> {

    public static final String fPAYROLLID = "payrollId";
    public static final String fPAYROLLNAME = "payrollName";
    public static final String fSTARTDATE = "startDate";
    public static final String fENDDATE = "endDate";
    public static final String fPROCESSED = "processed";
    public static final String fCLOSED = "closed";

    @DsField(join = "left", path = "payroll.id")
    private Long payrollId;

    @DsField(join = "left", path = "payroll.name")
    private String payrollName;

    @DsField()
    private Date startDate;

    @DsField()
    private Date endDate;

    @DsField()
    private Boolean processed;

    @DsField()
    private Boolean closed;

    public PayrollPeriodDs() {
        super();
    }

    public PayrollPeriodDs(PayrollPeriod e) {
        super(e);
    }

    public Long getPayrollId() {
        return this.payrollId;
    }

    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
