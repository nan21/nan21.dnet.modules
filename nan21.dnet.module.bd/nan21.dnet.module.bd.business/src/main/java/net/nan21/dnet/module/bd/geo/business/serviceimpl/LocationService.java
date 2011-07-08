/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.ILocationService;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;

public class LocationService extends AbstractEntityService<Location> implements
        ILocationService {

    public LocationService() {
        super();
    }

    public LocationService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Location> getEntityClass() {
        return Location.class;
    }

    public List<Location> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<Location> findByCountryId(Long countryId) {
        return (List<Location>) this.em
                .createQuery(
                        "select e from Location e where e.country.id = :pCountryId",
                        Location.class).setParameter("pCountryId", countryId)
                .getResultList();
    }

    public List<Location> findByRegion(Region region) {
        return this.findByRegionId(region.getId());
    }

    public List<Location> findByRegionId(Long regionId) {
        return (List<Location>) this.em
                .createQuery(
                        "select e from Location e where e.region.id = :pRegionId",
                        Location.class).setParameter("pRegionId", regionId)
                .getResultList();
    }

    public List<Location> findByCity(City city) {
        return this.findByCityId(city.getId());
    }

    public List<Location> findByCityId(Long cityId) {
        return (List<Location>) this.em
                .createQuery(
                        "select e from Location e where e.city.id = :pCityId",
                        Location.class).setParameter("pCityId", cityId)
                .getResultList();
    }

}
