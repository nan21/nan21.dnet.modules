/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public interface IPaymentItemService extends IEntityService<PaymentItem> {

    public List<PaymentItem> findByPayment(Payment payment);

    public List<PaymentItem> findByPaymentId(Long paymentId);

    public List<PaymentItem> findByAccItem(AccItem accItem);

    public List<PaymentItem> findByAccItemId(Long accItemId);

    public List<PaymentItem> findByProduct(Product product);

    public List<PaymentItem> findByProductId(Long productId);

    public List<PaymentItem> findByUom(Uom uom);

    public List<PaymentItem> findByUomId(Long uomId);

}
