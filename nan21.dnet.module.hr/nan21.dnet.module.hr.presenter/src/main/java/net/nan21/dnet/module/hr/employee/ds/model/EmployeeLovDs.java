/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;

import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Employee.class)
public class EmployeeLovDs extends AbstractAuditableLov<Employee> {

    public static final String fFIRSTNAME = "firstName";
    public static final String fLASTNAME = "lastName";
    public static final String fNAME = "name";
    public static final String fCODE = "code";

    @DsField()
    private String firstName;

    @DsField()
    private String lastName;

    @DsField(orderBy = "lastName,firstName", fetch = false, jpqlFilter = " e.lastName like :name ")
    private String name;

    @DsField()
    private String code;

    public EmployeeLovDs() {
        super();
    }

    public EmployeeLovDs(Employee e) {
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
