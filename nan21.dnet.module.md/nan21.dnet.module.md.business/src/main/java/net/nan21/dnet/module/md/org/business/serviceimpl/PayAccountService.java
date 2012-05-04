/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.org.business.service.IPayAccountService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

public class PayAccountService extends AbstractEntityService<PayAccount>
        implements IPayAccountService {

    public PayAccountService() {
        super();
    }

    public PayAccountService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayAccount> getEntityClass() {
        return PayAccount.class;
    }

    public PayAccount findByName(String name) {
        return (PayAccount) this.em
                .createNamedQuery(PayAccount.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<PayAccount> findByOrg(Organization org) {
        return this.findByOrgId(org.getId());
    }

    public List<PayAccount> findByOrgId(Long orgId) {
        return (List<PayAccount>) this.em
                .createQuery(
                        "select e from PayAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
                        PayAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOrgId", orgId).getResultList();
    }

    public List<PayAccount> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<PayAccount> findByCurrencyId(Long currencyId) {
        return (List<PayAccount>) this.em
                .createQuery(
                        "select e from PayAccount e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        PayAccount.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

}
