/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IProjectMemberService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

public class ProjectMemberService extends AbstractEntityService<ProjectMember>
        implements IProjectMemberService {

    public ProjectMemberService() {
        super();
    }

    public ProjectMemberService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectMember> getEntityClass() {
        return ProjectMember.class;
    }

    public List<ProjectMember> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<ProjectMember> findByProjectId(Long projectId) {
        return (List<ProjectMember>) this.em
                .createQuery(
                        "select e from ProjectMember e where e.project.id = :pProjectId",
                        ProjectMember.class)
                .setParameter("pProjectId", projectId).getResultList();
    }

    public List<ProjectMember> findByMember(Assignable member) {
        return this.findByMemberId(member.getId());
    }

    public List<ProjectMember> findByMemberId(Long memberId) {
        return (List<ProjectMember>) this.em
                .createQuery(
                        "select e from ProjectMember e where e.member.id = :pMemberId",
                        ProjectMember.class)
                .setParameter("pMemberId", memberId).getResultList();
    }

    public List<ProjectMember> findByProjectRole(ProjectRole projectRole) {
        return this.findByProjectRoleId(projectRole.getId());
    }

    public List<ProjectMember> findByProjectRoleId(Long projectRoleId) {
        return (List<ProjectMember>) this.em
                .createQuery(
                        "select e from ProjectMember e where e.projectRole.id = :pProjectRoleId",
                        ProjectMember.class)
                .setParameter("pProjectRoleId", projectRoleId).getResultList();
    }

}
