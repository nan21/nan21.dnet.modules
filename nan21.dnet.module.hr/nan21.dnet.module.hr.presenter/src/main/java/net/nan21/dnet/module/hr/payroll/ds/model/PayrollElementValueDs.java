/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = PayrollElementValue.class, sort = {
        @SortField(field = PayrollElementValueDs.fPERIODSTART, desc = true),
        @SortField(field = PayrollElementValueDs.fSEQUENCENO),
        @SortField(field = PayrollElementValueDs.fEMPLOYEEID) })
public class PayrollElementValueDs extends
        AbstractAuditableDs<PayrollElementValue> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDATATYPE = "dataType";
    public static final String fEMPLOYEEID = "employeeId";
    public static final String fEMPLOYEENAME = "employeeName";
    public static final String fVALUE = "value";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";
    public static final String fPERIODSTART = "periodStart";
    public static final String fPERIODEND = "periodEnd";

    @DsField(join = "left", path = "element.id")
    private Long elementId;

    @DsField(join = "left", path = "element.code")
    private String element;

    @DsField(join = "left", path = "element.name")
    private String elementName;

    @DsField(join = "left", path = "element.sequenceNo")
    private Integer sequenceNo;

    @DsField(join = "left", path = "element.dataType")
    private String dataType;

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", orderBy = "lastName,firstName", fetch = false, path = "employee.name")
    private String employeeName;

    @DsField()
    private String value;

    @DsField(join = "left", path = "period.id")
    private Long periodId;

    @DsField(join = "left", path = "period.name")
    private String period;

    @DsField(join = "left", path = "period.startDate")
    private Date periodStart;

    @DsField(join = "left", path = "period.endDate")
    private Date periodEnd;

    public PayrollElementValueDs() {
        super();
    }

    public PayrollElementValueDs(PayrollElementValue e) {
        super(e);
    }

    public Long getElementId() {
        return this.elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
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

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
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

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
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

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return this.periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

}
