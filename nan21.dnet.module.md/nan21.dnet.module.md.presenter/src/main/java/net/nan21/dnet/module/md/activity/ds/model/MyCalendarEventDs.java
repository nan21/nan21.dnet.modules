/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;

@Ds(entity = CalendarEvent.class)
public class MyCalendarEventDs extends AbstractAuditableDs<CalendarEvent> {

    public static final String fSUBJECT = "subject";
    public static final String fSTARTDATE = "startDate";
    public static final String fENDDATE = "endDate";
    public static final String fDUEDATE = "dueDate";
    public static final String fEVENTTYPE = "eventType";
    public static final String fSTATUSID = "statusId";
    public static final String fSTATUSNAME = "statusName";
    public static final String fPRIORITYID = "priorityId";
    public static final String fPRIORITYNAME = "priorityName";
    public static final String fBPARTNERID = "bpartnerId";
    public static final String fBPARTNERCODE = "bpartnerCode";
    public static final String fCONTACTID = "contactId";
    public static final String fCONTACT = "contact";
    public static final String fCREATEDBY = "createdBy";
    public static final String fNOTES = "notes";
    public static final String fLOCATION = "location";
    public static final String fURL = "url";
    public static final String fREMINDER = "reminder";
    public static final String fALLDAY = "allDay";
    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fTARGETID = "targetId";
    public static final String fTARGETTYPE = "targetType";

    @DsField()
    private String subject;

    @DsField(jpqlFilter = " e.endDate >= :startDate ")
    private Date startDate;

    @DsField(jpqlFilter = " e.startDate <= :endDate ")
    private Date endDate;

    @DsField()
    private Date dueDate;

    @DsField()
    private String eventType;

    @DsField(join = "left", path = "status.id")
    private Long statusId;

    @DsField(join = "left", path = "status.name")
    private String statusName;

    @DsField(join = "left", path = "priority.id")
    private Long priorityId;

    @DsField(join = "left", path = "priority.name")
    private String priorityName;

    @DsField(join = "left", path = "bpartner.id")
    private Long bpartnerId;

    @DsField(join = "left", path = "bpartner.code")
    private String bpartnerCode;

    @DsField(join = "left", path = "contact.id")
    private Long contactId;

    @DsField(join = "left", fetch = false, path = "contact.name")
    private String contact;

    @DsField()
    private String createdBy;

    @DsField()
    private String notes;

    @DsField()
    private String location;

    @DsField()
    private String url;

    @DsField()
    private String reminder;

    @DsField()
    private Boolean allDay;

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Long targetId;

    @DsField()
    private String targetType;

    public MyCalendarEventDs() {
        super();
    }

    public MyCalendarEventDs(CalendarEvent e) {
        super(e);
    }

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

    public Long getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return this.priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
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

    public Long getContactId() {
        return this.contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

}
