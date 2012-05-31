/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
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

    private Date birthDate;

    private Date birthDate_From;
    private Date birthDate_To;

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

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Date getBirthDate_From() {
        return this.birthDate_From;
    }

    public Date getBirthDate_To() {
        return this.birthDate_To;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate_From(Date birthDate_From) {
        this.birthDate_From = birthDate_From;
    }

    public void setBirthDate_To(Date birthDate_To) {
        this.birthDate_To = birthDate_To;
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
