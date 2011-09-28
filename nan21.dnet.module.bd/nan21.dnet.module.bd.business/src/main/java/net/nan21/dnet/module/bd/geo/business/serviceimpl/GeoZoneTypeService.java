/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IGeoZoneTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZoneType;

public class GeoZoneTypeService extends AbstractEntityService<GeoZoneType>
        implements IGeoZoneTypeService {

    public GeoZoneTypeService() {
        super();
    }

    public GeoZoneTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GeoZoneType> getEntityClass() {
        return GeoZoneType.class;
    }

    public GeoZoneType findByName(Long clientId, String name) {
        return (GeoZoneType) this.em
                .createNamedQuery(GeoZoneType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
