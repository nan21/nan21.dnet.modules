/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;
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
public class PurchaseOrder implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "SC_PURCHASE_ORDER";
    public static final String SEQUENCE_NAME = "SC_PURCHASE_ORDER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseOrder.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseOrder.findByIds";

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** DocDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DOCDATE", nullable = false)
    @NotNull
    private Date docDate;

    /** TotalNetAmount. */
    @Column(name = "TOTALNETAMOUNT", scale = 2)
    private Float totalNetAmount;

    /** TotalTaxAmount. */
    @Column(name = "TOTALTAXAMOUNT", scale = 2)
    private Float totalTaxAmount;

    /** TotalAmount. */
    @Column(name = "TOTALAMOUNT", scale = 2)
    private Float totalAmount;

    /**
     * Identifies the client(tenant) which owns this record.
     */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /**
     * Timestamp when this record was created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /**
     * Timestamp when this record was last modified.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /**
     * User who created this record.
     */
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /**
     * User who last modified this record.
     */
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** 
     * Record version number used by the persistence framework.
     */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /**
     * System generated UID. Useful for data import-export and data-replication
     */
    @Column(name = "UUID", length = 36)
    private String uuid;

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PriceList.class)
    @JoinColumn(name = "PRICELIST_ID", referencedColumnName = "ID")
    private PriceList priceList;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DeliveryMethod.class)
    @JoinColumn(name = "DELIVERYMETHOD_ID", referencedColumnName = "ID")
    private DeliveryMethod deliveryMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    private BusinessPartner supplier;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Organization customer;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseOrderItem.class, mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseOrderItem> lines;

    /* ============== getters - setters ================== */

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

    @Transient
    public String getBusinessObject() {
        return "PurchaseOrder";
    }

    public void setBusinessObject(String businessObject) {

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public PriceList getPriceList() {
        return this.priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryMethod getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public BusinessPartner getSupplier() {
        return this.supplier;
    }

    public void setSupplier(BusinessPartner supplier) {
        this.supplier = supplier;
    }

    public Organization getCustomer() {
        return this.customer;
    }

    public void setCustomer(Organization customer) {
        this.customer = customer;
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

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.uuid == null || this.uuid.equals("")) {
            event.updateAttributeWithObject("uuid", UUID.randomUUID()
                    .toString().toUpperCase());
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "PO-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
