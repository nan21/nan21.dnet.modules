/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PayrollBalanceValueDsFilter extends AbstractAuditableDsFilter {

    private Long elementId;

    private Long elementId_From;
    private Long elementId_To;

    private String element;

    private String elementName;

    private Integer sequenceNo;

    private Integer sequenceNo_From;
    private Integer sequenceNo_To;

    private String dataType;

    private String balanceFunction;

    private Long sourceElementId;

    private Long sourceElementId_From;
    private Long sourceElementId_To;

    private String sourceElement;

    private String sourceElementName;

    private Long accItemId;

    private Long accItemId_From;
    private Long accItemId_To;

    private String accItem;

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Long employerId;

    private Long employerId_From;
    private Long employerId_To;

    private String employer;

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

    public String getBalanceFunction() {
        return this.balanceFunction;
    }

    public void setBalanceFunction(String balanceFunction) {
        this.balanceFunction = balanceFunction;
    }

    public Long getSourceElementId() {
        return this.sourceElementId;
    }

    public Long getSourceElementId_From() {
        return this.sourceElementId_From;
    }

    public Long getSourceElementId_To() {
        return this.sourceElementId_To;
    }

    public void setSourceElementId(Long sourceElementId) {
        this.sourceElementId = sourceElementId;
    }

    public void setSourceElementId_From(Long sourceElementId_From) {
        this.sourceElementId_From = sourceElementId_From;
    }

    public void setSourceElementId_To(Long sourceElementId_To) {
        this.sourceElementId_To = sourceElementId_To;
    }

    public String getSourceElement() {
        return this.sourceElement;
    }

    public void setSourceElement(String sourceElement) {
        this.sourceElement = sourceElement;
    }

    public String getSourceElementName() {
        return this.sourceElementName;
    }

    public void setSourceElementName(String sourceElementName) {
        this.sourceElementName = sourceElementName;
    }

    public Long getAccItemId() {
        return this.accItemId;
    }

    public Long getAccItemId_From() {
        return this.accItemId_From;
    }

    public Long getAccItemId_To() {
        return this.accItemId_To;
    }

    public void setAccItemId(Long accItemId) {
        this.accItemId = accItemId;
    }

    public void setAccItemId_From(Long accItemId_From) {
        this.accItemId_From = accItemId_From;
    }

    public void setAccItemId_To(Long accItemId_To) {
        this.accItemId_To = accItemId_To;
    }

    public String getAccItem() {
        return this.accItem;
    }

    public void setAccItem(String accItem) {
        this.accItem = accItem;
    }

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getEmployerId() {
        return this.employerId;
    }

    public Long getEmployerId_From() {
        return this.employerId_From;
    }

    public Long getEmployerId_To() {
        return this.employerId_To;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public void setEmployerId_From(Long employerId_From) {
        this.employerId_From = employerId_From;
    }

    public void setEmployerId_To(Long employerId_To) {
        this.employerId_To = employerId_To;
    }

    public String getEmployer() {
        return this.employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
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
