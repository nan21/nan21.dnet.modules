/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IGeoZoneService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZone;

public class GeoZoneService extends AbstractEntityService<GeoZone> implements
        IGeoZoneService {

    public GeoZoneService() {
        super();
    }

    public GeoZoneService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GeoZone> getEntityClass() {
        return GeoZone.class;
    }

    public GeoZone findByName(String name) {
        return (GeoZone) this.em.createNamedQuery(GeoZone.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
