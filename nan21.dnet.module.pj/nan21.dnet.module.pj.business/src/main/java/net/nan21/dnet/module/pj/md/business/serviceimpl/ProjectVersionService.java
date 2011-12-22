/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.md.business.service.IProjectVersionService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

public class ProjectVersionService extends
        AbstractEntityService<ProjectVersion> implements IProjectVersionService {

    public ProjectVersionService() {
        super();
    }

    public ProjectVersionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectVersion> getEntityClass() {
        return ProjectVersion.class;
    }

    public ProjectVersion findByName(Long clientId, Project project, String name) {
        return (ProjectVersion) this.em
                .createNamedQuery(ProjectVersion.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pProject", project).setParameter("pName", name)
                .getSingleResult();
    }

    public ProjectVersion findByName(Long clientId, Long projectId, String name) {
        return (ProjectVersion) this.em
                .createNamedQuery(ProjectVersion.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pProjectId", projectId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProjectVersion> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<ProjectVersion> findByProjectId(Long projectId) {
        return (List<ProjectVersion>) this.em
                .createQuery(
                        "select e from ProjectVersion e where e.project.id = :pProjectId",
                        ProjectVersion.class)
                .setParameter("pProjectId", projectId).getResultList();
    }

    public List<ProjectVersion> findByProjectVersion(
            ProjectVersion projectVersion) {
        return this.findByProjectVersionId(projectVersion.getId());
    }

    public List<ProjectVersion> findByProjectVersionId(Long projectVersionId) {
        return (List<ProjectVersion>) this.em
                .createQuery(
                        "select e from ProjectVersion e where e.projectVersion.id = :pProjectVersionId",
                        ProjectVersion.class)
                .setParameter("pProjectVersionId", projectVersionId)
                .getResultList();
    }

    public List<ProjectVersion> findByAffectingIssues(Issue affectingIssues) {
        return this.findByAffectingIssuesId(affectingIssues.getId());
    }

    public List<ProjectVersion> findByAffectingIssuesId(Long affectingIssuesId) {
        return (List<ProjectVersion>) this.em
                .createQuery(
                        "select distinct e from ProjectVersion e , IN (e.affectingIssues) c where c.id = :pAffectingIssuesId",
                        ProjectVersion.class)
                .setParameter("pAffectingIssuesId", affectingIssuesId)
                .getResultList();
    }

}
