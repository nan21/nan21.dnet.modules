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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** ElementSetElement. */
@Entity
@Table(name = ElementSetElement.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ElementSetElement.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ELEMENTSET_ID", "ELEMENT_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ElementSetElement.NQ_FIND_BY_ID, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSetElement.NQ_FIND_BY_IDS, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSetElement.NQ_FIND_BY_SET_ELEM, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :pClientId and  e.elementSet = :pElementSet and e.element = :pElement ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ElementSetElement.NQ_FIND_BY_SET_ELEM_PRIMITIVE, query = "SELECT e FROM ElementSetElement e WHERE e.clientId = :pClientId and  e.elementSet.id = :pElementSetId and e.element.id = :pElementId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ElementSetElement extends AbstractAuditable {

    public static final String TABLE_NAME = "BD_ELEM_SET_ELEM";
    public static final String SEQUENCE_NAME = "BD_ELEM_SET_ELEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ElementSetElement.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ElementSetElement.findByIds";

    /**
     * Named query find by unique key: Set_elem.
     */
    public static final String NQ_FIND_BY_SET_ELEM = "ElementSetElement.findBySet_elem";

    /**
     * Named query find by unique key: Set_elem using the ID field for references.
     */
    public static final String NQ_FIND_BY_SET_ELEM_PRIMITIVE = "ElementSetElement.findBySet_elem_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO", nullable = false)
    @NotNull
    private Integer sequenceNo;

    /** PrintLabel. */
    @Column(name = "PRINTLABEL", length = 255)
    private String printLabel;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementSet.class)
    @JoinColumn(name = "ELEMENTSET_ID", referencedColumnName = "ID")
    private ElementSet elementSet;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Element.class)
    @JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
    private Element element;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getPrintLabel() {
        return this.printLabel;
    }

    public void setPrintLabel(String printLabel) {
        this.printLabel = printLabel;
    }

    public ElementSet getElementSet() {
        return this.elementSet;
    }

    public void setElementSet(ElementSet elementSet) {
        if (elementSet != null) {
            this.__validate_client_context__(elementSet.getClientId());
        }
        this.elementSet = elementSet;
    }

    public Element getElement() {
        return this.element;
    }

    public void setElement(Element element) {
        if (element != null) {
            this.__validate_client_context__(element.getClientId());
        }
        this.element = element;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
