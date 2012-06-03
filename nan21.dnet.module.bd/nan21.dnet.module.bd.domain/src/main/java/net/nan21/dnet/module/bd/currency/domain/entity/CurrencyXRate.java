/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.currency.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Exchange rate values.*/
@Entity
@Table(name = CurrencyXRate.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = CurrencyXRate.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PROVIDER_ID", "SOURCE_ID",
        "TARGET_ID", "VALIDAT" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = CurrencyXRate.NQ_FIND_BY_ID, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CurrencyXRate.NQ_FIND_BY_IDS, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CurrencyXRate.NQ_FIND_BY_VALID, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :pClientId and  e.provider = :pProvider and e.source = :pSource and e.target = :pTarget and e.validAt = :pValidAt ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = CurrencyXRate.NQ_FIND_BY_VALID_PRIMITIVE, query = "SELECT e FROM CurrencyXRate e WHERE e.clientId = :pClientId and  e.provider.id = :pProviderId and e.source.id = :pSourceId and e.target.id = :pTargetId and e.validAt = :pValidAt ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class CurrencyXRate extends AbstractAuditable {

    public static final String TABLE_NAME = "BD_CRNCY_XRATE";
    public static final String SEQUENCE_NAME = "BD_CRNCY_XRATE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "CurrencyXRate.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "CurrencyXRate.findByIds";

    /**
     * Named query find by unique key: Valid.
     */
    public static final String NQ_FIND_BY_VALID = "CurrencyXRate.findByValid";

    /**
     * Named query find by unique key: Valid using the ID field for references.
     */
    public static final String NQ_FIND_BY_VALID_PRIMITIVE = "CurrencyXRate.findByValid_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Exchange rate valid at.*/
    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDAT", nullable = false)
    @NotNull
    private Date validAt;

    /** Exchange rate value.*/
    @Column(name = "VALUE", nullable = false, scale = 6)
    @NotNull
    private Float value;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CurrencyXRateProvider.class)
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
    private CurrencyXRateProvider provider;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "SOURCE_ID", referencedColumnName = "ID")
    private Currency source;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "TARGET_ID", referencedColumnName = "ID")
    private Currency target;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getValidAt() {
        return this.validAt;
    }

    public void setValidAt(Date validAt) {
        this.validAt = validAt;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public CurrencyXRateProvider getProvider() {
        return this.provider;
    }

    public void setProvider(CurrencyXRateProvider provider) {
        if (provider != null) {
            this.__validate_client_context__(provider.getClientId());
        }
        this.provider = provider;
    }

    public Currency getSource() {
        return this.source;
    }

    public void setSource(Currency source) {
        if (source != null) {
            this.__validate_client_context__(source.getClientId());
        }
        this.source = source;
    }

    public Currency getTarget() {
        return this.target;
    }

    public void setTarget(Currency target) {
        if (target != null) {
            this.__validate_client_context__(target.getClientId());
        }
        this.target = target;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
