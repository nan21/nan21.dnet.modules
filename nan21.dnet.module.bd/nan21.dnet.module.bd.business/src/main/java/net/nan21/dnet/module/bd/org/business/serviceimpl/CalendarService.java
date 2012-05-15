/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.ICalendarService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;

public class CalendarService extends AbstractEntityService<Calendar> implements
        ICalendarService {

    public CalendarService() {
        super();
    }

    public CalendarService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Calendar> getEntityClass() {
        return Calendar.class;
    }

    public Calendar findByName(String name) {
        return (Calendar) this.em.createNamedQuery(Calendar.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
