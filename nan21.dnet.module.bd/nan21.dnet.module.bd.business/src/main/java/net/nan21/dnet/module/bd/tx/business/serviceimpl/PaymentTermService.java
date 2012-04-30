/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.tx.business.service.IPaymentTermService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentTerm;

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

    public PaymentTerm findByName(String name) {
        return (PaymentTerm) this.em
                .createNamedQuery(PaymentTerm.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
