/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bp.base.business.service.ICompanyLegalFormService;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerDsConv extends
        AbstractDsConverter<BusinessPartnerDs, BusinessPartner> implements
        IDsConverter<BusinessPartnerDs, BusinessPartner> {

    protected void modelToEntityReferences(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        if (ds.getCountryId() != null) {
            if (e.getCountry() == null
                    || !e.getCountry().getId().equals(ds.getCountryId())) {
                e.setCountry((Country) this.em.find(Country.class,
                        ds.getCountryId()));
            }
        } else {
            this.lookup_country_Country(ds, e);
        }
        if (ds.getLegalFormId() != null) {
            if (e.getLegalForm() == null
                    || !e.getLegalForm().getId().equals(ds.getLegalFormId())) {
                e.setLegalForm((CompanyLegalForm) this.em.find(
                        CompanyLegalForm.class, ds.getLegalFormId()));
            }
        } else {
            this.lookup_legalForm_CompanyLegalForm(ds, e);
        }
    }

    protected void lookup_country_Country(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        if (ds.getCountryCode() != null && !ds.getCountryCode().equals("")) {
            Country x = null;
            try {
                x = ((ICountryService) getService(ICountryService.class))
                        .findByCode(ds.getClientId(), ds.getCountryCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Country` reference:  `countryCode` = "
                                + ds.getCountryCode() + "  ");
            }
            e.setCountry(x);

        } else {
            e.setCountry(null);
        }
    }

    protected void lookup_legalForm_CompanyLegalForm(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        if (ds.getCountryId() != null && !ds.getCountryId().equals("")
                && ds.getLegalForm() != null && !ds.getLegalForm().equals("")) {
            CompanyLegalForm x = null;
            try {
                x = ((ICompanyLegalFormService) getService(ICompanyLegalFormService.class))
                        .findByName(ds.getClientId(), ds.getCountryId(),
                                ds.getLegalForm());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CompanyLegalForm` reference:  `countryId` = "
                                + ds.getCountryId() + " , `legalForm` = "
                                + ds.getLegalForm() + "  ");
            }
            e.setLegalForm(x);

        } else {
            e.setLegalForm(null);
        }
    }

}
