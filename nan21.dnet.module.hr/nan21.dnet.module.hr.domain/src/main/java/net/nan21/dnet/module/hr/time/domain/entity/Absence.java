/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;
import net.nan21.dnet.module.hr.time.domain.eventhandler.AbsenceEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** The approved absence request generate entries here which represent the valid posted data, available to payroll, reports, etc.
 * Should not create entries manually here. 
 */
@Entity
@Table(name = Absence.TABLE_NAME)
@Customizer(AbsenceEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Absence.NQ_FIND_BY_ID, query = "SELECT e FROM Absence e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Absence.NQ_FIND_BY_IDS, query = "SELECT e FROM Absence e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Absence extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_ABSENCE";
    public static final String SEQUENCE_NAME = "HR_ABSENCE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Absence.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Absence.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EventDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "EVENTDATE", nullable = false)
    @NotNull
    private Date eventDate;

    /** Hours. */
    @Column(name = "HOURS", nullable = false)
    @NotNull
    private Integer hours;

    /** Notes. */
    @Column(name = "NOTES", length = 400)
    private String notes;

    /** Posted. */
    @Column(name = "POSTED", nullable = false)
    @NotNull
    private Boolean posted;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AbsenceType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private AbsenceType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AbsenceReason.class)
    @JoinColumn(name = "REASON_ID", referencedColumnName = "ID")
    private AbsenceReason reason;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AbsenceType getType() {
        return this.type;
    }

    public void setType(AbsenceType type) {
        this.type = type;
    }

    public AbsenceReason getReason() {
        return this.reason;
    }

    public void setReason(AbsenceReason reason) {
        this.reason = reason;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getPosted() == null) {
            event.updateAttributeWithObject("posted", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
