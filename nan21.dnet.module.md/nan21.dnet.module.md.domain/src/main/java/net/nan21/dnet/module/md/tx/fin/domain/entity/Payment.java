/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.module.md.tx.fin.domain.eventhandler.PaymentEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Payment. */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITYTYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = Payment.TABLE_NAME)
@Customizer(PaymentEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Payment.NQ_FIND_BY_ID, query = "SELECT e FROM Payment e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Payment.NQ_FIND_BY_IDS, query = "SELECT e FROM Payment e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Payment extends AbstractAuditable {

    public static final String TABLE_NAME = "TX_PYMNT";
    public static final String SEQUENCE_NAME = "TX_PYMNT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Payment.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Payment.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EntityType. */
    @Column(name = "ENTITYTYPE", length = 32)
    private String entityType;

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /** DocNo. */
    @Column(name = "DOCNO", length = 255)
    private String docNo;

    /** DocDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DOCDATE", nullable = false)
    @NotNull
    private Date docDate;

    /** Amount. */
    @Column(name = "AMOUNT", scale = 2)
    private Float amount;

    /** Confirmed. */
    @Column(name = "CONFIRMED", nullable = false)
    @NotNull
    private Boolean confirmed;

    /** Approved. */
    @Column(name = "APPROVED", nullable = false)
    @NotNull
    private Boolean approved;

    /** Posted. */
    @Column(name = "POSTED", nullable = false)
    @NotNull
    private Boolean posted;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "FROMORG_ID", referencedColumnName = "ID")
    private Organization fromOrg;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "TOORG_ID", referencedColumnName = "ID")
    private Organization toOrg;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayAccount.class)
    @JoinColumn(name = "FROMACCOUNT_ID", referencedColumnName = "ID")
    private PayAccount fromAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayAccount.class)
    @JoinColumn(name = "TOACCOUNT_ID", referencedColumnName = "ID")
    private PayAccount toAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PaymentItem.class, mappedBy = "payment", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<PaymentItem> lines;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocNo() {
        return this.docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getDocDate() {
        return this.docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getApproved() {
        return this.approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if (currency != null) {
            this.__validate_client_context__(currency.getClientId());
        }
        this.currency = currency;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            this.__validate_client_context__(paymentMethod.getClientId());
        }
        this.paymentMethod = paymentMethod;
    }

    public Organization getFromOrg() {
        return this.fromOrg;
    }

    public void setFromOrg(Organization fromOrg) {
        if (fromOrg != null) {
            this.__validate_client_context__(fromOrg.getClientId());
        }
        this.fromOrg = fromOrg;
    }

    public Organization getToOrg() {
        return this.toOrg;
    }

    public void setToOrg(Organization toOrg) {
        if (toOrg != null) {
            this.__validate_client_context__(toOrg.getClientId());
        }
        this.toOrg = toOrg;
    }

    public PayAccount getFromAccount() {
        return this.fromAccount;
    }

    public void setFromAccount(PayAccount fromAccount) {
        if (fromAccount != null) {
            this.__validate_client_context__(fromAccount.getClientId());
        }
        this.fromAccount = fromAccount;
    }

    public PayAccount getToAccount() {
        return this.toAccount;
    }

    public void setToAccount(PayAccount toAccount) {
        if (toAccount != null) {
            this.__validate_client_context__(toAccount.getClientId());
        }
        this.toAccount = toAccount;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        if (bpartner != null) {
            this.__validate_client_context__(bpartner.getClientId());
        }
        this.bpartner = bpartner;
    }

    public Collection<PaymentItem> getLines() {
        return this.lines;
    }

    public void setLines(Collection<PaymentItem> lines) {
        this.lines = lines;
    }

    public void addToLines(PaymentItem e) {
        if (this.lines == null) {
            this.lines = new ArrayList<PaymentItem>();
        }
        e.setPayment(this);
        this.lines.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getConfirmed() == null) {
            event.updateAttributeWithObject("confirmed", false);
        }
        if (this.getApproved() == null) {
            event.updateAttributeWithObject("approved", false);
        }
        if (this.getPosted() == null) {
            event.updateAttributeWithObject("posted", false);
        }
    }

}
