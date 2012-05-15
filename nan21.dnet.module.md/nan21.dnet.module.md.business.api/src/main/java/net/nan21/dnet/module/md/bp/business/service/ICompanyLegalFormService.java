/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

public interface ICompanyLegalFormService extends
        IEntityService<CompanyLegalForm> {

    public CompanyLegalForm findByName(Country country, String name);

    public CompanyLegalForm findByName(Long countryId, String name);

    public List<CompanyLegalForm> findByCountry(Country country);

    public List<CompanyLegalForm> findByCountryId(Long countryId);

}
