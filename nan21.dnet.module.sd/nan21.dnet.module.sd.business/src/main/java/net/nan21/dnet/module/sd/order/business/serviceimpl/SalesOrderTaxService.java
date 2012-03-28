/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderTaxService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

public class SalesOrderTaxService extends AbstractEntityService<SalesOrderTax>
        implements ISalesOrderTaxService {

    public SalesOrderTaxService() {
        super();
    }

    public SalesOrderTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderTax> getEntityClass() {
        return SalesOrderTax.class;
    }

    public List<SalesOrderTax> findBySalesOrder(SalesOrder salesOrder) {
        return this.findBySalesOrderId(salesOrder.getId());
    }

    public List<SalesOrderTax> findBySalesOrderId(Long salesOrderId) {
        return (List<SalesOrderTax>) this.em
                .createQuery(
                        "select e from SalesOrderTax e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
                        SalesOrderTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesOrderId", salesOrderId).getResultList();
    }

    public List<SalesOrderTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesOrderTax> findByTaxId(Long taxId) {
        return (List<SalesOrderTax>) this.em
                .createQuery(
                        "select e from SalesOrderTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesOrderTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}
