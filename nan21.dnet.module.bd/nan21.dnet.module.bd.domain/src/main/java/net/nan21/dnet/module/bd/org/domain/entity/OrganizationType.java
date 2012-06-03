/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.domain.entity;

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
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** OrganizationType. */
@Entity
@Table(name = OrganizationType.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = OrganizationType.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = OrganizationType.NQ_FIND_BY_ID, query = "SELECT e FROM OrganizationType e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = OrganizationType.NQ_FIND_BY_IDS, query = "SELECT e FROM OrganizationType e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = OrganizationType.NQ_FIND_BY_NAME, query = "SELECT e FROM OrganizationType e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class OrganizationType extends AbstractType {

    public static final String TABLE_NAME = "BD_ORG_TYPE";
    public static final String SEQUENCE_NAME = "BD_ORG_TYPE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "OrganizationType.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "OrganizationType.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "OrganizationType.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** VirtualEntity. */
    @Column(name = "VIRTUALENTITY", nullable = false)
    @NotNull
    private Boolean virtualEntity;

    /** LegalEntity. */
    @Column(name = "LEGALENTITY", nullable = false)
    @NotNull
    private Boolean legalEntity;

    /** AccountingEnabled. */
    @Column(name = "ACCOUNTINGENABLED", nullable = false)
    @NotNull
    private Boolean accountingEnabled;

    /** External. */
    @Column(name = "EXTERNAL", nullable = false)
    @NotNull
    private Boolean external;

    /** Inventory. */
    @Column(name = "INVENTORY", nullable = false)
    @NotNull
    private Boolean inventory;

    /** Carrier. */
    @Column(name = "CARRIER", nullable = false)
    @NotNull
    private Boolean carrier;

    /** Warehouse. */
    @Column(name = "WAREHOUSE", nullable = false)
    @NotNull
    private Boolean warehouse;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVirtualEntity() {
        return this.virtualEntity;
    }

    public void setVirtualEntity(Boolean virtualEntity) {
        this.virtualEntity = virtualEntity;
    }

    public Boolean getLegalEntity() {
        return this.legalEntity;
    }

    public void setLegalEntity(Boolean legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Boolean getAccountingEnabled() {
        return this.accountingEnabled;
    }

    public void setAccountingEnabled(Boolean accountingEnabled) {
        this.accountingEnabled = accountingEnabled;
    }

    public Boolean getExternal() {
        return this.external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Boolean getInventory() {
        return this.inventory;
    }

    public void setInventory(Boolean inventory) {
        this.inventory = inventory;
    }

    public Boolean getCarrier() {
        return this.carrier;
    }

    public void setCarrier(Boolean carrier) {
        this.carrier = carrier;
    }

    public Boolean getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Boolean warehouse) {
        this.warehouse = warehouse;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getVirtualEntity() == null) {
            event.updateAttributeWithObject("virtualEntity", false);
        }
        if (this.getLegalEntity() == null) {
            event.updateAttributeWithObject("legalEntity", false);
        }
        if (this.getAccountingEnabled() == null) {
            event.updateAttributeWithObject("accountingEnabled", false);
        }
        if (this.getExternal() == null) {
            event.updateAttributeWithObject("external", false);
        }
        if (this.getInventory() == null) {
            event.updateAttributeWithObject("inventory", false);
        }
        if (this.getCarrier() == null) {
            event.updateAttributeWithObject("carrier", false);
        }
        if (this.getWarehouse() == null) {
            event.updateAttributeWithObject("warehouse", false);
        }
        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
