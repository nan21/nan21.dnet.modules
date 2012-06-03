/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.domain.entity;

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
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ElementSet. */
@Entity
@Table(name = ElementSet.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ElementSet.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ENGINE_ID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ElementSet.NQ_FIND_BY_ID, query = "SELECT e FROM ElementSet e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSet.NQ_FIND_BY_IDS, query = "SELECT e FROM ElementSet e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSet.NQ_FIND_BY_ENGINE_NAME, query = "SELECT e FROM ElementSet e WHERE e.clientId = :pClientId and  e.engine = :pEngine and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSet.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE, query = "SELECT e FROM ElementSet e WHERE e.clientId = :pClientId and  e.engine.id = :pEngineId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ElementSet extends AbstractType {

    public static final String TABLE_NAME = "BD_ELEM_SET";
    public static final String SEQUENCE_NAME = "BD_ELEM_SET_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ElementSet.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ElementSet.findByIds";

    /**
     * Named query find by unique key: Engine_name.
     */
    public static final String NQ_FIND_BY_ENGINE_NAME = "ElementSet.findByEngine_name";

    /**
     * Named query find by unique key: Engine_name using the ID field for references.
     */
    public static final String NQ_FIND_BY_ENGINE_NAME_PRIMITIVE = "ElementSet.findByEngine_name_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Engine.class)
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        if (engine != null) {
            this.__validate_client_context__(engine.getClientId());
        }
        this.engine = engine;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
