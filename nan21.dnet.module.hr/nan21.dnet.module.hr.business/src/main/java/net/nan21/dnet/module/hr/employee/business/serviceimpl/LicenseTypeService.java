/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.ILicenseTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

public class LicenseTypeService extends AbstractEntityService<LicenseType>
        implements ILicenseTypeService {

    public LicenseTypeService() {
        super();
    }

    public LicenseTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<LicenseType> getEntityClass() {
        return LicenseType.class;
    }

    public LicenseType findByName(Long clientId, String name) {
        return (LicenseType) this.em
                .createNamedQuery(LicenseType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
