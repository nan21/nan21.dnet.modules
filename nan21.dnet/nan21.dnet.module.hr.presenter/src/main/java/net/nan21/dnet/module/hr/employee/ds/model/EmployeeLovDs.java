/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Employee.class)
public class EmployeeLovDs extends AbstractDsModel<Employee> implements
        IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fNAME = "name";
    public static final String fCODE = "code";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private String firstName;

    @DsField()
    private String lastName;

    @DsField(jpqlFilter = " e.lastName like :name ")
    private String name;

    @DsField()
    private String code;

    public EmployeeLovDs() {
        super();
    }

    public EmployeeLovDs(Employee e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
