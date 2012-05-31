/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.inventory.domain.entity;

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
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** InvTransactionType. */
@Entity
@Table(name = InvTransactionType.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = InvTransactionType.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = InvTransactionType.NQ_FIND_BY_ID, query = "SELECT e FROM InvTransactionType e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvTransactionType.NQ_FIND_BY_IDS, query = "SELECT e FROM InvTransactionType e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = InvTransactionType.NQ_FIND_BY_NAME, query = "SELECT e FROM InvTransactionType e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class InvTransactionType extends AbstractType {

    public static final String TABLE_NAME = "TX_INVT_TX_TYPE";
    public static final String SEQUENCE_NAME = "TX_INVT_TX_TYPE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "InvTransactionType.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "InvTransactionType.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "InvTransactionType.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** HasFromInventory. */
    @Column(name = "HASFROMINVENTORY", nullable = false)
    @NotNull
    private Boolean hasFromInventory;

    /** HasToInventory. */
    @Column(name = "HASTOINVENTORY", nullable = false)
    @NotNull
    private Boolean hasToInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TxDocType.class)
    @JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
    private TxDocType docType;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getHasFromInventory() {
        return this.hasFromInventory;
    }

    public void setHasFromInventory(Boolean hasFromInventory) {
        this.hasFromInventory = hasFromInventory;
    }

    public Boolean getHasToInventory() {
        return this.hasToInventory;
    }

    public void setHasToInventory(Boolean hasToInventory) {
        this.hasToInventory = hasToInventory;
    }

    public TxDocType getDocType() {
        return this.docType;
    }

    public void setDocType(TxDocType docType) {
        this.docType = docType;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getHasFromInventory() == null) {
            event.updateAttributeWithObject("hasFromInventory", false);
        }
        if (this.getHasToInventory() == null) {
            event.updateAttributeWithObject("hasToInventory", false);
        }
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
