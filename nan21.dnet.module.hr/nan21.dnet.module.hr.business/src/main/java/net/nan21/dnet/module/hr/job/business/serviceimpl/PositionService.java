/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.hr.job.business.service.IPositionService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

public class PositionService extends AbstractEntityService<Position> implements
        IPositionService {

    public PositionService() {
        super();
    }

    public PositionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Position> getEntityClass() {
        return Position.class;
    }

    public Position findByCode(Long clientId, String code) {
        return (Position) this.em.createNamedQuery(Position.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Position findByName(Long clientId, String name) {
        return (Position) this.em.createNamedQuery(Position.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Position> findByOrganization(Organization organization) {
        return this.findByOrganizationId(organization.getId());
    }

    public List<Position> findByOrganizationId(Long organizationId) {
        return (List<Position>) this.em
                .createQuery(
                        "select e from Position where e.organization.id = :pOrganizationId",
                        Position.class)
                .setParameter("pOrganizationId", organizationId)
                .getResultList();
    }

    public List<Position> findByJob(Job job) {
        return this.findByJobId(job.getId());
    }

    public List<Position> findByJobId(Long jobId) {
        return (List<Position>) this.em
                .createQuery("select e from Position where e.job.id = :pJobId",
                        Position.class).setParameter("pJobId", jobId)
                .getResultList();
    }

    public List<Position> findByLocation(Location location) {
        return this.findByLocationId(location.getId());
    }

    public List<Position> findByLocationId(Long locationId) {
        return (List<Position>) this.em
                .createQuery(
                        "select e from Position where e.location.id = :pLocationId",
                        Position.class).setParameter("pLocationId", locationId)
                .getResultList();
    }

}
