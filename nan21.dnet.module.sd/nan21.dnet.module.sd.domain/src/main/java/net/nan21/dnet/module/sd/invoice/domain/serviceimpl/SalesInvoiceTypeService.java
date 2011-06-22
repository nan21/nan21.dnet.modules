/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.domain.service.ISalesInvoiceTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;

public class SalesInvoiceTypeService extends
        AbstractEntityService<SalesInvoiceType> implements
        ISalesInvoiceTypeService {

    public SalesInvoiceTypeService() {
        super();
    }

    public SalesInvoiceTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesInvoiceType> getEntityClass() {
        return SalesInvoiceType.class;
    }

    public SalesInvoiceType findByName(Long clientId, String name) {
        return (SalesInvoiceType) this.em
                .createNamedQuery(SalesInvoiceType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}