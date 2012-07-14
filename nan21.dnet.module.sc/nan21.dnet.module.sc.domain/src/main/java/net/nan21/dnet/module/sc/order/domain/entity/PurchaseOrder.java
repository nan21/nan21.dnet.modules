/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sc.order.domain.eventhandler.PurchaseOrderEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** PurchaseOrder. */
@Entity
@Table(name = PurchaseOrder.TABLE_NAME)
@Customizer(PurchaseOrderEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseOrder.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseOrder e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseOrder.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseOrder e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseOrder extends AbstractAuditable {

    public static final String TABLE_NAME = "SC_ORD";
    public static final String SEQUENCE_NAME = "SC_ORD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseOrder.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseOrder.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** DocDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DOCDATE", nullable = false)
    @NotNull
    private Date docDate;

    /** DocNo. */
    @Column(name = "DOCNO", length = 255)
    private String docNo;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** PlannedDeliveryDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "PLANNEDDELIVERYDATE")
    private Date plannedDeliveryDate;

    /** DeliveryNotes. */
    @Column(name = "DELIVERYNOTES", length = 4000)
    private String deliveryNotes;

    /** TotalNetAmount. */
    @Column(name = "TOTALNETAMOUNT", scale = 2)
    private Float totalNetAmount;

    /** TotalTaxAmount. */
    @Column(name = "TOTALTAXAMOUNT", scale = 2)
    private Float totalTaxAmount;

    /** TotalAmount. */
    @Column(name = "TOTALAMOUNT", scale = 2)
    private Float totalAmount;

    /** Confirmed. */
    @Column(name = "CONFIRMED", nullable = false)
    @NotNull
    private Boolean confirmed;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
    @JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
    private TxDocType docType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    private BusinessPartner supplier;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Organization customer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PriceList.class)
    @JoinColumn(name = "PRICELIST_ID", referencedColumnName = "ID")
    private PriceList priceList;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
    @JoinColumn(name = "PAYMENTTERM_ID", referencedColumnName = "ID")
    private PaymentTerm paymentTerm;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID")
    private Organization inventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DeliveryMethod.class)
    @JoinColumn(name = "DELIVERYMETHOD_ID", referencedColumnName = "ID")
    private DeliveryMethod deliveryMethod;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseOrderItem.class, mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseOrderItem> lines;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlannedDeliveryDate() {
        return this.plannedDeliveryDate;
    }

    public void setPlannedDeliveryDate(Date plannedDeliveryDate) {
        this.plannedDeliveryDate = plannedDeliveryDate;
    }

    public String getDeliveryNotes() {
        return this.deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public Float getTotalNetAmount() {
        return this.totalNetAmount;
    }

    public void setTotalNetAmount(Float totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    public Float getTotalTaxAmount() {
        return this.totalTaxAmount;
    }

    public void setTotalTaxAmount(Float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public Float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Transient
    public String getBusinessObject() {
        return "PurchaseOrder";
    }

    public void setBusinessObject(String businessObject) {

    }

    public TxDocType getDocType() {
        return this.docType;
    }

    public void setDocType(TxDocType docType) {
        if (docType != null) {
            this.__validate_client_context__(docType.getClientId());
        }
        this.docType = docType;
    }

    public BusinessPartner getSupplier() {
        return this.supplier;
    }

    public void setSupplier(BusinessPartner supplier) {
        if (supplier != null) {
            this.__validate_client_context__(supplier.getClientId());
        }
        this.supplier = supplier;
    }

    public Organization getCustomer() {
        return this.customer;
    }

    public void setCustomer(Organization customer) {
        if (customer != null) {
            this.__validate_client_context__(customer.getClientId());
        }
        this.customer = customer;
    }

    public PriceList getPriceList() {
        return this.priceList;
    }

    public void setPriceList(PriceList priceList) {
        if (priceList != null) {
            this.__validate_client_context__(priceList.getClientId());
        }
        this.priceList = priceList;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if (currency != null) {
            this.__validate_client_context__(currency.getClientId());
        }
        this.currency = currency;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            this.__validate_client_context__(paymentMethod.getClientId());
        }
        this.paymentMethod = paymentMethod;
    }

    public PaymentTerm getPaymentTerm() {
        return this.paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        if (paymentTerm != null) {
            this.__validate_client_context__(paymentTerm.getClientId());
        }
        this.paymentTerm = paymentTerm;
    }

    public Organization getInventory() {
        return this.inventory;
    }

    public void setInventory(Organization inventory) {
        if (inventory != null) {
            this.__validate_client_context__(inventory.getClientId());
        }
        this.inventory = inventory;
    }

    public DeliveryMethod getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        if (deliveryMethod != null) {
            this.__validate_client_context__(deliveryMethod.getClientId());
        }
        this.deliveryMethod = deliveryMethod;
    }

    public Collection<PurchaseOrderItem> getLines() {
        return this.lines;
    }

    public void setLines(Collection<PurchaseOrderItem> lines) {
        this.lines = lines;
    }

    public void addToLines(PurchaseOrderItem e) {
        if (this.lines == null) {
            this.lines = new ArrayList<PurchaseOrderItem>();
        }
        e.setPurchaseOrder(this);
        this.lines.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getConfirmed() == null) {
            event.updateAttributeWithObject("confirmed", false);
        }
        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "PO-" + this.getId());
        }
    }

}
