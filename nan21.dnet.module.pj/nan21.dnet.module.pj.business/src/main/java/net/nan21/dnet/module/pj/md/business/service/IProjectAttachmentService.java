/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import net.nan21.dnet.module.pj.md.domain.entity.ProjectAttachment;

public interface IProjectAttachmentService extends
        IEntityService<ProjectAttachment> {

    public List<ProjectAttachment> findByProject(Project project);

    public List<ProjectAttachment> findByProjectId(Long projectId);

}
