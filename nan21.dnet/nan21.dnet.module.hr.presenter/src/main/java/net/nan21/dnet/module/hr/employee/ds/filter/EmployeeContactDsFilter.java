/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class EmployeeContactDsFilter extends AbstractDsFilter implements
        IModelWithId, IModelWithClientId {

    private Long id;

    private String uuid;

    private Long clientId;

    private Date createdAt;

    private Date createdAt_From;
    private Date createdAt_To;

    private Date modifiedAt;

    private Date modifiedAt_From;
    private Date modifiedAt_To;

    private String createdBy;

    private String modifiedBy;

    private String entityFQN;

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

    public Date getCreatedAt_From() {
        return this.createdAt_From;
    }

    public Date getCreatedAt_To() {
        return this.createdAt_To;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt_From(Date createdAt_From) {
        this.createdAt_From = createdAt_From;
    }

    public void setCreatedAt_To(Date createdAt_To) {
        this.createdAt_To = createdAt_To;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public Date getModifiedAt_From() {
        return this.modifiedAt_From;
    }

    public Date getModifiedAt_To() {
        return this.modifiedAt_To;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setModifiedAt_From(Date modifiedAt_From) {
        this.modifiedAt_From = modifiedAt_From;
    }

    public void setModifiedAt_To(Date modifiedAt_To) {
        this.modifiedAt_To = modifiedAt_To;
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

    public String getEntityFQN() {
        return this.entityFQN;
    }

    public void setEntityFQN(String entityFQN) {
        this.entityFQN = entityFQN;
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
