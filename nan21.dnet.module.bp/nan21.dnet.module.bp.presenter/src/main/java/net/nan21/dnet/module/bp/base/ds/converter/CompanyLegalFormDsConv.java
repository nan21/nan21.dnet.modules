/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.CompanyLegalFormDs;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;

public class CompanyLegalFormDsConv extends
        AbstractDsConverter<CompanyLegalFormDs, CompanyLegalForm> implements
        IDsConverter<CompanyLegalFormDs, CompanyLegalForm> {

    protected void modelToEntityAttributes(CompanyLegalFormDs ds,
            CompanyLegalForm e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(CompanyLegalFormDs ds,
            CompanyLegalForm e) throws Exception {

        if (ds.getCountryId() != null) {
            if (e.getCountry() == null
                    || !e.getCountry().getId().equals(ds.getCountryId())) {
                e.setCountry((Country) this.em.find(Country.class,
                        ds.getCountryId()));
            }
        } else {
            this.lookup_country_Country(ds, e);
        }
    }

    protected void lookup_country_Country(CompanyLegalFormDs ds,
            CompanyLegalForm e) throws Exception {
        if (ds.getCountry() != null && !ds.getCountry().equals("")) {
            Country x = null;
            try {
                x = ((ICountryService) getService(ICountryService.class))
                        .findByCode(ds.getClientId(), ds.getCountry());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Country` reference:  `country` = "
                                + ds.getCountry() + "  ");
            }
            e.setCountry(x);
        } else {
            e.setCountry(null);
        }
    }

    @Override
    public void entityToModel(CompanyLegalForm e, CompanyLegalFormDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
        ds.setCountry(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
    }

}