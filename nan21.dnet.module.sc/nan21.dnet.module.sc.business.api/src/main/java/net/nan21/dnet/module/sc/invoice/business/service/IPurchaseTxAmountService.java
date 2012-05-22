/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

public interface IPurchaseTxAmountService extends
        IEntityService<PurchaseTxAmount> {

    public List<PurchaseTxAmount> findByOrder(PurchaseOrder order);

    public List<PurchaseTxAmount> findByOrderId(Long orderId);

    public List<PurchaseTxAmount> findByInvoice(PurchaseInvoice invoice);

    public List<PurchaseTxAmount> findByInvoiceId(Long invoiceId);

}
