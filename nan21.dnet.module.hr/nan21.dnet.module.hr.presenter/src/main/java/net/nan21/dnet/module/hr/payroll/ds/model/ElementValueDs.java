/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ElementValue.class)
public class ElementValueDs extends AbstractDsModel<ElementValue> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fELEMENTID = "elementId";
    public static final String fELEMENT = "element";
    public static final String fEMPLOYEEID = "employeeId";
    public static final String fEMPLOYEENAME = "employeeName";
    public static final String fVALUE = "value";
    public static final String fPERIODID = "periodId";
    public static final String fPERIOD = "period";

    @DsField()
    private Long id;

    @DsField()
    private String uuid;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField(fetch = false, path = "className")
    private String entityFQN;

    @DsField(join = "left", path = "element.id")
    private Long elementId;

    @DsField(join = "left", path = "element.name")
    private String element;

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField(join = "left", path = "employee.name")
    private String employeeName;

    @DsField()
    private String value;

    @DsField(join = "left", path = "period.id")
    private Long periodId;

    @DsField(join = "left", path = "period.name")
    private String period;

    public ElementValueDs() {
        super();
    }

    public ElementValueDs(ElementValue e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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

}
