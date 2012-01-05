/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.domain.entity;

import java.io.Serializable;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Opportunity. */
@Entity
@Table(name = Opportunity.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = Opportunity.NQ_FIND_BY_ID, query = "SELECT e FROM Opportunity e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Opportunity.NQ_FIND_BY_IDS, query = "SELECT e FROM Opportunity e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Opportunity implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "SD_OPPORTUNITY";
    public static final String SEQUENCE_NAME = "SD_OPPORTUNITY_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Opportunity.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Opportunity.findByIds";

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

    /** Name. */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Flag which indicates if this record is used.*/
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Notes about this record. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

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

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
