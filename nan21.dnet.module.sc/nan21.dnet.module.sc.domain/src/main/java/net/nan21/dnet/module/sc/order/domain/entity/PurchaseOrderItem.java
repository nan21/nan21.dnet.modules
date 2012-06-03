/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.eventhandler.PurchaseOrderItemEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PurchaseOrderItem. */
@Entity
@Table(name = PurchaseOrderItem.TABLE_NAME)
@Customizer(PurchaseOrderItemEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseOrderItem.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseOrderItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseOrderItem.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseOrderItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseOrderItem extends AbstractAuditable {

    public static final String TABLE_NAME = "SC_ORD_ITEM";
    public static final String SEQUENCE_NAME = "SC_ORD_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseOrderItem.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseOrderItem.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Quantity. */
    @Column(name = "QUANTITY", nullable = false, scale = 2)
    @NotNull
    private Float quantity;

    /** UnitPrice. */
    @Column(name = "UNITPRICE", scale = 2)
    private Float unitPrice;

    /** NetAmount. */
    @Column(name = "NETAMOUNT", scale = 2)
    private Float netAmount;

    /** TaxAmount. */
    @Column(name = "TAXAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float taxAmount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrder.class)
    @JoinColumn(name = "PURCHASEORDER_ID", referencedColumnName = "ID")
    private PurchaseOrder purchaseOrder;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
    private Uom uom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
    @JoinColumn(name = "TAX_ID", referencedColumnName = "ID")
    private Tax tax;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseOrderItemTax.class, mappedBy = "purchaseOrderItem", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseOrderItemTax> itemTaxes;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getNetAmount() {
        return this.netAmount;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public Float getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Transient
    public Float getLineAmount() {
        return this.netAmount + this.taxAmount;
    }

    public void setLineAmount(Float lineAmount) {

    }

    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder != null) {
            this.__validate_client_context__(purchaseOrder.getClientId());
        }
        this.purchaseOrder = purchaseOrder;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.__validate_client_context__(product.getClientId());
        }
        this.product = product;
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

    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        if (tax != null) {
            this.__validate_client_context__(tax.getClientId());
        }
        this.tax = tax;
    }

    public Collection<PurchaseOrderItemTax> getItemTaxes() {
        return this.itemTaxes;
    }

    public void setItemTaxes(Collection<PurchaseOrderItemTax> itemTaxes) {
        this.itemTaxes = itemTaxes;
    }

    public void addToItemTaxes(PurchaseOrderItemTax e) {
        if (this.itemTaxes == null) {
            this.itemTaxes = new ArrayList<PurchaseOrderItemTax>();
        }
        e.setPurchaseOrderItem(this);
        this.itemTaxes.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
