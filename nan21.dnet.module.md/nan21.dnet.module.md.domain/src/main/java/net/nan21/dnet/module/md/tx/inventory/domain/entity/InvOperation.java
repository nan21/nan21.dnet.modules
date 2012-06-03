/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** InvOperation. */
@Entity
@Table(name = InvOperation.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = InvOperation.NQ_FIND_BY_ID, query = "SELECT e FROM InvOperation e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvOperation.NQ_FIND_BY_IDS, query = "SELECT e FROM InvOperation e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvOperation extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_INVT_OPR";
    public static final String SEQUENCE_NAME = "TX_INVT_OPR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "InvOperation.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "InvOperation.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
    private Uom uom;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Organization getInventory() {
        return this.inventory;
    }

    public void setInventory(Organization inventory) {
        if (inventory != null) {
            this.__validate_client_context__(inventory.getClientId());
        }
        this.inventory = inventory;
    }

    public SubInventory getSubInventory() {
        return this.subInventory;
    }

    public void setSubInventory(SubInventory subInventory) {
        if (subInventory != null) {
            this.__validate_client_context__(subInventory.getClientId());
        }
        this.subInventory = subInventory;
    }

    public StockLocator getLocator() {
        return this.locator;
    }

    public void setLocator(StockLocator locator) {
        if (locator != null) {
            this.__validate_client_context__(locator.getClientId());
        }
        this.locator = locator;
    }

    public Product getItem() {
        return this.item;
    }

    public void setItem(Product item) {
        if (item != null) {
            this.__validate_client_context__(item.getClientId());
        }
        this.item = item;
    }

    public InvTransactionLine getTransactionLine() {
        return this.transactionLine;
    }

    public void setTransactionLine(InvTransactionLine transactionLine) {
        if (transactionLine != null) {
            this.__validate_client_context__(transactionLine.getClientId());
        }
        this.transactionLine = transactionLine;
    }

    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        if (uom != null) {
            this.__validate_client_context__(uom.getClientId());
        }
        this.uom = uom;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
