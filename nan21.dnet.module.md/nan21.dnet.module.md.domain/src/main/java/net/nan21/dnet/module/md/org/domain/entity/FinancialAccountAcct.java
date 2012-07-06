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
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** FinancialAccountAcct. */
@Entity
@Table(name = FinancialAccountAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = FinancialAccountAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "FINANCIALACCOUNT_ID",
        "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = FinancialAccountAcct.NQ_FIND_BY_ID, query = "SELECT e FROM FinancialAccountAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM FinancialAccountAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA, query = "SELECT e FROM FinancialAccountAcct e WHERE e.clientId = :pClientId and  e.financialAccount = :pFinancialAccount and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE, query = "SELECT e FROM FinancialAccountAcct e WHERE e.clientId = :pClientId and  e.financialAccount.id = :pFinancialAccountId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class FinancialAccountAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_FINACNT_ACCT";
    public static final String SEQUENCE_NAME = "MD_FINACNT_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "FinancialAccountAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "FinancialAccountAcct.findByIds";

    /**
     * Named query find by unique key: Account_schema.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA = "FinancialAccountAcct.findByAccount_schema";

    /**
     * Named query find by unique key: Account_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE = "FinancialAccountAcct.findByAccount_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FinancialAccount.class)
    @JoinColumn(name = "FINANCIALACCOUNT_ID", referencedColumnName = "ID")
    private FinancialAccount financialAccount;
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

    public FinancialAccount getFinancialAccount() {
        return this.financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        if (financialAccount != null) {
            this.__validate_client_context__(financialAccount.getClientId());
        }
        this.financialAccount = financialAccount;
    }

    public AccSchema getAccSchema() {
        return this.accSchema;
    }

    public void setAccSchema(AccSchema accSchema) {
        if (accSchema != null) {
            this.__validate_client_context__(accSchema.getClientId());
        }
        this.accSchema = accSchema;
    }

    public Account getDepositAccount() {
        return this.depositAccount;
    }

    public void setDepositAccount(Account depositAccount) {
        if (depositAccount != null) {
            this.__validate_client_context__(depositAccount.getClientId());
        }
        this.depositAccount = depositAccount;
    }

    public Account getWithdrawalAccount() {
        return this.withdrawalAccount;
    }

    public void setWithdrawalAccount(Account withdrawalAccount) {
        if (withdrawalAccount != null) {
            this.__validate_client_context__(withdrawalAccount.getClientId());
        }
        this.withdrawalAccount = withdrawalAccount;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
