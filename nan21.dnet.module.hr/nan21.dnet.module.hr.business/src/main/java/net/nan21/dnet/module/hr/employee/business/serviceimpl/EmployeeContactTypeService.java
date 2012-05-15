/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

public class EmployeeContactTypeService extends
        AbstractEntityService<EmployeeContactType> implements
        IEmployeeContactTypeService {

    public EmployeeContactTypeService() {
        super();
    }

    public EmployeeContactTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeContactType> getEntityClass() {
        return EmployeeContactType.class;
    }

    public EmployeeContactType findByName(String name) {
        return (EmployeeContactType) this.em
                .createNamedQuery(EmployeeContactType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
