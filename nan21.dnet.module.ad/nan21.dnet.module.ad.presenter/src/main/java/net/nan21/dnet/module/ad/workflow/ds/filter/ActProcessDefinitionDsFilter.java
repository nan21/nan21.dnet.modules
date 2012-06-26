/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractBaseDsFilter;

public class ActProcessDefinitionDsFilter extends AbstractBaseDsFilter {

    private String id;

    private Long clientId;

    private String key;

    private String fullName;

    private String name;

    private String category;

    private String resourceName;

    private String diagramResourceName;

    private Integer procDefVersion;

    private Integer procDefVersion_From;
    private Integer procDefVersion_To;

    private String deploymentId;

    private Boolean hasStartForm;

    public String getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (String) id;

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Integer getProcDefVersion() {
        return this.procDefVersion;
    }

    public Integer getProcDefVersion_From() {
        return this.procDefVersion_From;
    }

    public Integer getProcDefVersion_To() {
        return this.procDefVersion_To;
    }

    public void setProcDefVersion(Integer procDefVersion) {
        this.procDefVersion = procDefVersion;
    }

    public void setProcDefVersion_From(Integer procDefVersion_From) {
        this.procDefVersion_From = procDefVersion_From;
    }

    public void setProcDefVersion_To(Integer procDefVersion_To) {
        this.procDefVersion_To = procDefVersion_To;
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
