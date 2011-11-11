/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.entity;

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
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** BpAccount. */
@Entity
@Table(name = BpAccount.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "BpAccount.findById", query = "SELECT e FROM BpAccount e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "BpAccount.findByIds", query = "SELECT e FROM BpAccount e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpAccount implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "BP_BP_CUSTOMER_INFO";
    public static final String SEQUENCE_NAME = "BP_BP_CUSTOMER_INFO_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BpAccount.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BpAccount.findByIds";

    /** CustCreditLimit. */
    @Column(name = "CUSTCREDITLIMIT", scale = 2)
    private Float custCreditLimit;

    /** VendCreditLimit. */
    @Column(name = "VENDCREDITLIMIT", scale = 2)
    private Float vendCreditLimit;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "BP_ID", referencedColumnName = "ID")
    private BusinessPartner bp;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID")
    private Organization organization;
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

    public BusinessPartner getBp() {
        return this.bp;
    }

    public void setBp(BusinessPartner bp) {
        this.bp = bp;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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
        BpAccount e = (BpAccount) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
