/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceType;

public class PurchaseInvoiceTypeService extends
        AbstractEntityService<PurchaseInvoiceType> implements
        IPurchaseInvoiceTypeService {

    public PurchaseInvoiceTypeService() {
        super();
    }

    public PurchaseInvoiceTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseInvoiceType> getEntityClass() {
        return PurchaseInvoiceType.class;
    }

    public PurchaseInvoiceType findByName(String name) {
        return (PurchaseInvoiceType) this.em
                .createNamedQuery(PurchaseInvoiceType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
