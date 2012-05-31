/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccBalanceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccBalance;

public class AccBalanceService extends AbstractEntityService<AccBalance>
        implements IAccBalanceService {

    public AccBalanceService() {
        super();
    }

    public AccBalanceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccBalance> getEntityClass() {
        return AccBalance.class;
    }

    public List<AccBalance> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<AccBalance> findByOrgId(Long orgId) {
        return (List<AccBalance>) this.em
                .createQuery(
                        "select e from AccBalance e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        AccBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<AccBalance> findByAccSchema(AccSchema accSchema) {
        return this.findByAccSchemaId(accSchema.getId());
    }

    public List<AccBalance> findByAccSchemaId(Long accSchemaId) {
        return (List<AccBalance>) this.em
                .createQuery(
                        "select e from AccBalance e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
                        AccBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccSchemaId", accSchemaId).getResultList();
    }

    public List<AccBalance> findByPeriod(FiscalPeriod period) {
        return this.findByPeriodId(period.getId());
    }

    public List<AccBalance> findByPeriodId(Long periodId) {
        return (List<AccBalance>) this.em
                .createQuery(
                        "select e from AccBalance e where e.clientId = :pClientId and e.period.id = :pPeriodId",
                        AccBalance.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPeriodId", periodId).getResultList();
    }

}
