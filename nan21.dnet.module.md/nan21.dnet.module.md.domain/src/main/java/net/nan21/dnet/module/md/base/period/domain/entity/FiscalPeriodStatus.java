/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.domain.entity;

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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** FiscalPeriodStatus. */
@Entity
@Table(name = FiscalPeriodStatus.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = FiscalPeriodStatus.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ORG_ID", "PERIOD_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = FiscalPeriodStatus.NQ_FIND_BY_ID, query = "SELECT e FROM FiscalPeriodStatus e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriodStatus.NQ_FIND_BY_IDS, query = "SELECT e FROM FiscalPeriodStatus e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriodStatus.NQ_FIND_BY_ORG_PERIOD, query = "SELECT e FROM FiscalPeriodStatus e WHERE e.clientId = :pClientId and  e.org = :pOrg and e.period = :pPeriod ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriodStatus.NQ_FIND_BY_ORG_PERIOD_PRIMITIVE, query = "SELECT e FROM FiscalPeriodStatus e WHERE e.clientId = :pClientId and  e.org.id = :pOrgId and e.period.id = :pPeriodId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class FiscalPeriodStatus extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_PER_STS";
    public static final String SEQUENCE_NAME = "MD_PER_STS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "FiscalPeriodStatus.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "FiscalPeriodStatus.findByIds";

    /**
     * Named query find by unique key: Org_period.
     */
    public static final String NQ_FIND_BY_ORG_PERIOD = "FiscalPeriodStatus.findByOrg_period";

    /**
     * Named query find by unique key: Org_period using the ID field for references.
     */
    public static final String NQ_FIND_BY_ORG_PERIOD_PRIMITIVE = "FiscalPeriodStatus.findByOrg_period_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Closed. */
    @Column(name = "CLOSED", nullable = false)
    @NotNull
    private Boolean closed;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalPeriod.class)
    @JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID")
    private FiscalPeriod period;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public FiscalPeriod getPeriod() {
        return this.period;
    }

    public void setPeriod(FiscalPeriod period) {
        if (period != null) {
            this.__validate_client_context__(period.getClientId());
        }
        this.period = period;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        if (org != null) {
            this.__validate_client_context__(org.getClientId());
        }
        this.org = org;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getClosed() == null) {
            event.updateAttributeWithObject("closed", false);
        }
    }

}
