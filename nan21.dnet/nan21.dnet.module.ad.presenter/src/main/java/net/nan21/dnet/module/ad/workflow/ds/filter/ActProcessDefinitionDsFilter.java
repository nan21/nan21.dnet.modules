/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class ActProcessDefinitionDsFilter extends AbstractDsFilter implements
        IModelWithId {

    private String id;

    private String key;

    private String fullName;

    private String name;

    private String category;

    private String resourceName;

    private String diagramResourceName;

    private String deploymentId;

    private Boolean hasStartForm;

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
