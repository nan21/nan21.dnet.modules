/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class ElementValueDsFilter extends AbstractAuditableDsFilter {

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private String elementName;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dataType;

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private String employeeName;

    private String value;

    private Long periodId;

    private Long periodId_From;
    private Long periodId_To;

    private String period;

    private Date periodStart;

    private Date periodStart_From;
    private Date periodStart_To;

    private Date periodEnd;

    private Date periodEnd_From;
    private Date periodEnd_To;

    public Long getElementId() {
        return this.elementId;
    }

    public Long getElementId_From() {
        return this.elementId_From;
    }

    public Long getElementId_To() {
        return this.elementId_To;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public void setElementId_From(Long elementId_From) {
        this.elementId_From = elementId_From;
    }

    public void setElementId_To(Long elementId_To) {
        this.elementId_To = elementId_To;
    }

    public String getElement() {
        return this.element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public Long getEmployeeId_From() {
        return this.employeeId_From;
    }

    public Long getEmployeeId_To() {
        return this.employeeId_To;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeId_From(Long employeeId_From) {
        this.employeeId_From = employeeId_From;
    }

    public void setEmployeeId_To(Long employeeId_To) {
        this.employeeId_To = employeeId_To;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Date getPeriodStart() {
        return this.periodStart;
    }

    public Date getPeriodStart_From() {
        return this.periodStart_From;
    }

    public Date getPeriodStart_To() {
        return this.periodStart_To;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public void setPeriodStart_From(Date periodStart_From) {
        this.periodStart_From = periodStart_From;
    }

    public void setPeriodStart_To(Date periodStart_To) {
        this.periodStart_To = periodStart_To;
    }

    public Date getPeriodEnd() {
        return this.periodEnd;
    }

    public Date getPeriodEnd_From() {
        return this.periodEnd_From;
    }

    public Date getPeriodEnd_To() {
        return this.periodEnd_To;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public void setPeriodEnd_From(Date periodEnd_From) {
        this.periodEnd_From = periodEnd_From;
    }

    public void setPeriodEnd_To(Date periodEnd_To) {
        this.periodEnd_To = periodEnd_To;
    }

}
