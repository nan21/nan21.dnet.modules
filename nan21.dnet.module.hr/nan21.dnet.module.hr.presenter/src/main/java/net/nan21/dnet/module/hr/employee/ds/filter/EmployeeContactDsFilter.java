/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class EmployeeContactDsFilter extends AbstractAuditableDsFilter {

    private Long employeeId;

    private Long employeeId_From;
    private Long employeeId_To;

    private String firstName;

    private String lastName;

    private Date birthdate;

    private Date birthdate_From;
    private Date birthdate_To;

    private String gender;

    private Long relationshipId;

    private Long relationshipId_From;
    private Long relationshipId_To;

    private String relationship;

    private Boolean isDependent;

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

    public Date getBirthdate_From() {
        return this.birthdate_From;
    }

    public Date getBirthdate_To() {
        return this.birthdate_To;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthdate_From(Date birthdate_From) {
        this.birthdate_From = birthdate_From;
    }

    public void setBirthdate_To(Date birthdate_To) {
        this.birthdate_To = birthdate_To;
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

    public Long getRelationshipId_From() {
        return this.relationshipId_From;
    }

    public Long getRelationshipId_To() {
        return this.relationshipId_To;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public void setRelationshipId_From(Long relationshipId_From) {
        this.relationshipId_From = relationshipId_From;
    }

    public void setRelationshipId_To(Long relationshipId_To) {
        this.relationshipId_To = relationshipId_To;
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
