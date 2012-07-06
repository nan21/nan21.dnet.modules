/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** FinancialAccountMethod. */
@Entity
@Table(name = FinancialAccountMethod.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = FinancialAccountMethod.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "FINANCIALACCOUNT_ID",
        "PAYMETHOD_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = FinancialAccountMethod.NQ_FIND_BY_ID, query = "SELECT e FROM FinancialAccountMethod e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountMethod.NQ_FIND_BY_IDS, query = "SELECT e FROM FinancialAccountMethod e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountMethod.NQ_FIND_BY_ACCOUNT_MTD, query = "SELECT e FROM FinancialAccountMethod e WHERE e.clientId = :pClientId and  e.financialAccount = :pFinancialAccount and e.payMethod = :pPayMethod ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountMethod.NQ_FIND_BY_ACCOUNT_MTD_PRIMITIVE, query = "SELECT e FROM FinancialAccountMethod e WHERE e.clientId = :pClientId and  e.financialAccount.id = :pFinancialAccountId and e.payMethod.id = :pPayMethodId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class FinancialAccountMethod extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_FINACNT_MTD";
    public static final String SEQUENCE_NAME = "MD_FINACNT_MTD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "FinancialAccountMethod.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "FinancialAccountMethod.findByIds";

    /**
     * Named query find by unique key: Account_mtd.
     */
    public static final String NQ_FIND_BY_ACCOUNT_MTD = "FinancialAccountMethod.findByAccount_mtd";

    /**
     * Named query find by unique key: Account_mtd using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_MTD_PRIMITIVE = "FinancialAccountMethod.findByAccount_mtd_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** AllowPayIn. */
    @Column(name = "ALLOWPAYIN", nullable = false)
    @NotNull
    private Boolean allowPayIn;

    /** AllowPayOut. */
    @Column(name = "ALLOWPAYOUT", nullable = false)
    @NotNull
    private Boolean allowPayOut;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FinancialAccount.class)
    @JoinColumn(name = "FINANCIALACCOUNT_ID", referencedColumnName = "ID")
    private FinancialAccount financialAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentMethod.class)
    @JoinColumn(name = "PAYMETHOD_ID", referencedColumnName = "ID")
    private PaymentMethod payMethod;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAllowPayIn() {
        return this.allowPayIn;
    }

    public void setAllowPayIn(Boolean allowPayIn) {
        this.allowPayIn = allowPayIn;
    }

    public Boolean getAllowPayOut() {
        return this.allowPayOut;
    }

    public void setAllowPayOut(Boolean allowPayOut) {
        this.allowPayOut = allowPayOut;
    }

    public FinancialAccount getFinancialAccount() {
        return this.financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        if (financialAccount != null) {
            this.__validate_client_context__(financialAccount.getClientId());
        }
        this.financialAccount = financialAccount;
    }

    public PaymentMethod getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(PaymentMethod payMethod) {
        if (payMethod != null) {
            this.__validate_client_context__(payMethod.getClientId());
        }
        this.payMethod = payMethod;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getAllowPayIn() == null) {
            event.updateAttributeWithObject("allowPayIn", false);
        }
        if (this.getAllowPayOut() == null) {
            event.updateAttributeWithObject("allowPayOut", false);
        }
    }

}
