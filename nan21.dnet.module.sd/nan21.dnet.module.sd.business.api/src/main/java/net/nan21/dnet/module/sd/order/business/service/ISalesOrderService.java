/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.fin.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import java.util.Date;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;

public interface ISalesOrderService extends IEntityService<SalesOrder> {

    public List<SalesOrder> findByDocType(FinDocType docType);

    public List<SalesOrder> findByDocTypeId(Long docTypeId);

    public List<SalesOrder> findByCustomer(BusinessPartner customer);

    public List<SalesOrder> findByCustomerId(Long customerId);

    public List<SalesOrder> findBySupplier(Organization supplier);

    public List<SalesOrder> findBySupplierId(Long supplierId);

    public List<SalesOrder> findByPriceList(PriceList priceList);

    public List<SalesOrder> findByPriceListId(Long priceListId);

    public List<SalesOrder> findByCurrency(Currency currency);

    public List<SalesOrder> findByCurrencyId(Long currencyId);

    public List<SalesOrder> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<SalesOrder> findByPaymentMethodId(Long paymentMethodId);

    public List<SalesOrder> findByPaymentTerm(PaymentMethod paymentTerm);

    public List<SalesOrder> findByPaymentTermId(Long paymentTermId);

    public List<SalesOrder> findByInventory(Organization inventory);

    public List<SalesOrder> findByInventoryId(Long inventoryId);

    public List<SalesOrder> findByDeliveryMethod(DeliveryMethod deliveryMethod);

    public List<SalesOrder> findByDeliveryMethodId(Long deliveryMethodId);

    public List<SalesOrder> findByCarrier(Organization carrier);

    public List<SalesOrder> findByCarrierId(Long carrierId);

    public List<SalesOrder> findByBillTo(BusinessPartner billTo);

    public List<SalesOrder> findByBillToId(Long billToId);

    public List<SalesOrder> findByBillToLocation(Location billToLocation);

    public List<SalesOrder> findByBillToLocationId(Long billToLocationId);

    public List<SalesOrder> findByShipTo(BusinessPartner shipTo);

    public List<SalesOrder> findByShipToId(Long shipToId);

    public List<SalesOrder> findByShipToLocation(Location shipToLocation);

    public List<SalesOrder> findByShipToLocationId(Long shipToLocationId);

    public List<SalesOrder> findByLines(SalesOrderItem lines);

    public List<SalesOrder> findByLinesId(Long linesId);

    public void doGenerateInvoice(SalesOrder salesOrder, FinDocType invDocType)
            throws Exception;

    public void doGenerateDelivery(SalesOrder salesOrder,
            FinDocType deliveryDocType, InvTransactionType delivTxType,
            Date delivEventDate) throws Exception;

}
