/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.eventhandler.PurchaseInvoiceItemEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** PurchaseInvoiceItem. */
@Entity
@Table(name = PurchaseInvoiceItem.TABLE_NAME)
@Customizer(PurchaseInvoiceItemEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseInvoiceItem.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseInvoiceItem e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseInvoiceItem.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseInvoiceItem e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseInvoiceItem extends AbstractAuditable {

    public static final String TABLE_NAME = "SC_INV_ITEM";
    public static final String SEQUENCE_NAME = "SC_INV_ITEM_SEQ";

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
    @Column(name = "UNITPRICE", nullable = false, scale = 2)
    @NotNull
    private Float unitPrice;

    /** NetAmount. */
    @Column(name = "NETAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float netAmount;

    /** TaxAmount. */
    @Column(name = "TAXAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float taxAmount;

    /** LineAmount. */
    @Column(name = "LINEAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float lineAmount;

    /** EntryMode. */
    @Column(name = "ENTRYMODE", nullable = false, length = 16)
    @NotBlank
    private String entryMode;

    /** UseGivenTax. */
    @Column(name = "USEGIVENTAX", nullable = false)
    @NotNull
    private Boolean useGivenTax;
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

    public Float getLineAmount() {
        return this.lineAmount;
    }

    public void setLineAmount(Float lineAmount) {
        this.lineAmount = lineAmount;
    }

    public String getEntryMode() {
        return this.entryMode;
    }

    public void setEntryMode(String entryMode) {
        this.entryMode = entryMode;
    }

    public Boolean getUseGivenTax() {
        return this.useGivenTax;
    }

    public void setUseGivenTax(Boolean useGivenTax) {
        this.useGivenTax = useGivenTax;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return this.purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        if (purchaseInvoice != null) {
            this.__validate_client_context__(purchaseInvoice.getClientId());
        }
        this.purchaseInvoice = purchaseInvoice;
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

        if (this.getUseGivenTax() == null) {
            event.updateAttributeWithObject("useGivenTax", false);
        }
    }

}
