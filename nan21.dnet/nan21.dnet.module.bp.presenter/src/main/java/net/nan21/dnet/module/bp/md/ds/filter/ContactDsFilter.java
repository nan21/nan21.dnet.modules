/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ContactDsFilter extends AbstractDsFilter implements IModelWithId,
        IModelWithClientId {

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

    private String firstName;

    private String lastName;

    private String name;

    private Boolean active;

    private String gender;

    private Date birthdate;

    private Date birthdate_From;
    private Date birthdate_To;

    private String position;

    private Long bpartnerId;

    private Long bpartnerId_From;
    private Long bpartnerId_To;

    private String bpartnerCode;

    private String className;

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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getBpartnerId() {
        return this.bpartnerId;
    }

    public Long getBpartnerId_From() {
        return this.bpartnerId_From;
    }

    public Long getBpartnerId_To() {
        return this.bpartnerId_To;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

    public void setBpartnerId_From(Long bpartnerId_From) {
        this.bpartnerId_From = bpartnerId_From;
    }

    public void setBpartnerId_To(Long bpartnerId_To) {
        this.bpartnerId_To = bpartnerId_To;
    }

    public String getBpartnerCode() {
        return this.bpartnerCode;
    }

    public void setBpartnerCode(String bpartnerCode) {
        this.bpartnerCode = bpartnerCode;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
