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

@Ds(entity = PayrollElementValue.class, jpqlWhere = " e.element.calculation = 'manual' ", sort = { @SortField(field = PayrollManualValueDs.fSEQUENCENO) })
public class PayrollManualValueDs extends
        AbstractAuditableDs<PayrollElementValue> {

    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fELEMENTNAME = "elementName";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fDATATYPE = "dataType";
    public static final String fTYPEID = "typeId";
    public static final String fTYPE = "type";
    public static final String fEMPLOYEEID = "employeeId";
    public static final String fEMPLOYEENAME = "employeeName";
    public static final String fEMPLOYERID = "employerId";
    public static final String fEMPLOYER = "employer";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";
    public static final String fPERIODSTART = "periodStart";
    public static final String fPERIODEND = "periodEnd";
    public static final String fVALUE = "value";

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "element.id")
    private Long elementId;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "element.code")
    private String element;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "element.name")
    private String elementName;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "element.sequenceNo")
    private Integer sequenceNo;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "element.dataType")
    private String dataType;

    @DsField(join = "left", path = "element.type.id")
    private Long typeId;

    @DsField(join = "left", path = "element.type.name")
    private String type;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(noInsert = true, noUpdate = true, join = "left", orderBy = "lastName,firstName", fetch = false, path = "employee.name")
    private String employeeName;

    @DsField(join = "left", path = "org.id")
    private Long employerId;

    @DsField(join = "left", path = "org.code")
    private String employer;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "period.id")
    private Long periodId;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "period.name")
    private String period;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "period.startDate")
    private Date periodStart;

    @DsField(noInsert = true, noUpdate = true, join = "left", path = "period.endDate")
    private Date periodEnd;

    @DsField()
    private String value;

    public PayrollManualValueDs() {
        super();
    }

    public PayrollManualValueDs(PayrollElementValue e) {
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

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getEmployerId() {
        return this.employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public String getEmployer() {
        return this.employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
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

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
