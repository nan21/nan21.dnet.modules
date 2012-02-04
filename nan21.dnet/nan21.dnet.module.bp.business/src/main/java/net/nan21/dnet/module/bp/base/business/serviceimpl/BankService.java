/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.serviceimpl;

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

    public Bank findByCode(Long clientId, String code) {
        return (Bank) this.em.createNamedQuery(Bank.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Bank findByName(Long clientId, String name) {
        return (Bank) this.em.createNamedQuery(Bank.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
