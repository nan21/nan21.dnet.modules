/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActProcessDefinition. */
@Entity
@Table(name = ActProcessDefinition.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "ActProcessDefinition.findById", query = "SELECT e FROM ActProcessDefinition e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ActProcessDefinition.findByIds", query = "SELECT e FROM ActProcessDefinition e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActProcessDefinition implements Serializable, IModelWithId {

    public static final String TABLE_NAME = "ACT_RE_PROCDEF";
    public static final String SEQUENCE_NAME = "ACT_RE_PROCDEF_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActProcessDefinition.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActProcessDefinition.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Key. */
    @Column(name = "KEY_", nullable = false, length = 255)
    @NotBlank
    private String key;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Category. */
    @Column(name = "CATEGORY_", length = 255)
    private String category;

    @Version
    /** Version. */
    @Column(name = "VERSION_", nullable = false)
    @NotNull
    private Long version;

    /** ResourceName. */
    @Column(name = "RESOURCE_NAME_", length = 255)
    private String resourceName;

    /** DiagramResourceName. */
    @Column(name = "DGRM_RESOURCE_NAME_", length = 255)
    private String diagramResourceName;

    /** HasStartForm. */
    @Column(name = "HAS_START_FORM_KEY_")
    private Boolean hasStartForm;
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

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public String getFullName() {
        return this.name + " v" + this.version;
    }

    public void setFullName(String fullName) {

    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDiagramResourceName() {
        return this.diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public Boolean getHasStartForm() {
        return this.hasStartForm;
    }

    public void setHasStartForm(Boolean hasStartForm) {
        this.hasStartForm = hasStartForm;
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
        ActProcessDefinition e = (ActProcessDefinition) event.getSource();

    }

}
