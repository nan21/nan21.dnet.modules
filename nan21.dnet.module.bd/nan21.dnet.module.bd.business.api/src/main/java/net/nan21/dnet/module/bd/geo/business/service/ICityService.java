/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

import net.nan21.dnet.module.bd.geo.domain.entity.City;

public interface ICityService extends IEntityService<City> {

    public List<City> findByCountry(Country country);

    public List<City> findByCountryId(Long countryId);

    public List<City> findByRegion(Region region);

    public List<City> findByRegionId(Long regionId);

}
