/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.business.service.IGradeRateService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

public class GradeRateService extends AbstractEntityService<GradeRate>
        implements IGradeRateService {

    public GradeRateService() {
        super();
    }

    public GradeRateService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GradeRate> getEntityClass() {
        return GradeRate.class;
    }

    public GradeRate findByName(String name) {
        return (GradeRate) this.em.createNamedQuery(GradeRate.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<GradeRate> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<GradeRate> findByCurrencyId(Long currencyId) {
        return (List<GradeRate>) this.em
                .createQuery(
                        "select e from GradeRate e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        GradeRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
