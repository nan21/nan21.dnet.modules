/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** VendorGroup. */
@Entity
@Table(name = VendorGroup.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = VendorGroup.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = VendorGroup.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = VendorGroup.NQ_FIND_BY_ID, query = "SELECT e FROM VendorGroup e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = VendorGroup.NQ_FIND_BY_IDS, query = "SELECT e FROM VendorGroup e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = VendorGroup.NQ_FIND_BY_CODE, query = "SELECT e FROM VendorGroup e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = VendorGroup.NQ_FIND_BY_NAME, query = "SELECT e FROM VendorGroup e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class VendorGroup extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_BP_VENDGRP";
    public static final String SEQUENCE_NAME = "MD_BP_VENDGRP_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "VendorGroup.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "VendorGroup.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "VendorGroup.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "VendorGroup.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** CreditLimit. */
    @Column(name = "CREDITLIMIT", scale = 2)
    private Float creditLimit;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
    @JoinColumn(name = "PAYMENTTERM_ID", referencedColumnName = "ID")
    private PaymentTerm paymentTerm;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = VendorGroupAcct.class, mappedBy = "vendorGroup", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<VendorGroupAcct> accounts;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(Float creditLimit) {
        this.creditLimit = creditLimit;
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

    public PaymentTerm getPaymentTerm() {
        return this.paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        if (paymentTerm != null) {
            this.__validate_client_context__(paymentTerm.getClientId());
        }
        this.paymentTerm = paymentTerm;
    }

    public Collection<VendorGroupAcct> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Collection<VendorGroupAcct> accounts) {
        this.accounts = accounts;
    }

    public void addToAccounts(VendorGroupAcct e) {
        if (this.accounts == null) {
            this.accounts = new ArrayList<VendorGroupAcct>();
        }
        e.setVendorGroup(this);
        this.accounts.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
