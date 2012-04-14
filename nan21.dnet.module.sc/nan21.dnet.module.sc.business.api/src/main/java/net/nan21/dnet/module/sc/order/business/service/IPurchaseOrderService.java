/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.fin.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

public interface IPurchaseOrderService extends IEntityService<PurchaseOrder> {

    public List<PurchaseOrder> findByDocType(FinDocType docType);

    public List<PurchaseOrder> findByDocTypeId(Long docTypeId);

    public List<PurchaseOrder> findBySupplier(BusinessPartner supplier);

    public List<PurchaseOrder> findBySupplierId(Long supplierId);

    public List<PurchaseOrder> findByCustomer(Organization customer);

    public List<PurchaseOrder> findByCustomerId(Long customerId);

    public List<PurchaseOrder> findByPriceList(PriceList priceList);

    public List<PurchaseOrder> findByPriceListId(Long priceListId);

    public List<PurchaseOrder> findByCurrency(Currency currency);

    public List<PurchaseOrder> findByCurrencyId(Long currencyId);

    public List<PurchaseOrder> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<PurchaseOrder> findByPaymentMethodId(Long paymentMethodId);

    public List<PurchaseOrder> findByPaymentTerm(PaymentMethod paymentTerm);

    public List<PurchaseOrder> findByPaymentTermId(Long paymentTermId);

    public List<PurchaseOrder> findByInventory(Organization inventory);

    public List<PurchaseOrder> findByInventoryId(Long inventoryId);

    public List<PurchaseOrder> findByDeliveryMethod(
            DeliveryMethod deliveryMethod);

    public List<PurchaseOrder> findByDeliveryMethodId(Long deliveryMethodId);

    public List<PurchaseOrder> findByLines(PurchaseOrderItem lines);

    public List<PurchaseOrder> findByLinesId(Long linesId);

}
