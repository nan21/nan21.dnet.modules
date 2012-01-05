/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.filter;

import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;

import net.nan21.dnet.core.presenter.model.AbstractDsFilter;

public class OrganizationHierarchyItemLovDsFilter extends AbstractDsFilter
        implements IModelWithId, IModelWithClientId {

    private Long id;

    private Long id_From;
    private Long id_To;

    private Long clientId;

    private Long clientId_From;
    private Long clientId_To;

    private Long hierarchyId;

    private Long hierarchyId_From;
    private Long hierarchyId_To;

    private Long organizationId;

    private Long organizationId_From;
    private Long organizationId_To;

    private String organizationCode;

    public Long getId() {
        return this.id;
    }

    public Long getId_From() {
        return this.id_From;
    }

    public Long getId_To() {
        return this.id_To;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public Long getClientId_From() {
        return this.clientId_From;
    }

    public Long getClientId_To() {
        return this.clientId_To;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientId_From(Long clientId_From) {
        this.clientId_From = clientId_From;
    }

    public void setClientId_To(Long clientId_To) {
        this.clientId_To = clientId_To;
    }

    public Long getHierarchyId() {
        return this.hierarchyId;
    }

    public Long getHierarchyId_From() {
        return this.hierarchyId_From;
    }

    public Long getHierarchyId_To() {
        return this.hierarchyId_To;
    }

    public void setHierarchyId(Long hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public void setHierarchyId_From(Long hierarchyId_From) {
        this.hierarchyId_From = hierarchyId_From;
    }

    public void setHierarchyId_To(Long hierarchyId_To) {
        this.hierarchyId_To = hierarchyId_To;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public Long getOrganizationId_From() {
        return this.organizationId_From;
    }

    public Long getOrganizationId_To() {
        return this.organizationId_To;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationId_From(Long organizationId_From) {
        this.organizationId_From = organizationId_From;
    }

    public void setOrganizationId_To(Long organizationId_To) {
        this.organizationId_To = organizationId_To;
    }

    public String getOrganizationCode() {
        return this.organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

}
