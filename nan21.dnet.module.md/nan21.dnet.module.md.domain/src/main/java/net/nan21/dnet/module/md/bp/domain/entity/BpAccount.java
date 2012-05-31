/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** BpAccount. */
@Entity
@Table(name = BpAccount.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = BpAccount.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "BPARTNER_ID", "ORG_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = BpAccount.NQ_FIND_BY_ID, query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccount.NQ_FIND_BY_IDS, query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccount.NQ_FIND_BY_BP_ORG, query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and  e.bpartner = :pBpartner and e.org = :pOrg ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "BpAccount.findByBp_org_PRIMITIVE", query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and  e.bpartner.id = :pBpartnerId and e.org.id = :pOrgId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpAccount extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_BP_ACNT";
    public static final String SEQUENCE_NAME = "MD_BP_ACNT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BpAccount.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BpAccount.findByIds";

    /**
     * Named query find by unique key: Bp_org.
     */
    public static final String NQ_FIND_BY_BP_ORG = "BpAccount.findByBp_org";

    /**
     * Named query find by unique key: Bp_org using the ID field for references.
     */
    public static final String NQ_FIND_BY_BP_ORG_PRIMITIVE = "BpAccount.findByBp_org_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Customer. */
    @Column(name = "CUSTOMER", nullable = false)
    @NotNull
    private Boolean customer;

    /** Vendor. */
    @Column(name = "VENDOR", nullable = false)
    @NotNull
    private Boolean vendor;

    /** CustCreditLimit. */
    @Column(name = "CUSTCREDITLIMIT", scale = 2)
    private Float custCreditLimit;

    /** VendCreditLimit. */
    @Column(name = "VENDCREDITLIMIT", scale = 2)
    private Float vendCreditLimit;

    /** AnaliticSegment. */
    @Column(name = "ANALITICSEGMENT", length = 32)
    private String analiticSegment;

    /** CustAnaliticSegment. */
    @Column(name = "CUSTANALITICSEGMENT", length = 32)
    private String custAnaliticSegment;

    /** VendAnaliticSegment. */
    @Column(name = "VENDANALITICSEGMENT", length = 32)
    private String vendAnaliticSegment;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
    private BusinessPartner bpartner;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerGroup.class)
    @JoinColumn(name = "CUSTGROUP_ID", referencedColumnName = "ID")
    private CustomerGroup custGroup;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "CUSTPAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod custPaymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
    @JoinColumn(name = "CUSTPAYMENTTERM_ID", referencedColumnName = "ID")
    private PaymentTerm custPaymentTerm;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DeliveryMethod.class)
    @JoinColumn(name = "CUSTDELIVERYMETHOD_ID", referencedColumnName = "ID")
    private DeliveryMethod custDeliveryMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = VendorGroup.class)
    @JoinColumn(name = "VENDGROUP_ID", referencedColumnName = "ID")
    private VendorGroup vendGroup;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "VENDPAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod vendPaymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
    @JoinColumn(name = "VENDPAYMENTTERM_ID", referencedColumnName = "ID")
    private PaymentTerm vendPaymentTerm;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCustomer() {
        return this.customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Boolean getVendor() {
        return this.vendor;
    }

    public void setVendor(Boolean vendor) {
        this.vendor = vendor;
    }

    public Float getCustCreditLimit() {
        return this.custCreditLimit;
    }

    public void setCustCreditLimit(Float custCreditLimit) {
        this.custCreditLimit = custCreditLimit;
    }

    public Float getVendCreditLimit() {
        return this.vendCreditLimit;
    }

    public void setVendCreditLimit(Float vendCreditLimit) {
        this.vendCreditLimit = vendCreditLimit;
    }

    public String getAnaliticSegment() {
        return this.analiticSegment;
    }

    public void setAnaliticSegment(String analiticSegment) {
        this.analiticSegment = analiticSegment;
    }

    public String getCustAnaliticSegment() {
        return this.custAnaliticSegment;
    }

    public void setCustAnaliticSegment(String custAnaliticSegment) {
        this.custAnaliticSegment = custAnaliticSegment;
    }

    public String getVendAnaliticSegment() {
        return this.vendAnaliticSegment;
    }

    public void setVendAnaliticSegment(String vendAnaliticSegment) {
        this.vendAnaliticSegment = vendAnaliticSegment;
    }

    public BusinessPartner getBpartner() {
        return this.bpartner;
    }

    public void setBpartner(BusinessPartner bpartner) {
        this.bpartner = bpartner;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public CustomerGroup getCustGroup() {
        return this.custGroup;
    }

    public void setCustGroup(CustomerGroup custGroup) {
        this.custGroup = custGroup;
    }

    public PaymentMethod getCustPaymentMethod() {
        return this.custPaymentMethod;
    }

    public void setCustPaymentMethod(PaymentMethod custPaymentMethod) {
        this.custPaymentMethod = custPaymentMethod;
    }

    public PaymentTerm getCustPaymentTerm() {
        return this.custPaymentTerm;
    }

    public void setCustPaymentTerm(PaymentTerm custPaymentTerm) {
        this.custPaymentTerm = custPaymentTerm;
    }

    public DeliveryMethod getCustDeliveryMethod() {
        return this.custDeliveryMethod;
    }

    public void setCustDeliveryMethod(DeliveryMethod custDeliveryMethod) {
        this.custDeliveryMethod = custDeliveryMethod;
    }

    public VendorGroup getVendGroup() {
        return this.vendGroup;
    }

    public void setVendGroup(VendorGroup vendGroup) {
        this.vendGroup = vendGroup;
    }

    public PaymentMethod getVendPaymentMethod() {
        return this.vendPaymentMethod;
    }

    public void setVendPaymentMethod(PaymentMethod vendPaymentMethod) {
        this.vendPaymentMethod = vendPaymentMethod;
    }

    public PaymentTerm getVendPaymentTerm() {
        return this.vendPaymentTerm;
    }

    public void setVendPaymentTerm(PaymentTerm vendPaymentTerm) {
        this.vendPaymentTerm = vendPaymentTerm;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getCustomer() == null) {
            event.updateAttributeWithObject("customer", false);
        }
        if (this.getVendor() == null) {
            event.updateAttributeWithObject("vendor", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
