/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import net.nan21.dnet.module.bd.geo.domain.entity.Region;

public interface IRegionService extends IEntityService<Region> {

    public Region findByCodeAndCountry(Country country, String code);

    public Region findByCodeAndCountry(Long countryId, String code);

    public List<Region> findByCountry(Country country);

    public List<Region> findByCountryId(Long countryId);

}
