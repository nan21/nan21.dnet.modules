/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

public interface IProjectMemberService extends IEntityService<ProjectMember> {

    public ProjectMember findByName(Long clientId, Project project,
            Assignable member);

    public ProjectMember findByName(Long clientId, Long projectId, Long memberId);

    public List<ProjectMember> findByProject(Project project);

    public List<ProjectMember> findByProjectId(Long projectId);

    public List<ProjectMember> findByMember(Assignable member);

    public List<ProjectMember> findByMemberId(Long memberId);

    public List<ProjectMember> findByProjectRole(ProjectRole projectRole);

    public List<ProjectMember> findByProjectRoleId(Long projectRoleId);

}
