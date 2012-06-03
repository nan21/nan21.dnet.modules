/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.domain.entity;

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
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ProductAccountGroupAcct. */
@Entity
@Table(name = ProductAccountGroupAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProductAccountGroupAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "GROUP_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ProductAccountGroupAcct.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAccountGroupAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroupAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAccountGroupAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroupAcct.NQ_FIND_BY_GROUP_SCHEMA, query = "SELECT e FROM ProductAccountGroupAcct e WHERE e.clientId = :pClientId and  e.group = :pGroup and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAccountGroupAcct.NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE, query = "SELECT e FROM ProductAccountGroupAcct e WHERE e.clientId = :pClientId and  e.group.id = :pGroupId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAccountGroupAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_PROD_ACNT_GRP_ACCT";
    public static final String SEQUENCE_NAME = "MD_PROD_ACNT_GRP_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductAccountGroupAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductAccountGroupAcct.findByIds";

    /**
     * Named query find by unique key: Group_schema.
     */
    public static final String NQ_FIND_BY_GROUP_SCHEMA = "ProductAccountGroupAcct.findByGroup_schema";

    /**
     * Named query find by unique key: Group_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_GROUP_SCHEMA_PRIMITIVE = "ProductAccountGroupAcct.findByGroup_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAccountGroup.class)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private ProductAccountGroup group;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "EXPENSEACCOUNT_ID", referencedColumnName = "ID")
    private Account expenseAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "REVENUEACCOUNT_ID", referencedColumnName = "ID")
    private Account revenueAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductAccountGroup getGroup() {
        return this.group;
    }

    public void setGroup(ProductAccountGroup group) {
        if (group != null) {
            this.__validate_client_context__(group.getClientId());
        }
        this.group = group;
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

    public Account getExpenseAccount() {
        return this.expenseAccount;
    }

    public void setExpenseAccount(Account expenseAccount) {
        if (expenseAccount != null) {
            this.__validate_client_context__(expenseAccount.getClientId());
        }
        this.expenseAccount = expenseAccount;
    }

    public Account getRevenueAccount() {
        return this.revenueAccount;
    }

    public void setRevenueAccount(Account revenueAccount) {
        if (revenueAccount != null) {
            this.__validate_client_context__(revenueAccount.getClientId());
        }
        this.revenueAccount = revenueAccount;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
