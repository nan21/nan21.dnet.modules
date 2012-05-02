/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.activity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventPriorityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventStatusService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.activity.ds.model.MyCalendarEventDs;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;

public class MyCalendarEventDsConv extends
        AbstractDsConverter<MyCalendarEventDs, CalendarEvent> implements
        IDsConverter<MyCalendarEventDs, CalendarEvent> {

    @Override
    protected void modelToEntityReferences(MyCalendarEventDs ds,
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

    protected void lookup_bpartner_BusinessPartner(MyCalendarEventDs ds,
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

    protected void lookup_priority_CalendarEventPriority(MyCalendarEventDs ds,
            CalendarEvent e) throws Exception {
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

    protected void lookup_status_CalendarEventStatus(MyCalendarEventDs ds,
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
