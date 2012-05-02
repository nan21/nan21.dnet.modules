/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.domain.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Opportunity. */
@Entity
@Table(name = Opportunity.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Opportunity.NQ_FIND_BY_ID, query = "SELECT e FROM Opportunity e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Opportunity.NQ_FIND_BY_IDS, query = "SELECT e FROM Opportunity e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Opportunity extends AbstractType {

    public static final String TABLE_NAME = "SD_OPORT";
    public static final String SEQUENCE_NAME = "SD_OPORT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Opportunity.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Opportunity.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** ExpectedAmount. */
    @Column(name = "EXPECTEDAMOUNT", nullable = false, scale = 2)
    @NotNull
    private Float expectedAmount;

    /** ExpectedCloseDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPECTEDCLOSEDATE", nullable = false)
    @NotNull
    private Date expectedCloseDate;

    /** Campaign. */
    @Column(name = "CAMPAIGN", length = 255)
    private String campaign;

    /** Probability. */
    @Column(name = "PROBABILITY", scale = 2)
    private Float probability;

    /** ResultNote. */
    @Column(name = "RESULTNOTE", length = 4000)
    private String resultNote;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private BusinessPartner account;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    @JoinColumn(name = "EXPECTEDCURRENCY_ID", referencedColumnName = "ID")
    private Currency expectedCurrency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityStage.class)
    @JoinColumn(name = "SALESSTAGE_ID", referencedColumnName = "ID")
    private OpportunityStage salesStage;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private OpportunityStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityPriority.class)
    @JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
    private OpportunityPriority priority;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunitySource.class)
    @JoinColumn(name = "LEADSOURCE_ID", referencedColumnName = "ID")
    private OpportunitySource leadSource;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = OpportunityResultReason.class)
    @JoinColumn(name = "RESULTREASON_ID", referencedColumnName = "ID")
    private OpportunityResultReason resultReason;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Assignable.class)
    @JoinColumn(name = "ASSIGNEDTO_ID", referencedColumnName = "ID")
    private Assignable assignedTo;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getExpectedAmount() {
        return this.expectedAmount;
    }

    public void setExpectedAmount(Float expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public Date getExpectedCloseDate() {
        return this.expectedCloseDate;
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public String getCampaign() {
        return this.campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Float getProbability() {
        return this.probability;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    public String getResultNote() {
        return this.resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }

    @Transient
    public String getBusinessObject() {
        return "Opportunity.";
    }

    public void setBusinessObject(String businessObject) {

    }

    public BusinessPartner getAccount() {
        return this.account;
    }

    public void setAccount(BusinessPartner account) {
        this.account = account;
    }

    public Currency getExpectedCurrency() {
        return this.expectedCurrency;
    }

    public void setExpectedCurrency(Currency expectedCurrency) {
        this.expectedCurrency = expectedCurrency;
    }

    public OpportunityStage getSalesStage() {
        return this.salesStage;
    }

    public void setSalesStage(OpportunityStage salesStage) {
        this.salesStage = salesStage;
    }

    public OpportunityStatus getStatus() {
        return this.status;
    }

    public void setStatus(OpportunityStatus status) {
        this.status = status;
    }

    public OpportunityPriority getPriority() {
        return this.priority;
    }

    public void setPriority(OpportunityPriority priority) {
        this.priority = priority;
    }

    public OpportunitySource getLeadSource() {
        return this.leadSource;
    }

    public void setLeadSource(OpportunitySource leadSource) {
        this.leadSource = leadSource;
    }

    public OpportunityResultReason getResultReason() {
        return this.resultReason;
    }

    public void setResultReason(OpportunityResultReason resultReason) {
        this.resultReason = resultReason;
    }

    public Assignable getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(Assignable assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
