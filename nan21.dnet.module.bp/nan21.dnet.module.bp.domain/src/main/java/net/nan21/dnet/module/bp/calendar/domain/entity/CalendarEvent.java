/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.domain.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** CalendarEvent. */
@Entity
@Table(name = CalendarEvent.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "CalendarEvent.findById", query = "SELECT e FROM CalendarEvent e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "CalendarEvent.findByIds", query = "SELECT e FROM CalendarEvent e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CalendarEvent implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "BP_CLNDR_EVENT";
    public static final String SEQUENCE_NAME = "BP_CLNDR_EVENT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CalendarEvent.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CalendarEvent.findByIds";

    /** Subject. */
    @Column(name = "SUBJECT", nullable = false, length = 255)
    @NotBlank
    private String subject;

    /** StartDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE")
    private Date startDate;

    /** EndDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ENDDATE")
    private Date endDate;

    /** DueDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DUEDATE")
    private Date dueDate;

    /** EventType. */
    @Column(name = "EVENTTYPE", length = 16)
    private String eventType;

    /** Notes. */
    @Column(name = "NOTES", length = 4000)
    private String notes;

    /** Location. */
    @Column(name = "LOCATION", length = 4000)
    private String location;

    /** Url. */
    @Column(name = "URL", length = 400)
    private String url;

    /** Reminder. */
    @Column(name = "REMINDER", length = 32)
    private String reminder;

    /** AllDay. */
    @Column(name = "ALLDAY", nullable = false)
    @NotNull
    private Boolean allDay;

    /** TargetId. */
    @Column(name = "TARGETID")
    private Long targetId;

    /** TargetType. */
    @Column(name = "TARGETTYPE", length = 255)
    private String targetType;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CalendarEventStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private CalendarEventStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CalendarEventPriority.class)
    @JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
    private CalendarEventPriority priority;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    private Contact contact;

    /* ============== getters - setters ================== */

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReminder() {
        return this.reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public Boolean getAllDay() {
        return this.allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Long getTargetId() {
        return this.targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    @Transient
    public String getBusinessObject() {
        return "CalendarEvent.";
    }

    public void setBusinessObject(String businessObject) {

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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public CalendarEventStatus getStatus() {
        return this.status;
    }

    public void setStatus(CalendarEventStatus status) {
        this.status = status;
    }

    public CalendarEventPriority getPriority() {
        return this.priority;
    }

    public void setPriority(CalendarEventPriority priority) {
        this.priority = priority;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void aboutToInsert(DescriptorEvent event) {
        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.allDay == null) {
            event.updateAttributeWithObject("allDay", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        CalendarEvent e = (CalendarEvent) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
