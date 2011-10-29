/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.md.business.service.IProjectComponentService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

public class ProjectComponentService extends
        AbstractEntityService<ProjectComponent> implements
        IProjectComponentService {

    public ProjectComponentService() {
        super();
    }

    public ProjectComponentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProjectComponent> getEntityClass() {
        return ProjectComponent.class;
    }

    public ProjectComponent findByName(Long clientId, String name) {
        return (ProjectComponent) this.em
                .createNamedQuery(ProjectComponent.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProjectComponent> findByComponentLead(Assignable componentLead) {
        return this.findByComponentLeadId(componentLead.getId());
    }

    public List<ProjectComponent> findByComponentLeadId(Long componentLeadId) {
        return (List<ProjectComponent>) this.em
                .createQuery(
                        "select e from ProjectComponent e where e.componentLead.id = :pComponentLeadId",
                        ProjectComponent.class)
                .setParameter("pComponentLeadId", componentLeadId)
                .getResultList();
    }

    public List<ProjectComponent> findByProject(Project project) {
        return this.findByProjectId(project.getId());
    }

    public List<ProjectComponent> findByProjectId(Long projectId) {
        return (List<ProjectComponent>) this.em
                .createQuery(
                        "select e from ProjectComponent e where e.project.id = :pProjectId",
                        ProjectComponent.class)
                .setParameter("pProjectId", projectId).getResultList();
    }

}
