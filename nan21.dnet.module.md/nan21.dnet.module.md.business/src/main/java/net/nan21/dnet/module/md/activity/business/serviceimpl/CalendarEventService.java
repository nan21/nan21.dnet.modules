/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventService;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEvent;

public class CalendarEventService extends AbstractEntityService<CalendarEvent>
        implements ICalendarEventService {

    public CalendarEventService() {
        super();
    }

    public CalendarEventService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CalendarEvent> getEntityClass() {
        return CalendarEvent.class;
    }

    public List<CalendarEvent> findByStatus(CalendarEventStatus status) {
        return this.findByStatusId(status.getId());
    }

    public List<CalendarEvent> findByStatusId(Long statusId) {
        return (List<CalendarEvent>) this.em
                .createQuery(
                        "select e from CalendarEvent e where e.clientId = :pClientId and e.status.id = :pStatusId",
                        CalendarEvent.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pStatusId", statusId).getResultList();
    }

    public List<CalendarEvent> findByPriority(CalendarEventPriority priority) {
        return this.findByPriorityId(priority.getId());
    }

    public List<CalendarEvent> findByPriorityId(Long priorityId) {
        return (List<CalendarEvent>) this.em
                .createQuery(
                        "select e from CalendarEvent e where e.clientId = :pClientId and e.priority.id = :pPriorityId",
                        CalendarEvent.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriorityId", priorityId).getResultList();
    }

    public List<CalendarEvent> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<CalendarEvent> findByBpartnerId(Long bpartnerId) {
        return (List<CalendarEvent>) this.em
                .createQuery(
                        "select e from CalendarEvent e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        CalendarEvent.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

    public List<CalendarEvent> findByContact(Contact contact) {
        return this.findByContactId(contact.getId());
    }

    public List<CalendarEvent> findByContactId(Long contactId) {
        return (List<CalendarEvent>) this.em
                .createQuery(
                        "select e from CalendarEvent e where e.clientId = :pClientId and e.contact.id = :pContactId",
                        CalendarEvent.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pContactId", contactId).getResultList();
    }

}
