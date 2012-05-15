/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.domain.entity;

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
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PayAccountAcct. */
@Entity
@Table(name = PayAccountAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = PayAccountAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PAYACCOUNT_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayAccountAcct.NQ_FIND_BY_ID, query = "SELECT e FROM PayAccountAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayAccountAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM PayAccountAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA, query = "SELECT e FROM PayAccountAcct e WHERE e.clientId = :pClientId and  e.payAccount = :pPayAccount and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "PayAccountAcct.findByAccount_schema_PRIMITIVE", query = "SELECT e FROM PayAccountAcct e WHERE e.clientId = :pClientId and  e.payAccount.id = :pPayAccountId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayAccountAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_PAY_ACCOUNT_ACCT";
    public static final String SEQUENCE_NAME = "MD_PAY_ACCOUNT_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayAccountAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayAccountAcct.findByIds";

    /**
     * Named query find by unique key: Account_schema.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA = "PayAccountAcct.findByAccount_schema";

    /**
     * Named query find by unique key: Account_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE = "PayAccountAcct.findByAccount_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayAccount.class)
    @JoinColumn(name = "PAYACCOUNT_ID", referencedColumnName = "ID")
    private PayAccount payAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "DEPOSITACCOUNT_ID", referencedColumnName = "ID")
    private Account depositAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "WITHDRAWALACCOUNT_ID", referencedColumnName = "ID")
    private Account withdrawalAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayAccount getPayAccount() {
        return this.payAccount;
    }

    public void setPayAccount(PayAccount payAccount) {
        this.payAccount = payAccount;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        this.accSchema = accSchema;
    }

    public Account getDepositAccount() {
        return this.depositAccount;
    }

    public void setDepositAccount(Account depositAccount) {
        this.depositAccount = depositAccount;
    }

    public Account getWithdrawalAccount() {
        return this.withdrawalAccount;
    }

    public void setWithdrawalAccount(Account withdrawalAccount) {
        this.withdrawalAccount = withdrawalAccount;
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
