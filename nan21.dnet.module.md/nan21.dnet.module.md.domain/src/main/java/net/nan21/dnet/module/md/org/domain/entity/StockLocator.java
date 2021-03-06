/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractType;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
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

    public static final String TABLE_NAME = "MD_STOCKLOC";
    public static final String SEQUENCE_NAME = "MD_STOCKLOC_SEQ";

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
        if (subInventory != null) {
            this.__validate_client_context__(subInventory.getClientId());
        }
        this.subInventory = subInventory;
    }

    public StockLocatorType getLocatorType() {
        return this.locatorType;
    }

    public void setLocatorType(StockLocatorType locatorType) {
        if (locatorType != null) {
            this.__validate_client_context__(locatorType.getClientId());
        }
        this.locatorType = locatorType;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
