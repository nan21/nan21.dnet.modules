/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemTaxService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesOrderItemTaxService extends
        AbstractEntityService<SalesOrderItemTax> implements
        ISalesOrderItemTaxService {

    public SalesOrderItemTaxService() {
        super();
    }

    public SalesOrderItemTaxService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SalesOrderItemTax> getEntityClass() {
        return SalesOrderItemTax.class;
    }

    public List<SalesOrderItemTax> findBySalesOrderItem(
            SalesOrderItem salesOrderItem) {
        return this.findBySalesOrderItemId(salesOrderItem.getId());
    }

    public List<SalesOrderItemTax> findBySalesOrderItemId(Long salesOrderItemId) {
        return (List<SalesOrderItemTax>) this.em
                .createQuery(
                        "select e from SalesOrderItemTax e where e.clientId = :pClientId and e.salesOrderItem.id = :pSalesOrderItemId",
                        SalesOrderItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSalesOrderItemId", salesOrderItemId)
                .getResultList();
    }

    public List<SalesOrderItemTax> findByTax(Tax tax) {
        return this.findByTaxId(tax.getId());
    }

    public List<SalesOrderItemTax> findByTaxId(Long taxId) {
        return (List<SalesOrderItemTax>) this.em
                .createQuery(
                        "select e from SalesOrderItemTax e where e.clientId = :pClientId and e.tax.id = :pTaxId",
                        SalesOrderItemTax.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTaxId", taxId).getResultList();
    }

}
