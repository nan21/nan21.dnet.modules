/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.domain.entity;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.bd.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocSequence;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Financiar document types.  */
@Entity
@Table(name = TxDocType.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = TxDocType.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = TxDocType.NQ_FIND_BY_ID, query = "SELECT e FROM TxDocType e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TxDocType.NQ_FIND_BY_IDS, query = "SELECT e FROM TxDocType e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TxDocType.NQ_FIND_BY_NAME, query = "SELECT e FROM TxDocType e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class TxDocType extends AbstractType {

    public static final String TABLE_NAME = "BD_TXDOC_TYPE";
    public static final String SEQUENCE_NAME = "BD_TXDOC_TYPE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "TxDocType.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "TxDocType.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "TxDocType.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Category. */
    @Column(name = "CATEGORY", nullable = false, length = 32)
    @NotBlank
    private String category;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocSequence.class)
    @JoinColumn(name = "DOCSEQUENCE_ID", referencedColumnName = "ID")
    private TxDocSequence docSequence;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccJournal.class)
    @JoinColumn(name = "JOURNAL_ID", referencedColumnName = "ID")
    private AccJournal journal;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TxDocSequence getDocSequence() {
        return this.docSequence;
    }

    public void setDocSequence(TxDocSequence docSequence) {
        this.docSequence = docSequence;
    }

    public AccJournal getJournal() {
        return this.journal;
    }

    public void setJournal(AccJournal journal) {
        this.journal = journal;
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
