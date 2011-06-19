/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bp.base.domain.service.IPaymentTermService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;

public class PaymentTermService extends AbstractEntityService<PaymentTerm>
        implements IPaymentTermService {

    public PaymentTermService() {
        super();
    }

    public PaymentTermService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentTerm> getEntityClass() {
        return PaymentTerm.class;
    }

    public PaymentTerm findByName(Long clientId, String name) {
        return (PaymentTerm) this.em
                .createNamedQuery(PaymentTerm.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
