/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.ICityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.City;

public class CityService extends AbstractEntityService<City> implements
        ICityService {

    public CityService() {
        super();
    }

    public CityService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<City> getEntityClass() {
        return City.class;
    }

    public List<City> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<City> findByCountryId(Long countryId) {
        return (List<City>) this.em
                .createQuery(
                        "select e from City where e.country.id = :pCountryId",
                        City.class).setParameter("pCountryId", countryId)
                .getResultList();
    }

    public List<City> findByRegion(Region region) {
        return this.findByRegionId(region.getId());
    }

    public List<City> findByRegionId(Long regionId) {
        return (List<City>) this.em
                .createQuery(
                        "select e from City where e.region.id = :pRegionId",
                        City.class).setParameter("pRegionId", regionId)
                .getResultList();
    }

}
