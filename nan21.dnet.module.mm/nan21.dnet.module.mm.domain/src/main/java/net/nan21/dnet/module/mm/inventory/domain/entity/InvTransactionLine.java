/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** InvTransactionLine. */
@Entity
@Table(name = InvTransactionLine.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = InvTransactionLine.NQ_FIND_BY_ID, query = "SELECT e FROM InvTransactionLine e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvTransactionLine.NQ_FIND_BY_IDS, query = "SELECT e FROM InvTransactionLine e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvTransactionLine implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "MM_INV_TX_LINE";
    public static final String SEQUENCE_NAME = "MM_INV_TX_LINE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "InvTransactionLine.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "InvTransactionLine.findByIds";

    /** Quantity. */
    @Column(name = "QUANTITY", nullable = false, scale = 2)
    @NotNull
    private Float quantity;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = InvTransaction.class)
    @JoinColumn(name = "INVTRANSACTION_ID", referencedColumnName = "ID")
    private InvTransaction invTransaction;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Product item;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
    @JoinColumn(name = "FROM_SUBINV_ID", referencedColumnName = "ID")
    private SubInventory fromSubInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
    @JoinColumn(name = "FROMLOCATOR_ID", referencedColumnName = "ID")
    private StockLocator fromLocator;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
    @JoinColumn(name = "TO_SUBINV_ID", referencedColumnName = "ID")
    private SubInventory toSubInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
    @JoinColumn(name = "TOLOCATOR_ID", referencedColumnName = "ID")
    private StockLocator toLocator;

    /* ============== getters - setters ================== */

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
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

    public InvTransaction getInvTransaction() {
        return this.invTransaction;
    }

    public void setInvTransaction(InvTransaction invTransaction) {
        this.invTransaction = invTransaction;
    }

    public Product getItem() {
        return this.item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public SubInventory getFromSubInventory() {
        return this.fromSubInventory;
    }

    public void setFromSubInventory(SubInventory fromSubInventory) {
        this.fromSubInventory = fromSubInventory;
    }

    public StockLocator getFromLocator() {
        return this.fromLocator;
    }

    public void setFromLocator(StockLocator fromLocator) {
        this.fromLocator = fromLocator;
    }

    public SubInventory getToSubInventory() {
        return this.toSubInventory;
    }

    public void setToSubInventory(SubInventory toSubInventory) {
        this.toSubInventory = toSubInventory;
    }

    public StockLocator getToLocator() {
        return this.toLocator;
    }

    public void setToLocator(StockLocator toLocator) {
        this.toLocator = toLocator;
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
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
