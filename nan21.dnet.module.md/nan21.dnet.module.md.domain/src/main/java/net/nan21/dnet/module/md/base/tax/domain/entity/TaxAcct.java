/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.domain.entity;

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
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** TaxAcct. */
@Entity
@Table(name = TaxAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = TaxAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "TAX_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = TaxAcct.NQ_FIND_BY_ID, query = "SELECT e FROM TaxAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TaxAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM TaxAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TaxAcct.NQ_FIND_BY_TAX_SCHEMA, query = "SELECT e FROM TaxAcct e WHERE e.clientId = :pClientId and  e.tax = :pTax and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TaxAcct.NQ_FIND_BY_TAX_SCHEMA_PRIMITIVE, query = "SELECT e FROM TaxAcct e WHERE e.clientId = :pClientId and  e.tax.id = :pTaxId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class TaxAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_TAX_ACCT";
    public static final String SEQUENCE_NAME = "MD_TAX_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "TaxAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "TaxAcct.findByIds";

    /**
     * Named query find by unique key: Tax_schema.
     */
    public static final String NQ_FIND_BY_TAX_SCHEMA = "TaxAcct.findByTax_schema";

    /**
     * Named query find by unique key: Tax_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_TAX_SCHEMA_PRIMITIVE = "TaxAcct.findByTax_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
    @JoinColumn(name = "TAX_ID", referencedColumnName = "ID")
    private Tax tax;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "SALESACCOUNT_ID", referencedColumnName = "ID")
    private Account salesAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "PURCHASEACCOUNT_ID", referencedColumnName = "ID")
    private Account purchaseAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tax getTax() {
        return this.tax;
    }

    public void setTax(Tax tax) {
        if (tax != null) {
            this.__validate_client_context__(tax.getClientId());
        }
        this.tax = tax;
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

    public Account getSalesAccount() {
        return this.salesAccount;
    }

    public void setSalesAccount(Account salesAccount) {
        if (salesAccount != null) {
            this.__validate_client_context__(salesAccount.getClientId());
        }
        this.salesAccount = salesAccount;
    }

    public Account getPurchaseAccount() {
        return this.purchaseAccount;
    }

    public void setPurchaseAccount(Account purchaseAccount) {
        if (purchaseAccount != null) {
            this.__validate_client_context__(purchaseAccount.getClientId());
        }
        this.purchaseAccount = purchaseAccount;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
