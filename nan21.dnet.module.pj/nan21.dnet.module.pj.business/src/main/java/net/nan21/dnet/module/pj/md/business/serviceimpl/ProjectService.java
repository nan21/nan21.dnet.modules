/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

public class ProjectService extends AbstractEntityService<Project> implements
        IProjectService {

    public ProjectService() {
        super();
    }

    public ProjectService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Project> getEntityClass() {
        return Project.class;
    }

    public Project findByCode(String code) {
        return (Project) this.em.createNamedQuery(Project.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public Project findByName(String name) {
        return (Project) this.em.createNamedQuery(Project.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Project> findByType(ProjectType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Project> findByTypeId(Long typeId) {
        return (List<Project>) this.em
                .createQuery(
                        "select e from Project e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        Project.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<Project> findByProjectLead(ProjectMember projectLead) {
        return this.findByProjectLeadId(projectLead.getId());
    }

    public List<Project> findByProjectLeadId(Long projectLeadId) {
        return (List<Project>) this.em
                .createQuery(
                        "select e from Project e where e.clientId = :pClientId and e.projectLead.id = :pProjectLeadId",
                        Project.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pProjectLeadId", projectLeadId).getResultList();
    }

}
