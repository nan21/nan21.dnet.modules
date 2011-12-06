/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.md.business.service.IProjectAttachmentService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectAttachment;

public class ProjectAttachmentService extends
        AbstractEntityService<ProjectAttachment> implements
        IProjectAttachmentService {

    public ProjectAttachmentService() {
        super();
    }

    public ProjectAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectAttachment> getEntityClass() {
        return ProjectAttachment.class;
    }

    public List<ProjectAttachment> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<ProjectAttachment> findByProjectId(Long projectId) {
        return (List<ProjectAttachment>) this.em
                .createQuery(
                        "select e from ProjectAttachment e where e.project.id = :pProjectId",
                        ProjectAttachment.class)
                .setParameter("pProjectId", projectId).getResultList();
    }

}
