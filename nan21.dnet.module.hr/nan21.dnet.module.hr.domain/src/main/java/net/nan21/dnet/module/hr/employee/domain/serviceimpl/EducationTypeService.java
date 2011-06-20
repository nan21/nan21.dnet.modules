/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.service.IEducationTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;

public class EducationTypeService extends AbstractEntityService<EducationType>
        implements IEducationTypeService {

    public EducationTypeService() {
        super();
    }

    public EducationTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EducationType> getEntityClass() {
        return EducationType.class;
    }

    public EducationType findByName(Long clientId, String name) {
        return (EducationType) this.em
                .createNamedQuery(EducationType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
