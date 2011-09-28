/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IRegionTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.RegionType;

public class RegionTypeService extends AbstractEntityService<RegionType>
        implements IRegionTypeService {

    public RegionTypeService() {
        super();
    }

    public RegionTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<RegionType> getEntityClass() {
        return RegionType.class;
    }

    public RegionType findByName(Long clientId, String name) {
        return (RegionType) this.em
                .createNamedQuery(RegionType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
