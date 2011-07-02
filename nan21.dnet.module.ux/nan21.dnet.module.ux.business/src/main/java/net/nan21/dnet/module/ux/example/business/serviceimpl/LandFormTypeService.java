/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ux.example.business.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ux.example.business.service.ILandFormTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;

public class LandFormTypeService extends AbstractEntityService<LandFormType>
        implements ILandFormTypeService {

    public LandFormTypeService() {
        super();
    }

    public LandFormTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<LandFormType> getEntityClass() {
        return LandFormType.class;
    }

    public LandFormType findByName(Long clientId, String name) {
        return (LandFormType) this.em
                .createNamedQuery(LandFormType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
