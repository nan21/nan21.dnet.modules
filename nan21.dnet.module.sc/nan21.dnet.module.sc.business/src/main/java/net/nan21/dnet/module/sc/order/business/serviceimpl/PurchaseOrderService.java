/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

public class PurchaseOrderService extends AbstractEntityService<PurchaseOrder>
        implements IPurchaseOrderService {

    public PurchaseOrderService() {
        super();
    }

    public PurchaseOrderService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PurchaseOrder> getEntityClass() {
        return PurchaseOrder.class;
    }

    public List<PurchaseOrder> findByDocType(TxDocType docType) {
        return this.findByDocTypeId(docType.getId());
    }

    public List<PurchaseOrder> findByDocTypeId(Long docTypeId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDocTypeId", docTypeId).getResultList();
    }

    public List<PurchaseOrder> findBySupplier(BusinessPartner supplier) {
        return this.findBySupplierId(supplier.getId());
    }

    public List<PurchaseOrder> findBySupplierId(Long supplierId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSupplierId", supplierId).getResultList();
    }

    public List<PurchaseOrder> findByCustomer(Organization customer) {
        return this.findByCustomerId(customer.getId());
    }

    public List<PurchaseOrder> findByCustomerId(Long customerId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCustomerId", customerId).getResultList();
    }

    public List<PurchaseOrder> findByPriceList(PriceList priceList) {
        return this.findByPriceListId(priceList.getId());
    }

    public List<PurchaseOrder> findByPriceListId(Long priceListId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPriceListId", priceListId).getResultList();
    }

    public List<PurchaseOrder> findByCurrency(Currency currency) {
        return this.findByCurrencyId(currency.getId());
    }

    public List<PurchaseOrder> findByCurrencyId(Long currencyId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCurrencyId", currencyId).getResultList();
    }

    public List<PurchaseOrder> findByPaymentMethod(PaymentMethod paymentMethod) {
        return this.findByPaymentMethodId(paymentMethod.getId());
    }

    public List<PurchaseOrder> findByPaymentMethodId(Long paymentMethodId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentMethodId", paymentMethodId)
                .getResultList();
    }

    public List<PurchaseOrder> findByPaymentTerm(PaymentTerm paymentTerm) {
        return this.findByPaymentTermId(paymentTerm.getId());
    }

    public List<PurchaseOrder> findByPaymentTermId(Long paymentTermId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPaymentTermId", paymentTermId).getResultList();
    }

    public List<PurchaseOrder> findByInventory(Organization inventory) {
        return this.findByInventoryId(inventory.getId());
    }

    public List<PurchaseOrder> findByInventoryId(Long inventoryId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.inventory.id = :pInventoryId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pInventoryId", inventoryId).getResultList();
    }

    public List<PurchaseOrder> findByDeliveryMethod(
            DeliveryMethod deliveryMethod) {
        return this.findByDeliveryMethodId(deliveryMethod.getId());
    }

    public List<PurchaseOrder> findByDeliveryMethodId(Long deliveryMethodId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select e from PurchaseOrder e where e.clientId = :pClientId and e.deliveryMethod.id = :pDeliveryMethodId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDeliveryMethodId", deliveryMethodId)
                .getResultList();
    }

    public List<PurchaseOrder> findByLines(PurchaseOrderItem lines) {
        return this.findByLinesId(lines.getId());
    }

    public List<PurchaseOrder> findByLinesId(Long linesId) {
        return (List<PurchaseOrder>) this.em
                .createQuery(
                        "select distinct e from PurchaseOrder e , IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
                        PurchaseOrder.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinesId", linesId).getResultList();
    }

}
