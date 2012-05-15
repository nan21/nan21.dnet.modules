/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Contact.class)
public class ContactDs extends AbstractAuditableDs<Contact> {

    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fGENDER = "gender";
    public static final String fBIRTHDATE = "birthdate";
    public static final String fPOSITION = "position";
    public static final String fBPARTNERID = "bpartnerId";
    public static final String fBPARTNERCODE = "bpartnerCode";
    public static final String fCLASSNAME = "className";

    @DsField()
    private String firstName;

    @DsField()
    private String lastName;

    @DsField(fetch = false)
    private String name;

    @DsField()
    private Boolean active;

    @DsField()
    private String gender;

    @DsField(path = "birthDate")
    private Date birthdate;

    @DsField()
    private String position;

    @DsField(join = "left", path = "bpartner.id")
    private Long bpartnerId;

    @DsField(join = "left", path = "bpartner.code")
    private String bpartnerCode;

    @DsField(fetch = false)
    private String className;

    public ContactDs() {
        super();
    }

    public ContactDs(Contact e) {
        super(e);
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
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
