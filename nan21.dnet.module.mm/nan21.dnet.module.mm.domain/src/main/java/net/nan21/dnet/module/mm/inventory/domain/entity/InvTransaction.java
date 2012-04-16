/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.fin.domain.entity.FinDocType;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.mm.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.mm.inventory.domain.eventhandler.InvTransactionEventHandler;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** InvTransaction. */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "SOURCETYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = InvTransaction.TABLE_NAME)
@Customizer(InvTransactionEventHandler.class)
@NamedQueries({
        @NamedQuery(name = InvTransaction.NQ_FIND_BY_ID, query = "SELECT e FROM InvTransaction e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvTransaction.NQ_FIND_BY_IDS, query = "SELECT e FROM InvTransaction e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvTransaction extends AbstractAuditable {

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EventDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENTDATE")
    private Date eventDate;

    /** SourceType. */
    @Column(name = "SOURCETYPE", nullable = false, length = 32)
    @NotBlank
    private String sourceType;

    /** Source. */
    @Column(name = "SOURCE", length = 255)
    private String source;

    /** Confirmed. */
    @Column(name = "CONFIRMED", nullable = false)
    @NotNull
    private Boolean confirmed;

    /** Posted. */
    @Column(name = "POSTED", nullable = false)
    @NotNull
    private Boolean posted;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FinDocType.class)
    @JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
    private FinDocType docType;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getPosted() {
        return this.posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }

    public FinDocType getDocType() {
        return this.docType;
    }

    public void setDocType(FinDocType docType) {
        this.docType = docType;
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

        super.aboutToInsert(event);

        if (this.confirmed == null) {
            event.updateAttributeWithObject("confirmed", false);
        }
        if (this.posted == null) {
            event.updateAttributeWithObject("posted", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
