/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActByteArray. */
@Entity
@Table(name = ActByteArray.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ActByteArray.NQ_FIND_BY_ID, query = "SELECT e FROM ActByteArray e WHERE  e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActByteArray.NQ_FIND_BY_IDS, query = "SELECT e FROM ActByteArray e WHERE  e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@Cache(type = CacheType.NONE)
public class ActByteArray implements IModelWithId {

    public static final String TABLE_NAME = "ACT_GE_BYTEARRAY";
    public static final String SEQUENCE_NAME = "ACT_GE_BYTEARRAY_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActByteArray.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActByteArray.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 64)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_")
    private Integer revision;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Bytes. */
    @Column(name = "BYTES_")
    @Lob
    private byte[] bytes;

    /** Generated. */
    @Column(name = "GENERATED_")
    private Integer generated;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ActDeployment.class)
    @JoinColumn(name = "DEPLOYMENT_ID_", referencedColumnName = "ID_")
    private ActDeployment deployment;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Integer getGenerated() {
        return this.generated;
    }

    public void setGenerated(Integer generated) {
        this.generated = generated;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public ActDeployment getDeployment() {
        return this.deployment;
    }

    public void setDeployment(ActDeployment deployment) {
        this.deployment = deployment;
    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
