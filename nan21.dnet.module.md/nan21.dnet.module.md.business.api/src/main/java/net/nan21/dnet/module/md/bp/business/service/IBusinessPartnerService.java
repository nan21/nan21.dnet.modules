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

import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

public interface IBusinessPartnerService extends
        IEntityService<BusinessPartner> {

    public BusinessPartner findByCode(String code);

    public List<BusinessPartner> findByCountry(Country country);

    public List<BusinessPartner> findByCountryId(Long countryId);

    public List<BusinessPartner> findByLegalForm(CompanyLegalForm legalForm);

    public List<BusinessPartner> findByLegalFormId(Long legalFormId);

    public String getPostingCustomerAcct(BusinessPartner businessPartner,
            Organization organization, AccSchema schema) throws Exception;

    public String getPostingVendorAcct(BusinessPartner businessPartner,
            Organization organization, AccSchema schema) throws Exception;

}
