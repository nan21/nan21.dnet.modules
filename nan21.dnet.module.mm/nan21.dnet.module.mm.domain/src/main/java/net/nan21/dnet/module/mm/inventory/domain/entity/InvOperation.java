/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.domain.entity;

import java.io.Serializable;
import java.util.Date;
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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocator;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** InvOperation. */
@Entity
@Table(name = InvOperation.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = InvOperation.NQ_FIND_BY_ID, query = "SELECT e FROM InvOperation e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvOperation.NQ_FIND_BY_IDS, query = "SELECT e FROM InvOperation e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvOperation implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "MM_INV_OPERATION";
    public static final String SEQUENCE_NAME = "MM_INV_OPERATION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "InvOperation.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "InvOperation.findByIds";

    /** EventDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENTDATE")
    private Date eventDate;

    /** Direction. */
    @Column(name = "DIRECTION", nullable = false, length = 8)
    @NotBlank
    private String direction;

    /** Quantity. */
    @Column(name = "QUANTITY", nullable = false, scale = 2)
    @NotNull
    private Float quantity;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID")
    private Organization inventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
    @JoinColumn(name = "FROM_SUBINV_ID", referencedColumnName = "ID")
    private SubInventory subInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocator.class)
    @JoinColumn(name = "LOCATOR_ID", referencedColumnName = "ID")
    private StockLocator locator;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Product item;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = InvTransactionLine.class)
    @JoinColumn(name = "TRANSACTIONLINE_ID", referencedColumnName = "ID")
    private InvTransactionLine transactionLine;

    /* ============== getters - setters ================== */

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

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

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public Organization getInventory() {
        return this.inventory;
    }

    public void setInventory(Organization inventory) {
        this.inventory = inventory;
    }

    public SubInventory getSubInventory() {
        return this.subInventory;
    }

    public void setSubInventory(SubInventory subInventory) {
        this.subInventory = subInventory;
    }

    public StockLocator getLocator() {
        return this.locator;
    }

    public void setLocator(StockLocator locator) {
        this.locator = locator;
    }

    public Product getItem() {
        return this.item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public InvTransactionLine getTransactionLine() {
        return this.transactionLine;
    }

    public void setTransactionLine(InvTransactionLine transactionLine) {
        this.transactionLine = transactionLine;
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
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
