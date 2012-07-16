/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalYearService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;
import net.nan21.dnet.module.md._businessdelegates.base.period.PeriodBD;

public class FiscalYearService extends AbstractEntityService<FiscalYear>
        implements IFiscalYearService {

    public FiscalYearService() {
        super();
    }

    public FiscalYearService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<FiscalYear> getEntityClass() {
        return FiscalYear.class;
    }

    public FiscalYear findByCode(String code) {
        return (FiscalYear) this.em
                .createNamedQuery(FiscalYear.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public FiscalYear findByName(String name) {
        return (FiscalYear) this.em
                .createNamedQuery(FiscalYear.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<FiscalYear> findByCalendar(Calendar calendar) {
        return this.findByCalendarId(calendar.getId());
    }

    public List<FiscalYear> findByCalendarId(Long calendarId) {
        return (List<FiscalYear>) this.em
                .createQuery(
                        "select e from FiscalYear e where e.clientId = :pClientId and e.calendar.id = :pCalendarId",
                        FiscalYear.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCalendarId", calendarId).getResultList();
    }

    public void doCreateMonths(FiscalYear year) throws Exception {
        this.getBusinessDelegate(PeriodBD.class).createMonths(year);
    }

    public void doCreateQuarters(FiscalYear year) throws Exception {
        this.getBusinessDelegate(PeriodBD.class).createQuarters(year);
    }

    public void doCreateHalfYears(FiscalYear year) throws Exception {
        this.getBusinessDelegate(PeriodBD.class).createHalfYears(year);
    }

}
