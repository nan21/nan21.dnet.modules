/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** EmployeeContact. */
@Entity
@Table(name = EmployeeContact.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = EmployeeContact.NQ_FIND_BY_ID, query = "SELECT e FROM EmployeeContact e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = EmployeeContact.NQ_FIND_BY_IDS, query = "SELECT e FROM EmployeeContact e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class EmployeeContact extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_EMPL_CONTACT";
    public static final String SEQUENCE_NAME = "HR_EMPL_CONTACT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "EmployeeContact.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "EmployeeContact.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FirstName. */
    @Column(name = "FIRSTNAME", nullable = false, length = 255)
    @NotBlank
    private String firstName;

    /** LastName. */
    @Column(name = "LASTNAME", nullable = false, length = 255)
    @NotBlank
    private String lastName;

    /** MiddleName. */
    @Column(name = "MIDDLENAME", length = 32)
    private String middleName;

    /** Birthdate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDATE")
    private Date birthdate;

    /** Gender. */
    @Column(name = "GENDER", length = 16)
    private String gender;

    /** IsDependent. */
    @Column(name = "ISDEPENDENT", nullable = false)
    @NotNull
    private Boolean isDependent;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeContactType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private EmployeeContactType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EmployeeContactRelationship.class)
    @JoinColumn(name = "RELATIONSHIP_ID", referencedColumnName = "ID")
    private EmployeeContactRelationship relationship;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public Boolean getIsDependent() {
        return this.isDependent;
    }

    public void setIsDependent(Boolean isDependent) {
        this.isDependent = isDependent;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeContactType getType() {
        return this.type;
    }

    public void setType(EmployeeContactType type) {
        this.type = type;
    }

    public EmployeeContactRelationship getRelationship() {
        return this.relationship;
    }

    public void setRelationship(EmployeeContactRelationship relationship) {
        this.relationship = relationship;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getIsDependent() == null) {
            event.updateAttributeWithObject("isDependent", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
