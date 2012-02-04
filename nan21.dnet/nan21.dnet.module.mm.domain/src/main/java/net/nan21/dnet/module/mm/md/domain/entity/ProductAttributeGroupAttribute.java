/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Product attribute group.*/
@Entity
@Table(name = ProductAttributeGroupAttribute.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProductAttributeGroupAttribute.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "GROUP_ID", "ATTRIBUTE_ID" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ProductAttributeGroupAttribute.NQ_FIND_BY_ID, query = "SELECT e FROM ProductAttributeGroupAttribute e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAttributeGroupAttribute.NQ_FIND_BY_IDS, query = "SELECT e FROM ProductAttributeGroupAttribute e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProductAttributeGroupAttribute.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductAttributeGroupAttribute e WHERE e.clientId = :pClientId and  e.group = :pGroup and e.attribute = :pAttribute ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProductAttributeGroupAttribute.findByName_PRIMITIVE", query = "SELECT e FROM ProductAttributeGroupAttribute e WHERE e.clientId = :pClientId and  e.group.id = :pGroupId and e.attribute.id = :pAttributeId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProductAttributeGroupAttribute implements Serializable,
        IModelWithId, IModelWithClientId {

    public static final String TABLE_NAME = "MM_PROD_ATTRGRP_ATTR";
    public static final String SEQUENCE_NAME = "MM_PROD_ATTRGRP_ATTR_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProductAttributeGroupAttribute.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProductAttributeGroupAttribute.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProductAttributeGroupAttribute.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ProductAttributeGroupAttribute.findByName_PRIMITIVE";

    /** SequenceNo. */
    @Column(name = "SEQUENCENO")
    private Integer sequenceNo;

    /** InDescription. */
    @Column(name = "INDESCRIPTION", nullable = false)
    @NotNull
    private Boolean inDescription;

    /**
     * Identifies the client(tenant) which owns this record.
     */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /**
     * Timestamp when this record was created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /**
     * Timestamp when this record was last modified.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /**
     * User who created this record.
     */
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /**
     * User who last modified this record.
     */
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** 
     * Record version number used by the persistence framework.
     */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /**
     * System generated UID. Useful for data import-export and data-replication
     */
    @Column(name = "UUID", length = 36)
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAttributeGroup.class)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private ProductAttributeGroup group;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAttribute.class)
    @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ID")
    private ProductAttribute attribute;

    /* ============== getters - setters ================== */

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

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public ProductAttributeGroup getGroup() {
        return this.group;
    }

    public void setGroup(ProductAttributeGroup group) {
        this.group = group;
    }

    public ProductAttribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(ProductAttribute attribute) {
        this.attribute = attribute;
    }

    public void aboutToInsert(DescriptorEvent event) {

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.uuid == null || this.uuid.equals("")) {
            event.updateAttributeWithObject("uuid", UUID.randomUUID()
                    .toString().toUpperCase());
        }
        if (this.inDescription == null) {
            event.updateAttributeWithObject("inDescription", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
