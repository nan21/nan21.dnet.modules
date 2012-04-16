/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.OneToMany;
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
import net.nan21.dnet.module.hr.time.domain.eventhandler.AbsenceRequestEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Absence request filled by employee. After it is approved generates absence time-entries acoording its items */
@Entity
@Table(name = AbsenceRequest.TABLE_NAME)
@Customizer(AbsenceRequestEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AbsenceRequest.NQ_FIND_BY_ID, query = "SELECT e FROM AbsenceRequest e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AbsenceRequest.NQ_FIND_BY_IDS, query = "SELECT e FROM AbsenceRequest e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AbsenceRequest extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_ABSN_REQUEST";
    public static final String SEQUENCE_NAME = "HR_ABSN_REQUEST_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AbsenceRequest.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AbsenceRequest.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** StartDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", nullable = false)
    @NotNull
    private Date startDate;

    /** EndDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE", nullable = false)
    @NotNull
    private Date endDate;

    /** Status. */
    @Column(name = "STATUS", nullable = false, length = 16)
    @NotBlank
    private String status;

    /** HoursPerDay. */
    @Column(name = "HOURSPERDAY", nullable = false)
    @NotNull
    private Integer hoursPerDay;

    /** Comment. */
    @Column(name = "COMMENTS", length = 400)
    private String comment;

    /** TotalHours. */
    @Column(name = "TOTALHOURS")
    private Integer totalHours;

    /** CurrentOwner. */
    @Column(name = "CURRENTOWNER", length = 32)
    private String currentOwner;

    /** PreviousOwner. */
    @Column(name = "PREVIOUSOWNER", length = 32)
    private String previousOwner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AbsenceType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private AbsenceType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AbsenceReason.class)
    @JoinColumn(name = "REASON_ID", referencedColumnName = "ID")
    private AbsenceReason reason;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = AbsenceRequestItem.class, mappedBy = "absenceRequest")
    private Collection<AbsenceRequestItem> items;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHoursPerDay() {
        return this.hoursPerDay;
    }

    public void setHoursPerDay(Integer hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getTotalHours() {
        return this.totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public String getCurrentOwner() {
        return this.currentOwner;
    }

    public void setCurrentOwner(String currentOwner) {
        this.currentOwner = currentOwner;
    }

    public String getPreviousOwner() {
        return this.previousOwner;
    }

    public void setPreviousOwner(String previousOwner) {
        this.previousOwner = previousOwner;
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

    public Collection<AbsenceRequestItem> getItems() {
        return this.items;
    }

    public void setItems(Collection<AbsenceRequestItem> items) {
        this.items = items;
    }

    public void addToItems(AbsenceRequestItem e) {
        if (this.items == null) {
            this.items = new ArrayList<AbsenceRequestItem>();
        }
        e.setAbsenceRequest(this);
        this.items.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
