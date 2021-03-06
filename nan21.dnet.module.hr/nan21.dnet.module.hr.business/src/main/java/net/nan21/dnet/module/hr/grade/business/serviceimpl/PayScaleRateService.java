/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleRateService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

public class PayScaleRateService extends AbstractEntityService<PayScaleRate>
        implements IPayScaleRateService {

    public PayScaleRateService() {
        super();
    }

    public PayScaleRateService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayScaleRate> getEntityClass() {
        return PayScaleRate.class;
    }

    public PayScaleRate findByName(String name) {
        return (PayScaleRate) this.em
                .createNamedQuery(PayScaleRate.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<PayScaleRate> findByPayScale(PayScale payScale) {
        return this.findByPayScaleId(payScale.getId());
    }

    public List<PayScaleRate> findByPayScaleId(Long payScaleId) {
        return (List<PayScaleRate>) this.em
                .createQuery(
                        "select e from PayScaleRate e where e.clientId = :pClientId and e.payScale.id = :pPayScaleId",
                        PayScaleRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayScaleId", payScaleId).getResultList();
    }

    public List<PayScaleRate> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<PayScaleRate> findByCurrencyId(Long currencyId) {
        return (List<PayScaleRate>) this.em
                .createQuery(
                        "select e from PayScaleRate e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        PayScaleRate.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
