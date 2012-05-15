/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

import net.nan21.dnet.module.hr.job.domain.entity.Position;

public interface IPositionService extends IEntityService<Position> {

    public Position findByCode(String code);

    public Position findByName(String name);

    public List<Position> findByOrganization(Organization organization);

    public List<Position> findByOrganizationId(Long organizationId);

    public List<Position> findByJob(Job job);

    public List<Position> findByJobId(Long jobId);

    public List<Position> findByLocation(Location location);

    public List<Position> findByLocationId(Long locationId);

}
