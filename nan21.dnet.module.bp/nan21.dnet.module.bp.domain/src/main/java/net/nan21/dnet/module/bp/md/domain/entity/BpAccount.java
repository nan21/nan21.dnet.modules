/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.domain.entity;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.fin.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bd.fin.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** BpAccount. */
@Entity
@Table(name = BpAccount.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = BpAccount.NQ_FIND_BY_ID, query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccount.NQ_FIND_BY_IDS, query = "SELECT e FROM BpAccount e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpAccount extends AbstractAuditable {

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** CustCreditLimit. */
    @Column(name = "CUSTCREDITLIMIT", scale = 2)
    private Float custCreditLimit;

    /** VendCreditLimit. */
    @Column(name = "VENDCREDITLIMIT", scale = 2)
    private Float vendCreditLimit;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

        super.aboutToInsert(event);

    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
