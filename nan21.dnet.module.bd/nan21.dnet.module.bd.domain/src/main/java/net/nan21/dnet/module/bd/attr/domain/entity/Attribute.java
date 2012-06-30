/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.domain.entity;

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
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Attribute definition. 
 An attribute is a reusable descriptor identified by a data-type and an optional list of possible values.
 Attributes are grouped in sets which further can be attached to business objects. */
@Entity
@Table(name = Attribute.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Attribute.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Attribute.NQ_FIND_BY_ID, query = "SELECT e FROM Attribute e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Attribute.NQ_FIND_BY_IDS, query = "SELECT e FROM Attribute e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Attribute.NQ_FIND_BY_NAME, query = "SELECT e FROM Attribute e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Attribute extends AbstractType {

    public static final String TABLE_NAME = "BD_ATTR";
    public static final String SEQUENCE_NAME = "BD_ATTR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Attribute.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Attribute.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Attribute.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Title. */
    @Column(name = "TITLE", nullable = false, length = 255)
    @NotBlank
    private String title;

    /** DataType. */
    @Column(name = "DATATYPE", nullable = false, length = 32)
    @NotBlank
    private String dataType;

    /** ListOfvalues. */
    @Column(name = "LISTOFVALUES", length = 400)
    private String listOfvalues;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeCategory.class)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private AttributeCategory category;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "UOM_ID", referencedColumnName = "ID")
    private Uom uom;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getListOfvalues() {
        return this.listOfvalues;
    }

    public void setListOfvalues(String listOfvalues) {
        this.listOfvalues = listOfvalues;
    }

    public AttributeCategory getCategory() {
        return this.category;
    }

    public void setCategory(AttributeCategory category) {
        if (category != null) {
            this.__validate_client_context__(category.getClientId());
        }
        this.category = category;
    }

    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        if (uom != null) {
            this.__validate_client_context__(uom.getClientId());
        }
        this.uom = uom;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

}
