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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Attribute sets. 
 Attributes are combined in sets and define specific behavoiur for each set.*/
@Entity
@Table(name = AttributeSetAttribute.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = AttributeSetAttribute.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ATTRIBUTESET_ID", "ATTRIBUTE_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_ID, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_IDS, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_NAME, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :pClientId and  e.attributeSet = :pAttributeSet and e.attribute = :pAttribute ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AttributeSetAttribute.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM AttributeSetAttribute e WHERE e.clientId = :pClientId and  e.attributeSet.id = :pAttributeSetId and e.attribute.id = :pAttributeId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AttributeSetAttribute extends AbstractAuditable {

    public static final String TABLE_NAME = "BD_ATTR_SET_ATTR";
    public static final String SEQUENCE_NAME = "BD_ATTR_SET_ATTR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AttributeSetAttribute.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AttributeSetAttribute.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "AttributeSetAttribute.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "AttributeSetAttribute.findByName_PRIMITIVE";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;

    /** InDescription. */
    @Column(name = "INDESCRIPTION", nullable = false)
    @NotNull
    private Boolean inDescription;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSet.class)
    @JoinColumn(name = "ATTRIBUTESET_ID", referencedColumnName = "ID")
    private AttributeSet attributeSet;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Attribute.class)
    @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
    private Attribute attribute;

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

    public Boolean getInDescription() {
        return this.inDescription;
    }

    public void setInDescription(Boolean inDescription) {
        this.inDescription = inDescription;
    }

    public AttributeSet getAttributeSet() {
        return this.attributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.__validate_client_context__(attributeSet.getClientId());
        }
        this.attributeSet = attributeSet;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        if (attribute != null) {
            this.__validate_client_context__(attribute.getClientId());
        }
        this.attribute = attribute;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getInDescription() == null) {
            event.updateAttributeWithObject("inDescription", false);
        }
    }

}
