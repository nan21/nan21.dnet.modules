/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.tx.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Document auto-numbering sequence setup.  */
@Entity
@Table(name = TxDocSequence.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = TxDocSequence.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = TxDocSequence.NQ_FIND_BY_ID, query = "SELECT e FROM TxDocSequence e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TxDocSequence.NQ_FIND_BY_IDS, query = "SELECT e FROM TxDocSequence e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = TxDocSequence.NQ_FIND_BY_NAME, query = "SELECT e FROM TxDocSequence e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class TxDocSequence extends AbstractType {

    public static final String TABLE_NAME = "BD_TXDOC_SEQUENCE";
    public static final String SEQUENCE_NAME = "BD_TXDOC_SEQUENCE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "TxDocSequence.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "TxDocSequence.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "TxDocSequence.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** FirstNo. */
    @Column(name = "FIRSTNO", nullable = false)
    @NotNull
    private Integer firstNo;

    /** LastNo. */
    @Column(name = "LASTNO", nullable = false)
    @NotNull
    private Integer lastNo;

    /** NextNo. */
    @Column(name = "NEXTNO")
    private Integer nextNo;

    /** IncrementBy. */
    @Column(name = "INCREMENTBY")
    private Integer incrementBy;

    /** Prefix. */
    @Column(name = "PREFIX", length = 4)
    private String prefix;

    /** Suffix. */
    @Column(name = "SUFFIX", length = 4)
    private String suffix;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFirstNo() {
        return this.firstNo;
    }

    public void setFirstNo(Integer firstNo) {
        this.firstNo = firstNo;
    }

    public Integer getLastNo() {
        return this.lastNo;
    }

    public void setLastNo(Integer lastNo) {
        this.lastNo = lastNo;
    }

    public Integer getNextNo() {
        return this.nextNo;
    }

    public void setNextNo(Integer nextNo) {
        this.nextNo = nextNo;
    }

    public Integer getIncrementBy() {
        return this.incrementBy;
    }

    public void setIncrementBy(Integer incrementBy) {
        this.incrementBy = incrementBy;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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
