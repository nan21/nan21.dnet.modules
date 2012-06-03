/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.res.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.res.business.service.IEmployeeBaseService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;

public class EmployeeBaseService extends AbstractEntityService<EmployeeBase>
        implements IEmployeeBaseService {

    public EmployeeBaseService() {
        super();
    }

    public EmployeeBaseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeBase> getEntityClass() {
        return EmployeeBase.class;
    }

    public List<EmployeeBase> findByEmployer(Organization employer) {
        return this.findByEmployerId(employer.getId());
    }

    public List<EmployeeBase> findByEmployerId(Long employerId) {
        return (List<EmployeeBase>) this.em
                .createQuery(
                        "select e from EmployeeBase e where e.clientId = :pClientId and e.employer.id = :pEmployerId",
                        EmployeeBase.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pEmployerId", employerId).getResultList();
    }

    public List<EmployeeBase> findByCitizenship(Country citizenship) {
        return this.findByCitizenshipId(citizenship.getId());
    }

    public List<EmployeeBase> findByCitizenshipId(Long citizenshipId) {
        return (List<EmployeeBase>) this.em
                .createQuery(
                        "select e from EmployeeBase e where e.clientId = :pClientId and e.citizenship.id = :pCitizenshipId",
                        EmployeeBase.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCitizenshipId", citizenshipId).getResultList();
    }

}
