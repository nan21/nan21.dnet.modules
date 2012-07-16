/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.business.service.ICompanyLegalFormService;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDs;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

public class BusinessPartnerDsConv extends
        AbstractDsConverter<BusinessPartnerDs, BusinessPartner> implements
        IDsConverter<BusinessPartnerDs, BusinessPartner> {

    @Override
    protected void modelToEntityReferences(BusinessPartnerDs ds,
            BusinessPartner e, boolean isInsert) throws Exception {

        if (ds.getCountryId() == null) {
            Country x = ((ICountryService) findEntityService(Country.class))
                    .findByCode(ds.getCountryCode());

            ds.setCountryId(x.getId());
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

    protected void lookup_legalForm_CompanyLegalForm(BusinessPartnerDs ds,
            BusinessPartner e) throws Exception {
        if (ds.getCountryId() != null && !ds.getCountryId().equals("")
                && ds.getLegalForm() != null && !ds.getLegalForm().equals("")) {
            CompanyLegalForm x = null;
            try {
                x = ((ICompanyLegalFormService) findEntityService(CompanyLegalForm.class))
                        .findByName(ds.getCountryId(), ds.getLegalForm());
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
