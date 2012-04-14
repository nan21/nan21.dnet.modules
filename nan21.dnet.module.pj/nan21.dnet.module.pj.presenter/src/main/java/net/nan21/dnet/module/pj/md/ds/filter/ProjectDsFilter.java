/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDsFilter;

public class ProjectDsFilter extends AbstractTypeWithCodeDsFilter {

    private Long typeId;

    private Long typeId_From;
    private Long typeId_To;

    private String type;

    private Boolean isPublic;

    private Long projectLeadId;

    private Long projectLeadId_From;
    private Long projectLeadId_To;

    private String projectLead;

    public Long getTypeId() {
        return this.typeId;
    }

    public Long getTypeId_From() {
        return this.typeId_From;
    }

    public Long getTypeId_To() {
        return this.typeId_To;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeId_From(Long typeId_From) {
        this.typeId_From = typeId_From;
    }

    public void setTypeId_To(Long typeId_To) {
        this.typeId_To = typeId_To;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsPublic() {
        return this.isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Long getProjectLeadId() {
        return this.projectLeadId;
    }

    public Long getProjectLeadId_From() {
        return this.projectLeadId_From;
    }

    public Long getProjectLeadId_To() {
        return this.projectLeadId_To;
    }

    public void setProjectLeadId(Long projectLeadId) {
        this.projectLeadId = projectLeadId;
    }

    public void setProjectLeadId_From(Long projectLeadId_From) {
        this.projectLeadId_From = projectLeadId_From;
    }

    public void setProjectLeadId_To(Long projectLeadId_To) {
        this.projectLeadId_To = projectLeadId_To;
    }

    public String getProjectLead() {
        return this.projectLead;
    }

    public void setProjectLead(String projectLead) {
        this.projectLead = projectLead;
    }

}
