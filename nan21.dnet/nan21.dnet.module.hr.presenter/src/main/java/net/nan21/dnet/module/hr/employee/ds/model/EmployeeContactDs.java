/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EmployeeContact.class)
public class EmployeeContactDs extends AbstractDsModel<EmployeeContact>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fUUID = "uuid";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fENTITYFQN = "entityFQN";
    public static final String fEMPLOYEEID = "employeeId";
    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fBIRTHDATE = "birthdate";
    public static final String fGENDER = "gender";
    public static final String fRELATIONSHIPID = "relationshipId";
    public static final String fRELATIONSHIP = "relationship";
    public static final String fISDEPENDENT = "isDependent";

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

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField()
    private String firstName;

    @DsField()
    private String lastName;

    @DsField()
    private Date birthdate;

    @DsField()
    private String gender;

    @DsField(join = "left", path = "relationship.id")
    private Long relationshipId;

    @DsField(join = "left", path = "relationship.name")
    private String relationship;

    @DsField()
    private Boolean isDependent;

    public EmployeeContactDs() {
        super();
    }

    public EmployeeContactDs(EmployeeContact e) {
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

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getRelationshipId() {
        return this.relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Boolean getIsDependent() {
        return this.isDependent;
    }

    public void setIsDependent(Boolean isDependent) {
        this.isDependent = isDependent;
    }

}
