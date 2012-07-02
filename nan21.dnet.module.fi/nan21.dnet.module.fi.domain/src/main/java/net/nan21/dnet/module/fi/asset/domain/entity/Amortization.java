/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.fi.asset.domain.entity;

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
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Amortization. */
@Entity
@Table(name = Amortization.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Amortization.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ASSET_ID", "POSTINGDATE" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Amortization.NQ_FIND_BY_ID, query = "SELECT e FROM Amortization e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Amortization.NQ_FIND_BY_IDS, query = "SELECT e FROM Amortization e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Amortization.NQ_FIND_BY_AMORT, query = "SELECT e FROM Amortization e WHERE e.clientId = :pClientId and  e.asset = :pAsset and e.postingDate = :pPostingDate ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Amortization.NQ_FIND_BY_AMORT_PRIMITIVE, query = "SELECT e FROM Amortization e WHERE e.clientId = :pClientId and  e.asset.id = :pAssetId and e.postingDate = :pPostingDate ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Amortization extends AbstractAuditable {

    public static final String TABLE_NAME = "FI_AMORT";
    public static final String SEQUENCE_NAME = "FI_AMORT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Amortization.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Amortization.findByIds";

    /**
     * Named query find by unique key: Amort.
     */
    public static final String NQ_FIND_BY_AMORT = "Amortization.findByAmort";

    /**
     * Named query find by unique key: Amort using the ID field for references.
     */
    public static final String NQ_FIND_BY_AMORT_PRIMITIVE = "Amortization.findByAmort_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** PostingDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "POSTINGDATE")
    private Date postingDate;

    /** Amount. */
    @Column(name = "AMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float amount;

    /** Percentage. */
    @Column(name = "PERCENTAGE", nullable = false, scale = 2)
    @NotNull
    private Float percentage;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Asset.class)
    @JoinColumn(name = "ASSET_ID", referencedColumnName = "ID")
    private Asset asset;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostingDate() {
        return this.postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
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

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
