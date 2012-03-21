/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceStatus;

public class PurchaseInvoiceStatusService extends
        AbstractEntityService<PurchaseInvoiceStatus> implements
        IPurchaseInvoiceStatusService {

    public PurchaseInvoiceStatusService() {
        super();
    }

    public PurchaseInvoiceStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoiceStatus> getEntityClass() {
        return PurchaseInvoiceStatus.class;
    }

    public PurchaseInvoiceStatus findByName(String name) {
        return (PurchaseInvoiceStatus) this.em
                .createNamedQuery(PurchaseInvoiceStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
