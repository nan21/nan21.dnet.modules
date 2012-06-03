/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Employee. */
@Entity
@CascadeOnDelete
@Table(name = Employee.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Employee.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CODE" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Employee.NQ_FIND_BY_ID, query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Employee.NQ_FIND_BY_IDS, query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Employee.NQ_FIND_BY_CODE, query = "SELECT e FROM Employee e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Employee extends EmployeeBase {

    public static final String TABLE_NAME = "HR_EMPL";
    public static final String SEQUENCE_NAME = "HR_EMPL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Employee.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Employee.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Employee.findByCode";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** AssignToPosition. */
    @Column(name = "ASSIGNTOPOSITION", nullable = false)
    @NotNull
    private Boolean assignToPosition;

    /** BaseSalary. */
    @Column(name = "BASESALARY", scale = 2)
    private Float baseSalary;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EmploymentType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private EmploymentType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
    @JoinColumn(name = "JOB_ID", referencedColumnName = "ID")
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
    @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
    private Grade grade;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Payroll.class)
    @JoinColumn(name = "PAYROLL_ID", referencedColumnName = "ID")
    private Payroll payroll;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = EmployeeContact.class, mappedBy = "employee", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<EmployeeContact> contacts;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAssignToPosition() {
        return this.assignToPosition;
    }

    public void setAssignToPosition(Boolean assignToPosition) {
        this.assignToPosition = assignToPosition;
    }

    public Float getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(Float baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Transient
    public String getBusinessObject() {
        return "Employee";
    }

    public void setBusinessObject(String businessObject) {

    }

    public EmploymentType getType() {
        return this.type;
    }

    public void setType(EmploymentType type) {
        if (type != null) {
            this.__validate_client_context__(type.getClientId());
        }
        this.type = type;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        if (position != null) {
            this.__validate_client_context__(position.getClientId());
        }
        this.position = position;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        if (job != null) {
            this.__validate_client_context__(job.getClientId());
        }
        this.job = job;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        if (org != null) {
            this.__validate_client_context__(org.getClientId());
        }
        this.org = org;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setGrade(Grade grade) {
        if (grade != null) {
            this.__validate_client_context__(grade.getClientId());
        }
        this.grade = grade;
    }

    public Payroll getPayroll() {
        return this.payroll;
    }

    public void setPayroll(Payroll payroll) {
        if (payroll != null) {
            this.__validate_client_context__(payroll.getClientId());
        }
        this.payroll = payroll;
    }

    public Collection<EmployeeContact> getContacts() {
        return this.contacts;
    }

    public void setContacts(Collection<EmployeeContact> contacts) {
        this.contacts = contacts;
    }

    public void addToContacts(EmployeeContact e) {
        if (this.contacts == null) {
            this.contacts = new ArrayList<EmployeeContact>();
        }
        e.setEmployee(this);
        this.contacts.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getAssignToPosition() == null) {
            event.updateAttributeWithObject("assignToPosition", false);
        }
    }

}
