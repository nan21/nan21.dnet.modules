/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.service.IEmployeeContactTypeService;

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

    public EmployeeContactType findByName(Long clientId, String name) {
        return (EmployeeContactType) this.em
                .createNamedQuery(EmployeeContactType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
