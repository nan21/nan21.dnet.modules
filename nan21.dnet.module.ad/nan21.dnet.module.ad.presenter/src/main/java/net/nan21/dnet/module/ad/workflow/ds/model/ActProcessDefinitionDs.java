/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractBaseDs;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ActProcessDefinition.class, sort = { @SortField(field = ActProcessDefinitionDs.fNAME) })
public class ActProcessDefinitionDs extends
        AbstractBaseDs<ActProcessDefinition> {

    public static final String fID = "id";
    public static final String fKEY = "key";
    public static final String fFULLNAME = "fullName";
    public static final String fNAME = "name";
    public static final String fCATEGORY = "category";
    public static final String fRESOURCENAME = "resourceName";
    public static final String fDIAGRAMRESOURCENAME = "diagramResourceName";
    public static final String fVERSION = "version";
    public static final String fDEPLOYMENTID = "deploymentId";
    public static final String fHASSTARTFORM = "hasStartForm";

    @DsField()
    private String id;

    @DsField()
    private String key;

    @DsField(fetch = false)
    private String fullName;

    @DsField()
    private String name;

    @DsField()
    private String category;

    @DsField()
    private String resourceName;

    @DsField()
    private String diagramResourceName;

    @DsField()
    private Long version;

    @DsField(join = "left", path = "deployment.id")
    private String deploymentId;

    @DsField()
    private Boolean hasStartForm;

    public ActProcessDefinitionDs() {
        super();
    }

    public ActProcessDefinitionDs(ActProcessDefinition e) {
        super(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDeploymentId() {
        return this.deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Boolean getHasStartForm() {
        return this.hasStartForm;
    }

    public void setHasStartForm(Boolean hasStartForm) {
        this.hasStartForm = hasStartForm;
    }

}
