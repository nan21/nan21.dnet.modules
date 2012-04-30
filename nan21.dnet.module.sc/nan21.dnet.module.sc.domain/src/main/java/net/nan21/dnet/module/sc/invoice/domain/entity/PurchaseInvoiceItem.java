/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.domain.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.eventhandler.PurchaseInvoiceItemEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PurchaseInvoiceItem. */
@Entity
@Table(name = PurchaseInvoiceItem.TABLE_NAME)
@Customizer(PurchaseInvoiceItemEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseInvoiceItem.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseInvoiceItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseInvoiceItem.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseInvoiceItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseInvoiceItem extends AbstractAuditable {

    public static final String TABLE_NAME = "SC_PI_ITEM";
    public static final String SEQUENCE_NAME = "SC_PI_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseInvoiceItem.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseInvoiceItem.findByIds";

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseInvoice.class)
    @JoinColumn(name = "PURCHASEINVOICE_ID", referencedColumnName = "ID")
    private PurchaseInvoice purchaseInvoice;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
    private Uom uom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
    @JoinColumn(name = "TAX_ID", referencedColumnName = "ID")
    private Tax tax;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseInvoiceItemTax.class, mappedBy = "purchaseInvoiceItem", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseInvoiceItemTax> itemTaxes;

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

    public PurchaseInvoice getPurchaseInvoice() {
        return this.purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Collection<PurchaseInvoiceItemTax> getItemTaxes() {
        return this.itemTaxes;
    }

    public void setItemTaxes(Collection<PurchaseInvoiceItemTax> itemTaxes) {
        this.itemTaxes = itemTaxes;
    }

    public void addToItemTaxes(PurchaseInvoiceItemTax e) {
        if (this.itemTaxes == null) {
            this.itemTaxes = new ArrayList<PurchaseInvoiceItemTax>();
        }
        e.setPurchaseInvoiceItem(this);
        this.itemTaxes.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
