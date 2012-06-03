/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.domain.entity;

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
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** BpAccountAcct. */
@Entity
@Table(name = BpAccountAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = BpAccountAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "BPACCOUNT_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = BpAccountAcct.NQ_FIND_BY_ID, query = "SELECT e FROM BpAccountAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccountAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM BpAccountAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA, query = "SELECT e FROM BpAccountAcct e WHERE e.clientId = :pClientId and  e.bpAccount = :pBpAccount and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = BpAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE, query = "SELECT e FROM BpAccountAcct e WHERE e.clientId = :pClientId and  e.bpAccount.id = :pBpAccountId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class BpAccountAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_BP_ACNT_ACCT";
    public static final String SEQUENCE_NAME = "MD_BP_ACNT_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "BpAccountAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "BpAccountAcct.findByIds";

    /**
     * Named query find by unique key: Account_schema.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA = "BpAccountAcct.findByAccount_schema";

    /**
     * Named query find by unique key: Account_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE = "BpAccountAcct.findByAccount_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BpAccount.class)
    @JoinColumn(name = "BPACCOUNT_ID", referencedColumnName = "ID")
    private BpAccount bpAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "CUSTSALESACCOUNT_ID", referencedColumnName = "ID")
    private Account custSalesAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "CUSTPREPAYACCOUNT_ID", referencedColumnName = "ID")
    private Account custPrepayAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "VENDORPURCHASEACCOUNT_ID", referencedColumnName = "ID")
    private Account vendorPurchaseAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "VENDORPREPAYACCOUNT_ID", referencedColumnName = "ID")
    private Account vendorPrepayAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BpAccount getBpAccount() {
        return this.bpAccount;
    }

    public void setBpAccount(BpAccount bpAccount) {
        if (bpAccount != null) {
            this.__validate_client_context__(bpAccount.getClientId());
        }
        this.bpAccount = bpAccount;
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

    public Account getCustSalesAccount() {
        return this.custSalesAccount;
    }

    public void setCustSalesAccount(Account custSalesAccount) {
        if (custSalesAccount != null) {
            this.__validate_client_context__(custSalesAccount.getClientId());
        }
        this.custSalesAccount = custSalesAccount;
    }

    public Account getCustPrepayAccount() {
        return this.custPrepayAccount;
    }

    public void setCustPrepayAccount(Account custPrepayAccount) {
        if (custPrepayAccount != null) {
            this.__validate_client_context__(custPrepayAccount.getClientId());
        }
        this.custPrepayAccount = custPrepayAccount;
    }

    public Account getVendorPurchaseAccount() {
        return this.vendorPurchaseAccount;
    }

    public void setVendorPurchaseAccount(Account vendorPurchaseAccount) {
        if (vendorPurchaseAccount != null) {
            this.__validate_client_context__(vendorPurchaseAccount
                    .getClientId());
        }
        this.vendorPurchaseAccount = vendorPurchaseAccount;
    }

    public Account getVendorPrepayAccount() {
        return this.vendorPrepayAccount;
    }

    public void setVendorPrepayAccount(Account vendorPrepayAccount) {
        if (vendorPrepayAccount != null) {
            this.__validate_client_context__(vendorPrepayAccount.getClientId());
        }
        this.vendorPrepayAccount = vendorPrepayAccount;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
