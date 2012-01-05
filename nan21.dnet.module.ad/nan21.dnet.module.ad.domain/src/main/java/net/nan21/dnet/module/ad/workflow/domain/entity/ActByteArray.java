/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActByteArray. */
@Entity
@Table(name = ActByteArray.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ActByteArray.NQ_FIND_BY_ID, query = "SELECT e FROM ActByteArray e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActByteArray.NQ_FIND_BY_IDS, query = "SELECT e FROM ActByteArray e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActByteArray implements Serializable, IModelWithId {

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
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Revision. */
    @Column(name = "REV_", nullable = false)
    @NotNull
    private Integer revision;

    /** DeploymentId. */
    @Column(name = "DEPLOYMENT_ID_", length = 255)
    private String deploymentId;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getDeploymentId() {
        return this.deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
