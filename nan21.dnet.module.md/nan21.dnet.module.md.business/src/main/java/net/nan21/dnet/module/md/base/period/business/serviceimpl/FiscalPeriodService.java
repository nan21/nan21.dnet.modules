/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalPeriodService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import java.util.Date;
import javax.persistence.NoResultException;

public class FiscalPeriodService extends AbstractEntityService<FiscalPeriod>
        implements IFiscalPeriodService {

    public FiscalPeriodService() {
        super();
    }

    public FiscalPeriodService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<FiscalPeriod> getEntityClass() {
        return FiscalPeriod.class;
    }

    public FiscalPeriod findByCode(String code) {
        return (FiscalPeriod) this.em
                .createNamedQuery(FiscalPeriod.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public FiscalPeriod findByName(String name) {
        return (FiscalPeriod) this.em
                .createNamedQuery(FiscalPeriod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<FiscalPeriod> findByYear(FiscalYear year) {
        return this.findByYearId(year.getId());
    }

    public List<FiscalPeriod> findByYearId(Long yearId) {
        return (List<FiscalPeriod>) this.em
                .createQuery(
                        "select e from FiscalPeriod e where e.clientId = :pClientId and e.year.id = :pYearId",
                        FiscalPeriod.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pYearId", yearId).getResultList();
    }

    public FiscalPeriod getPostingPeriod(Date date, Organization org) {

        try {
            FiscalPeriod period = (FiscalPeriod) this.em
                    .createQuery(
                            "select e from FiscalPeriod e "
                                    + "	where e.clientId = :pClientId "
                                    + "	  and :pDate between e.startDate and e.endDate "
                                    + "	and e.active = true ",
                            FiscalPeriod.class)
                    .setParameter("pClientId", Session.user.get().getClientId())
                    .setParameter("pDate", date).getSingleResult();
            return period;
        } catch (NoResultException e) {
            throw new RuntimeException("No open posting period found for `"
                    + date.toString() + "`");
        }

    }

}
