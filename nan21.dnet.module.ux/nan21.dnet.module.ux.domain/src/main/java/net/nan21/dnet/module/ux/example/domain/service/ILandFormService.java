/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ux.example.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;

import net.nan21.dnet.module.ux.example.domain.entity.LandForm;

public interface ILandFormService extends IEntityService<LandForm> {

    public LandForm findByName(Long clientId, LandFormType type, String name);

    public LandForm findByName(Long clientId, Long typeId, String name);

    public List<LandForm> findByType(LandFormType type);

    public List<LandForm> findByTypeId(Long typeId);

    public List<LandForm> findByCountry(Country country);

    public List<LandForm> findByCountryId(Long countryId);

}
