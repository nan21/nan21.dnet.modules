/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.domain.entity;

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
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;
import net.nan21.dnet.module.sd.order.domain.eventhandler.SalesOrderEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** SalesOrder. */
@Entity
@Table(name = SalesOrder.TABLE_NAME)
@Customizer(SalesOrderEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SalesOrder.NQ_FIND_BY_ID, query = "SELECT e FROM SalesOrder e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SalesOrder.NQ_FIND_BY_IDS, query = "SELECT e FROM SalesOrder e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SalesOrder implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "SD_SALES_ORDER";
    public static final String SEQUENCE_NAME = "SD_SALES_ORDER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SalesOrder.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SalesOrder.findByIds";

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
     * Name of entity.
     */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /**
     * Code of entity.
     */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /**
     * Flag which indicates if this record is used.
     */
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /**
     * Notes about this record. 
     */
    @Column(name = "NOTES", length = 4000)
    private String notes;

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
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /**
     * System generated UID. Useful for data import-export and data-replication
     */
    @Column(name = "UUID", length = 36)
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrderStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private SalesOrderStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrderType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private SalesOrderType type;
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
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private BusinessPartner customer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    private Organization supplier;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BILLTO_ID", referencedColumnName = "ID")
    private BusinessPartner billTo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
    @JoinColumn(name = "BILLTOLOCATION_ID", referencedColumnName = "ID")
    private Location billToLocation;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "SHIPTO_ID", referencedColumnName = "ID")
    private BusinessPartner shipTo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
    @JoinColumn(name = "SHIPTOLOCATION_ID", referencedColumnName = "ID")
    private Location shipToLocation;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = SalesOrderItem.class, mappedBy = "salesOrder", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<SalesOrderItem> lines;

    /* ============== getters - setters ================== */

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
        return "SalesOrder";
    }

    public void setBusinessObject(String businessObject) {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public SalesOrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(SalesOrderStatus status) {
        this.status = status;
    }

    public SalesOrderType getType() {
        return this.type;
    }

    public void setType(SalesOrderType type) {
        this.type = type;
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

    public BusinessPartner getCustomer() {
        return this.customer;
    }

    public void setCustomer(BusinessPartner customer) {
        this.customer = customer;
    }

    public Organization getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Organization supplier) {
        this.supplier = supplier;
    }

    public BusinessPartner getBillTo() {
        return this.billTo;
    }

    public void setBillTo(BusinessPartner billTo) {
        this.billTo = billTo;
    }

    public Location getBillToLocation() {
        return this.billToLocation;
    }

    public void setBillToLocation(Location billToLocation) {
        this.billToLocation = billToLocation;
    }

    public BusinessPartner getShipTo() {
        return this.shipTo;
    }

    public void setShipTo(BusinessPartner shipTo) {
        this.shipTo = shipTo;
    }

    public Location getShipToLocation() {
        return this.shipToLocation;
    }

    public void setShipToLocation(Location shipToLocation) {
        this.shipToLocation = shipToLocation;
    }

    public Collection<SalesOrderItem> getLines() {
        return this.lines;
    }

    public void setLines(Collection<SalesOrderItem> lines) {
        this.lines = lines;
    }

    public void addToLines(SalesOrderItem e) {
        if (this.lines == null) {
            this.lines = new ArrayList<SalesOrderItem>();
        }
        e.setSalesOrder(this);
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
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "SO-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
