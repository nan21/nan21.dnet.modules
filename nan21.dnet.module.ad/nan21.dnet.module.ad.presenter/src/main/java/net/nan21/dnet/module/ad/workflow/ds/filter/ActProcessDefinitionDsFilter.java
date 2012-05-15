/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActProcessDefinitionDsFilter extends AbstractBaseDsFilter {

    private String id;

    private String key;

    private String fullName;

    private String name;

    private String category;

    private String resourceName;

    private String diagramResourceName;

    private Long version;

    private Long version_From;
    private Long version_To;

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

    public Long getVersion() {
        return this.version;
    }

    public Long getVersion_From() {
        return this.version_From;
    }

    public Long getVersion_To() {
        return this.version_To;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setVersion_From(Long version_From) {
        this.version_From = version_From;
    }

    public void setVersion_To(Long version_To) {
        this.version_To = version_To;
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
