/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bp.calendar.business.service.ICalendarEventPriorityService;
import net.nan21.dnet.module.bp.calendar.business.service.ICalendarEventStatusService;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarTaskDs;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEvent;

public class MyCalendarTaskDsConv extends
        AbstractDsConverter<MyCalendarTaskDs, CalendarEvent> implements
        IDsConverter<MyCalendarTaskDs, CalendarEvent> {

    protected void modelToEntityAttributes(MyCalendarTaskDs ds, CalendarEvent e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSubject(ds.getSubject());
        e.setStartDate(ds.getStartDate());
        e.setEndDate(ds.getEndDate());
        e.setDueDate(ds.getDueDate());
        e.setEventType(ds.getEventType());
        e.setNotes(ds.getNotes());
        e.setLocation(ds.getLocation());
        e.setUrl(ds.getUrl());
        e.setReminder(ds.getReminder());
        e.setAllDay(ds.getAllDay());
    }

    protected void modelToEntityReferences(MyCalendarTaskDs ds, CalendarEvent e)
            throws Exception {

        if (ds.getBpartnerId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getBpartnerId())) {
                e.setBpartner((BusinessPartner) this.em.getReference(
                        BusinessPartner.class, ds.getBpartnerId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }
        if (ds.getPriorityId() != null) {
            if (e.getPriority() == null
                    || !e.getPriority().getId().equals(ds.getPriorityId())) {
                e.setPriority((CalendarEventPriority) this.em.getReference(
                        CalendarEventPriority.class, ds.getPriorityId()));
            }
        } else {
            this.lookup_priority_CalendarEventPriority(ds, e);
        }
        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((CalendarEventStatus) this.em.getReference(
                        CalendarEventStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_CalendarEventStatus(ds, e);
        }
    }

    protected void lookup_bpartner_BusinessPartner(MyCalendarTaskDs ds,
            CalendarEvent e) throws Exception {
        if (ds.getBpartnerCode() != null) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) getService(IBusinessPartnerService.class))
                        .findByCode(ds.getClientId(), ds.getBpartnerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `bpartnerCode` = "
                                + ds.getBpartnerCode() + "  ");
            }
            e.setBpartner(x);
        }
    }

    protected void lookup_priority_CalendarEventPriority(MyCalendarTaskDs ds,
            CalendarEvent e) throws Exception {
        if (ds.getEventType() != null && ds.getPriorityName() != null) {
            CalendarEventPriority x = null;
            try {
                x = ((ICalendarEventPriorityService) getService(ICalendarEventPriorityService.class))
                        .findByType_and_name(ds.getClientId(),
                                ds.getEventType(), ds.getPriorityName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CalendarEventPriority` reference:  `eventType` = "
                                + ds.getEventType()
                                + " , `priorityName` = "
                                + ds.getPriorityName() + "  ");
            }
            e.setPriority(x);
        }
    }

    protected void lookup_status_CalendarEventStatus(MyCalendarTaskDs ds,
            CalendarEvent e) throws Exception {
        if (ds.getEventType() != null && ds.getStatusName() != null) {
            CalendarEventStatus x = null;
            try {
                x = ((ICalendarEventStatusService) getService(ICalendarEventStatusService.class))
                        .findByType_and_name(ds.getClientId(),
                                ds.getEventType(), ds.getStatusName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CalendarEventStatus` reference:  `eventType` = "
                                + ds.getEventType()
                                + " , `statusName` = "
                                + ds.getStatusName() + "  ");
            }
            e.setStatus(x);
        }
    }

    @Override
    public void entityToModel(CalendarEvent e, MyCalendarTaskDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSubject(e.getSubject());
        ds.setStartDate(e.getStartDate());
        ds.setEndDate(e.getEndDate());
        ds.setDueDate(e.getDueDate());
        ds.setEventType(e.getEventType());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setNotes(e.getNotes());
        ds.setLocation(e.getLocation());
        ds.setUrl(e.getUrl());
        ds.setReminder(e.getReminder());
        ds.setAllDay(e.getAllDay());
        ds.setStatusId(((e.getStatus() != null)) ? e.getStatus().getId() : null);
        ds.setStatusName(((e.getStatus() != null)) ? e.getStatus().getName()
                : null);
        ds.setPriorityId(((e.getPriority() != null)) ? e.getPriority().getId()
                : null);
        ds.setPriorityName(((e.getPriority() != null)) ? e.getPriority()
                .getName() : null);
        ds.setBpartnerId(((e.getBpartner() != null)) ? e.getBpartner().getId()
                : null);
        ds.setBpartnerCode(((e.getBpartner() != null)) ? e.getBpartner()
                .getCode() : null);
        ds.setContactId(((e.getContact() != null)) ? e.getContact().getId()
                : null);
        ds.setContactName(((e.getContact() != null)) ? e.getContact().getName()
                : null);
    }

}
