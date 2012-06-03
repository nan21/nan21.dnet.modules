/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** FiscalPeriod. */
@Entity
@Table(name = FiscalPeriod.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = FiscalPeriod.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = FiscalPeriod.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = FiscalPeriod.NQ_FIND_BY_ID, query = "SELECT e FROM FiscalPeriod e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriod.NQ_FIND_BY_IDS, query = "SELECT e FROM FiscalPeriod e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriod.NQ_FIND_BY_CODE, query = "SELECT e FROM FiscalPeriod e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = FiscalPeriod.NQ_FIND_BY_NAME, query = "SELECT e FROM FiscalPeriod e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class FiscalPeriod extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_PER_PRD";
    public static final String SEQUENCE_NAME = "MD_PER_PRD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "FiscalPeriod.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "FiscalPeriod.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "FiscalPeriod.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "FiscalPeriod.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** StartDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE")
    private Date startDate;

    /** EndDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE")
    private Date endDate;

    /** Posting. */
    @Column(name = "POSTING", nullable = false)
    @NotNull
    private Boolean posting;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalYear.class)
    @JoinColumn(name = "YEAR_ID", referencedColumnName = "ID")
    private FiscalYear year;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getPosting() {
        return this.posting;
    }

    public void setPosting(Boolean posting) {
        this.posting = posting;
    }

    public FiscalYear getYear() {
        return this.year;
    }

    public void setYear(FiscalYear year) {
        if (year != null) {
            this.__validate_client_context__(year.getClientId());
        }
        this.year = year;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getPosting() == null) {
            event.updateAttributeWithObject("posting", false);
        }
        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
