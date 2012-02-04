/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.business.service.IUomTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

public class UomTypeService extends AbstractEntityService<UomType> implements
        IUomTypeService {

    public UomTypeService() {
        super();
    }

    public UomTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<UomType> getEntityClass() {
        return UomType.class;
    }

    public UomType findByName(Long clientId, String name) {
        return (UomType) this.em.createNamedQuery(UomType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
