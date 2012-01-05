/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** InvTransaction. */
@Entity
@Table(name = InvTransaction.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = InvTransaction.NQ_FIND_BY_ID, query = "SELECT e FROM InvTransaction e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvTransaction.NQ_FIND_BY_IDS, query = "SELECT e FROM InvTransaction e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvTransaction implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "MM_INV_TX";
    public static final String SEQUENCE_NAME = "MM_INV_TX_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "InvTransaction.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "InvTransaction.findByIds";

    /** EventDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENTDATE")
    private Date eventDate;

    /** Source. */
    @Column(name = "SOURCE", length = 255)
    private String source;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = InvTransactionType.class)
    @JoinColumn(name = "TRANSACTIONTYPE_ID", referencedColumnName = "ID")
    private InvTransactionType transactionType;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "FROMINVENTORY_ID", referencedColumnName = "ID")
    private Organization fromInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "TOINVENTORY_ID", referencedColumnName = "ID")
    private Organization toInventory;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = InvTransactionLine.class, mappedBy = "invTransaction", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<InvTransactionLine> lines;

    /* ============== getters - setters ================== */

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public InvTransactionType getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(InvTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Organization getFromInventory() {
        return this.fromInventory;
    }

    public void setFromInventory(Organization fromInventory) {
        this.fromInventory = fromInventory;
    }

    public Organization getToInventory() {
        return this.toInventory;
    }

    public void setToInventory(Organization toInventory) {
        this.toInventory = toInventory;
    }

    public Collection<InvTransactionLine> getLines() {
        return this.lines;
    }

    public void setLines(Collection<InvTransactionLine> lines) {
        this.lines = lines;
    }

    public void addToLines(InvTransactionLine e) {
        if (this.lines == null) {
            this.lines = new ArrayList<InvTransactionLine>();
        }
        e.setInvTransaction(this);
        this.lines.add(e);
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
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
