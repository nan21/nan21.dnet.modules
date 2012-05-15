/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class ProjectVersionDsFilter extends AbstractTypeDsFilter {

    private Long projectId;

    private Long projectId_From;
    private Long projectId_To;

    private String project;

    private String projectName;

    private Date planDate;

    private Date planDate_From;
    private Date planDate_To;

    private Date releaseDate;

    private Date releaseDate_From;
    private Date releaseDate_To;

    public Long getProjectId() {
        return this.projectId;
    }

    public Long getProjectId_From() {
        return this.projectId_From;
    }

    public Long getProjectId_To() {
        return this.projectId_To;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setProjectId_From(Long projectId_From) {
        this.projectId_From = projectId_From;
    }

    public void setProjectId_To(Long projectId_To) {
        this.projectId_To = projectId_To;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getPlanDate() {
        return this.planDate;
    }

    public Date getPlanDate_From() {
        return this.planDate_From;
    }

    public Date getPlanDate_To() {
        return this.planDate_To;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public void setPlanDate_From(Date planDate_From) {
        this.planDate_From = planDate_From;
    }

    public void setPlanDate_To(Date planDate_To) {
        this.planDate_To = planDate_To;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public Date getReleaseDate_From() {
        return this.releaseDate_From;
    }

    public Date getReleaseDate_To() {
        return this.releaseDate_To;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate_From(Date releaseDate_From) {
        this.releaseDate_From = releaseDate_From;
    }

    public void setReleaseDate_To(Date releaseDate_To) {
        this.releaseDate_To = releaseDate_To;
    }

}
