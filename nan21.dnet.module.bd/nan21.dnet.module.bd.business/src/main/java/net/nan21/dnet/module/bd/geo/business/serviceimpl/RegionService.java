/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IRegionService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

public class RegionService extends AbstractEntityService<Region> implements
        IRegionService {

    public RegionService() {
        super();
    }

    public RegionService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Region> getEntityClass() {
        return Region.class;
    }

    public Region findByCodeAndCountry(Country country, String code) {
        return (Region) this.em
                .createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountry", country).setParameter("pCode", code)
                .getSingleResult();
    }

    public Region findByCodeAndCountry(Long countryId, String code) {
        return (Region) this.em
                .createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountryId", countryId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<Region> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<Region> findByCountryId(Long countryId) {
        return (List<Region>) this.em
                .createQuery(
                        "select e from Region e where e.clientId = :pClientId and  e.country.id = :pCountryId",
                        Region.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountryId", countryId).getResultList();
    }

}
