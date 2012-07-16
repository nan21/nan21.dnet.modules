/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

@Ds(entity = EmployeeWorkExperience.class)
public class EmployeeWorkExperienceDs extends
        AbstractAuditableDs<EmployeeWorkExperience> {

    public static final String fEMPLOYEEID = "employeeId";
    public static final String fFROMDATE = "fromDate";
    public static final String fTODATE = "toDate";
    public static final String fINSTITUTE = "institute";
    public static final String fNOTES = "notes";

    @DsField(join = "left", path = "employee.id")
    private Long employeeId;

    @DsField()
    private Date fromDate;

    @DsField()
    private Date toDate;

    @DsField()
    private String institute;

    @DsField()
    private String notes;

    public EmployeeWorkExperienceDs() {
        super();
    }

    public EmployeeWorkExperienceDs(EmployeeWorkExperience e) {
        super(e);
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getInstitute() {
        return this.institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
