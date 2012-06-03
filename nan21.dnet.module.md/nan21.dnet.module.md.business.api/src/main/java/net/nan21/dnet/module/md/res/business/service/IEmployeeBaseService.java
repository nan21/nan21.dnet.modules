/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;

public interface IEmployeeBaseService extends IEntityService<EmployeeBase> {

    public List<EmployeeBase> findByEmployer(Organization employer);

    public List<EmployeeBase> findByEmployerId(Long employerId);

    public List<EmployeeBase> findByCitizenship(Country citizenship);

    public List<EmployeeBase> findByCitizenshipId(Long citizenshipId);

}
