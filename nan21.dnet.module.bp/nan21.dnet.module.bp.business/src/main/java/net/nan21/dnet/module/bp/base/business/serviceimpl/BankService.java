/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bp.base.business.service.IBankService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.base.domain.entity.Bank;

public class BankService extends AbstractEntityService<Bank> implements
        IBankService {

    public BankService() {
        super();
    }

    public BankService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Bank> getEntityClass() {
        return Bank.class;
    }

    public Bank findByCode(String code) {
        return (Bank) this.em.createNamedQuery(Bank.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Bank findByName(String name) {
        return (Bank) this.em.createNamedQuery(Bank.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
