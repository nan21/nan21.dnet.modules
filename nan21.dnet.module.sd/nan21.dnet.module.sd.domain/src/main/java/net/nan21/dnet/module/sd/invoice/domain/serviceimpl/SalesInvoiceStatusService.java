/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.domain.service.ISalesInvoiceStatusService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;

public class SalesInvoiceStatusService extends
        AbstractEntityService<SalesInvoiceStatus> implements
        ISalesInvoiceStatusService {

    public SalesInvoiceStatusService() {
        super();
    }

    public SalesInvoiceStatusService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceStatus> getEntityClass() {
        return SalesInvoiceStatus.class;
    }

    public SalesInvoiceStatus findByName(Long clientId, String name) {
        return (SalesInvoiceStatus) this.em
                .createNamedQuery(SalesInvoiceStatus.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
