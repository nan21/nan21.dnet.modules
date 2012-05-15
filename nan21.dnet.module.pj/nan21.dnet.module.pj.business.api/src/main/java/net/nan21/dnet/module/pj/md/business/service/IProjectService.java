/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import net.nan21.dnet.module.pj.md.domain.entity.Project;

public interface IProjectService extends IEntityService<Project> {

    public Project findByCode(String code);

    public Project findByName(String name);

    public List<Project> findByType(ProjectType type);

    public List<Project> findByTypeId(Long typeId);

    public List<Project> findByProjectLead(ProjectMember projectLead);

    public List<Project> findByProjectLeadId(Long projectLeadId);

}
