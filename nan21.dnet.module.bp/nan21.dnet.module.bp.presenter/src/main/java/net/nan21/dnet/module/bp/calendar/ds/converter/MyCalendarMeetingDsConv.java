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
import net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDs;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEvent;

public class MyCalendarMeetingDsConv extends
        AbstractDsConverter<MyCalendarMeetingDs, CalendarEvent> implements
        IDsConverter<MyCalendarMeetingDs, CalendarEvent> {

    @Override
    protected void modelToEntityReferences(MyCalendarMeetingDs ds,
            CalendarEvent e, boolean isInsert) throws Exception {

        if (ds.getBpartnerId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId().equals(ds.getBpartnerId())) {
                e.setBpartner((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getBpartnerId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }

        if (ds.getPriorityId() != null) {
            if (e.getPriority() == null
                    || !e.getPriority().getId().equals(ds.getPriorityId())) {
                e.setPriority((CalendarEventPriority) this.em.find(
                        CalendarEventPriority.class, ds.getPriorityId()));
            }
        } else {
            this.lookup_priority_CalendarEventPriority(ds, e);
        }

        if (ds.getStatusId() != null) {
            if (e.getStatus() == null
                    || !e.getStatus().getId().equals(ds.getStatusId())) {
                e.setStatus((CalendarEventStatus) this.em.find(
                        CalendarEventStatus.class, ds.getStatusId()));
            }
        } else {
            this.lookup_status_CalendarEventStatus(ds, e);
        }

    }

    protected void lookup_bpartner_BusinessPartner(MyCalendarMeetingDs ds,
            CalendarEvent e) throws Exception {
        if (ds.getBpartnerCode() != null && !ds.getBpartnerCode().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getBpartnerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `bpartnerCode` = "
                                + ds.getBpartnerCode() + "  ");
            }
            e.setBpartner(x);

        } else {
            e.setBpartner(null);
        }
    }

    protected void lookup_priority_CalendarEventPriority(
            MyCalendarMeetingDs ds, CalendarEvent e) throws Exception {
        if (ds.getEventType() != null && !ds.getEventType().equals("")
                && ds.getPriorityName() != null
                && !ds.getPriorityName().equals("")) {
            CalendarEventPriority x = null;
            try {
                x = ((ICalendarEventPriorityService) findEntityService(CalendarEventPriority.class))
                        .findByType_and_name(ds.getEventType(),
                                ds.getPriorityName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CalendarEventPriority` reference:  `eventType` = "
                                + ds.getEventType()
                                + " , `priorityName` = "
                                + ds.getPriorityName() + "  ");
            }
            e.setPriority(x);

        } else {
            e.setPriority(null);
        }
    }

    protected void lookup_status_CalendarEventStatus(MyCalendarMeetingDs ds,
            CalendarEvent e) throws Exception {
        if (ds.getEventType() != null && !ds.getEventType().equals("")
                && ds.getStatusName() != null && !ds.getStatusName().equals("")) {
            CalendarEventStatus x = null;
            try {
                x = ((ICalendarEventStatusService) findEntityService(CalendarEventStatus.class))
                        .findByType_and_name(ds.getEventType(),
                                ds.getStatusName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CalendarEventStatus` reference:  `eventType` = "
                                + ds.getEventType()
                                + " , `statusName` = "
                                + ds.getStatusName() + "  ");
            }
            e.setStatus(x);

        } else {
            e.setStatus(null);
        }
    }

}
