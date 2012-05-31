/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.domain.entity;

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
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Attribute of group. 
 Attributes are combined in groups and define specific behavoiur for each group.*/
@Entity
@Table(name = AttributeGroupAttribute.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = AttributeGroupAttribute.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "GROUP_ID", "ATTRIBUTE_ID" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = AttributeGroupAttribute.NQ_FIND_BY_ID, query = "SELECT e FROM AttributeGroupAttribute e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AttributeGroupAttribute.NQ_FIND_BY_IDS, query = "SELECT e FROM AttributeGroupAttribute e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AttributeGroupAttribute.NQ_FIND_BY_NAME, query = "SELECT e FROM AttributeGroupAttribute e WHERE e.clientId = :pClientId and  e.group = :pGroup and e.attribute = :pAttribute ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "AttributeGroupAttribute.findByName_PRIMITIVE", query = "SELECT e FROM AttributeGroupAttribute e WHERE e.clientId = :pClientId and  e.group.id = :pGroupId and e.attribute.id = :pAttributeId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AttributeGroupAttribute extends AbstractAuditable {

    public static final String TABLE_NAME = "MD_ATTR_GRP_ATTR";
    public static final String SEQUENCE_NAME = "MD_ATTR_GRP_ATTR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AttributeGroupAttribute.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AttributeGroupAttribute.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "AttributeGroupAttribute.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "AttributeGroupAttribute.findByName_PRIMITIVE";

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeGroup.class)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private AttributeGroup group;
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

    public AttributeGroup getGroup() {
        return this.group;
    }

    public void setGroup(AttributeGroup group) {
        this.group = group;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getInDescription() == null) {
            event.updateAttributeWithObject("inDescription", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
