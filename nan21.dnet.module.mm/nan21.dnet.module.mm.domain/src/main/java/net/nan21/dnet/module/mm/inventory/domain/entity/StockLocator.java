/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.domain.entity;

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
import net.nan21.dnet.module.mm.inventory.domain.entity.StockLocatorType;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** StockLocator. */
@Entity
@Table(name = StockLocator.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = StockLocator.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = StockLocator.NQ_FIND_BY_ID, query = "SELECT e FROM StockLocator e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = StockLocator.NQ_FIND_BY_IDS, query = "SELECT e FROM StockLocator e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = StockLocator.NQ_FIND_BY_NAME, query = "SELECT e FROM StockLocator e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class StockLocator extends AbstractType {

    public static final String TABLE_NAME = "MM_STOCKLOCATOR";
    public static final String SEQUENCE_NAME = "MM_STOCKLOCATOR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "StockLocator.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "StockLocator.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "StockLocator.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SubInventory.class)
    @JoinColumn(name = "SUBINVENTORY_ID", referencedColumnName = "ID")
    private SubInventory subInventory;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StockLocatorType.class)
    @JoinColumn(name = "LOCATORTYPE_ID", referencedColumnName = "ID")
    private StockLocatorType locatorType;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubInventory getSubInventory() {
        return this.subInventory;
    }

    public void setSubInventory(SubInventory subInventory) {
        this.subInventory = subInventory;
    }

    public StockLocatorType getLocatorType() {
        return this.locatorType;
    }

    public void setLocatorType(StockLocatorType locatorType) {
        this.locatorType = locatorType;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.active == null) {
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
