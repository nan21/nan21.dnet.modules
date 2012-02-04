/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmploymentTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;

public class EmploymentTypeService extends
        AbstractEntityService<EmploymentType> implements IEmploymentTypeService {

    public EmploymentTypeService() {
        super();
    }

    public EmploymentTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmploymentType> getEntityClass() {
        return EmploymentType.class;
    }

    public EmploymentType findByName(Long clientId, String name) {
        return (EmploymentType) this.em
                .createNamedQuery(EmploymentType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
