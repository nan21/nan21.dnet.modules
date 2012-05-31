/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.domain.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** SalesInventoryTransaction. */
@Entity
@CascadeOnDelete
@DiscriminatorValue("SO")
@Table(name = SalesInventoryTransaction.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = SalesInventoryTransaction.NQ_FIND_BY_ID, query = "SELECT e FROM SalesInventoryTransaction e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = SalesInventoryTransaction.NQ_FIND_BY_IDS, query = "SELECT e FROM SalesInventoryTransaction e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class SalesInventoryTransaction extends InvTransaction {

    public static final String TABLE_NAME = "SD_INVT_TX";
    public static final String SEQUENCE_NAME = "SD_INVT_TX_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "SalesInventoryTransaction.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "SalesInventoryTransaction.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** DeliveryNotes. */
    @Column(name = "DELIVERYNOTES", length = 4000)
    private String deliveryNotes;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private BusinessPartner customer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
    @JoinColumn(name = "DELIVERYLOCATION_ID", referencedColumnName = "ID")
    private Location deliveryLocation;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contact.class)
    @JoinColumn(name = "DELIVERYCONTACT_ID", referencedColumnName = "ID")
    private Contact deliveryContact;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SalesOrder.class)
    @JoinColumn(name = "SALESORDER_ID", referencedColumnName = "ID")
    private SalesOrder salesOrder;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryNotes() {
        return this.deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }

    public BusinessPartner getCustomer() {
        return this.customer;
    }

    public void setCustomer(BusinessPartner customer) {
        this.customer = customer;
    }

    public Location getDeliveryLocation() {
        return this.deliveryLocation;
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Contact getDeliveryContact() {
        return this.deliveryContact;
    }

    public void setDeliveryContact(Contact deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public SalesOrder getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
    }

}
