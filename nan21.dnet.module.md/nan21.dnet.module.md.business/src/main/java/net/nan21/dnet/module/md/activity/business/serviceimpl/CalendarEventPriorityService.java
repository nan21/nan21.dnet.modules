/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.activity.business.service.ICalendarEventPriorityService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;

public class CalendarEventPriorityService extends
        AbstractEntityService<CalendarEventPriority> implements
        ICalendarEventPriorityService {

    public CalendarEventPriorityService() {
        super();
    }

    public CalendarEventPriorityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CalendarEventPriority> getEntityClass() {
        return CalendarEventPriority.class;
    }

    public CalendarEventPriority findByType_and_name(String eventType,
            String name) {
        return (CalendarEventPriority) this.em
                .createNamedQuery(
                        CalendarEventPriority.NQ_FIND_BY_TYPE_AND_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEventType", eventType)
                .setParameter("pName", name).getSingleResult();
    }

}
