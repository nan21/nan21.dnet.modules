/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.calendar.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bp.calendar.business.service.ICalendarEventStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventStatus;

public class CalendarEventStatusService extends
        AbstractEntityService<CalendarEventStatus> implements
        ICalendarEventStatusService {

    public CalendarEventStatusService() {
        super();
    }

    public CalendarEventStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CalendarEventStatus> getEntityClass() {
        return CalendarEventStatus.class;
    }

    public CalendarEventStatus findByType_and_name(String eventType, String name) {
        return (CalendarEventStatus) this.em
                .createNamedQuery(CalendarEventStatus.NQ_FIND_BY_TYPE_AND_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEventType", eventType)
                .setParameter("pName", name).getSingleResult();
    }

}
