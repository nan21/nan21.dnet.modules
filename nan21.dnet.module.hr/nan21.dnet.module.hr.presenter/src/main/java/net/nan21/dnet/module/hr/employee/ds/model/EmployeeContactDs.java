/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EmployeeContact.class)
public class EmployeeContactDs extends AbstractAuditableDs<EmployeeContact> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fBIRTHDATE = "birthdate";
    public static final String fGENDER = "gender";
    public static final String fRELATIONSHIPID = "relationshipId";
    public static final String fRELATIONSHIP = "relationship";
    public static final String fISDEPENDENT = "isDependent";

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
