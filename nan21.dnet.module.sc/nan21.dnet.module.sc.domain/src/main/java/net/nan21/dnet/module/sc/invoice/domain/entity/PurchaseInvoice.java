/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.module.sc.invoice.domain.eventhandler.PurchaseInvoiceEventHandler;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** PurchaseInvoice. */
@Entity
@Table(name = PurchaseInvoice.TABLE_NAME)
@Customizer(PurchaseInvoiceEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PurchaseInvoice.NQ_FIND_BY_ID, query = "SELECT e FROM PurchaseInvoice e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PurchaseInvoice.NQ_FIND_BY_IDS, query = "SELECT e FROM PurchaseInvoice e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PurchaseInvoice extends AbstractAuditable {

    public static final String TABLE_NAME = "SC_INV";
    public static final String SEQUENCE_NAME = "SC_INV_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PurchaseInvoice.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PurchaseInvoice.findByIds";

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

    /** SelfPayed. */
    @Column(name = "SELFPAYED", nullable = false)
    @NotNull
    private Boolean selfPayed;

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

    /** Posted. */
    @Column(name = "POSTED", nullable = false)
    @NotNull
    private Boolean posted;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
    @JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
    private TxDocType docType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
    private BusinessPartner supplier;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Organization customer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
    @JoinColumn(name = "PAYMENTTERM_ID", referencedColumnName = "ID")
    private PaymentTerm paymentTerm;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayAccount.class)
    @JoinColumn(name = "FROMACCOUNT_ID", referencedColumnName = "ID")
    private PayAccount fromAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PurchaseOrder.class)
    @JoinColumn(name = "PURCHASEORDER_ID", referencedColumnName = "ID")
    private PurchaseOrder purchaseOrder;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseInvoiceItem.class, mappedBy = "purchaseInvoice", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseInvoiceItem> lines;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PurchaseInvoiceTax.class, mappedBy = "purchaseInvoice", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PurchaseInvoiceTax> taxes;

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

    public Boolean getSelfPayed() {
        return this.selfPayed;
    }

    public void setSelfPayed(Boolean selfPayed) {
        this.selfPayed = selfPayed;
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

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    @Transient
    public String getBusinessObject() {
        return "PurchaseInvoice";
    }

    public void setBusinessObject(String businessObject) {

    }

    public TxDocType getDocType() {
        return this.docType;
    }

    public void setDocType(TxDocType docType) {
        this.docType = docType;
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

    public PaymentTerm getPaymentTerm() {
        return this.paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public PayAccount getFromAccount() {
        return this.fromAccount;
    }

    public void setFromAccount(PayAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    public PurchaseOrder getPurchaseOrder() {
        return this.purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Collection<PurchaseInvoiceItem> getLines() {
        return this.lines;
    }

    public void setLines(Collection<PurchaseInvoiceItem> lines) {
        this.lines = lines;
    }

    public void addToLines(PurchaseInvoiceItem e) {
        if (this.lines == null) {
            this.lines = new ArrayList<PurchaseInvoiceItem>();
        }
        e.setPurchaseInvoice(this);
        this.lines.add(e);
    }

    public Collection<PurchaseInvoiceTax> getTaxes() {
        return this.taxes;
    }

    public void setTaxes(Collection<PurchaseInvoiceTax> taxes) {
        this.taxes = taxes;
    }

    public void addToTaxes(PurchaseInvoiceTax e) {
        if (this.taxes == null) {
            this.taxes = new ArrayList<PurchaseInvoiceTax>();
        }
        e.setPurchaseInvoice(this);
        this.taxes.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getSelfPayed() == null) {
            event.updateAttributeWithObject("selfPayed", false);
        }
        if (this.getConfirmed() == null) {
            event.updateAttributeWithObject("confirmed", false);
        }
        if (this.getPosted() == null) {
            event.updateAttributeWithObject("posted", false);
        }
        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "PI-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
