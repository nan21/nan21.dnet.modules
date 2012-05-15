/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;

public interface ICalendarEventService extends IEntityService<CalendarEvent> {

    public List<CalendarEvent> findByStatus(CalendarEventStatus status);

    public List<CalendarEvent> findByStatusId(Long statusId);

    public List<CalendarEvent> findByPriority(CalendarEventPriority priority);

    public List<CalendarEvent> findByPriorityId(Long priorityId);

    public List<CalendarEvent> findByBpartner(BusinessPartner bpartner);

    public List<CalendarEvent> findByBpartnerId(Long bpartnerId);

    public List<CalendarEvent> findByContact(Contact contact);

    public List<CalendarEvent> findByContactId(Long contactId);

}
