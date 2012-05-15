/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.geo.domain.entity.GeoZoneType;

public interface IGeoZoneTypeService extends IEntityService<GeoZoneType> {

    public GeoZoneType findByName(String name);

}
