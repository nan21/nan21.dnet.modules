/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.domain.entity;

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
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** AssetAcct. */
@Entity
@Table(name = AssetAcct.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = AssetAcct.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ASSET_ID", "ACCSCHEMA_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AssetAcct.NQ_FIND_BY_ID, query = "SELECT e FROM AssetAcct e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetAcct.NQ_FIND_BY_IDS, query = "SELECT e FROM AssetAcct e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA, query = "SELECT e FROM AssetAcct e WHERE e.clientId = :pClientId and  e.asset = :pAsset and e.accSchema = :pAccSchema ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE, query = "SELECT e FROM AssetAcct e WHERE e.clientId = :pClientId and  e.asset.id = :pAssetId and e.accSchema.id = :pAccSchemaId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AssetAcct extends AbstractAuditable {

    public static final String TABLE_NAME = "FI_ASSET_ACCT";
    public static final String SEQUENCE_NAME = "FI_ASSET_ACCT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AssetAcct.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AssetAcct.findByIds";

    /**
     * Named query find by unique key: Account_schema.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA = "AssetAcct.findByAccount_schema";

    /**
     * Named query find by unique key: Account_schema using the ID field for references.
     */
    public static final String NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE = "AssetAcct.findByAccount_schema_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Asset.class)
    @JoinColumn(name = "ASSET_ID", referencedColumnName = "ID")
    private Asset asset;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccSchema.class)
    @JoinColumn(name = "ACCSCHEMA_ID", referencedColumnName = "ID")
    private AccSchema accSchema;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "DEPRECACCOUNT_ID", referencedColumnName = "ID")
    private Account deprecAccount;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Account.class)
    @JoinColumn(name = "ACMLDEPRECACCOUNT_ID", referencedColumnName = "ID")
    private Account acmlDeprecAccount;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public void setAsset(Asset asset) {
        if (asset != null) {
            this.__validate_client_context__(asset.getClientId());
        }
        this.asset = asset;
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

    public Account getDeprecAccount() {
        return this.deprecAccount;
    }

    public void setDeprecAccount(Account deprecAccount) {
        if (deprecAccount != null) {
            this.__validate_client_context__(deprecAccount.getClientId());
        }
        this.deprecAccount = deprecAccount;
    }

    public Account getAcmlDeprecAccount() {
        return this.acmlDeprecAccount;
    }

    public void setAcmlDeprecAccount(Account acmlDeprecAccount) {
        if (acmlDeprecAccount != null) {
            this.__validate_client_context__(acmlDeprecAccount.getClientId());
        }
        this.acmlDeprecAccount = acmlDeprecAccount;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
