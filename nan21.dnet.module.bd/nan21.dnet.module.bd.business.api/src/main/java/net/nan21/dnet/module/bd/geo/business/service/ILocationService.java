/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

import net.nan21.dnet.module.bd.geo.domain.entity.Location;

public interface ILocationService extends IEntityService<Location> {

    public List<Location> findByCountry(Country country);

    public List<Location> findByCountryId(Long countryId);

    public List<Location> findByRegion(Region region);

    public List<Location> findByRegionId(Long regionId);

    public List<Location> findByCity(City city);

    public List<Location> findByCityId(Long cityId);

}
