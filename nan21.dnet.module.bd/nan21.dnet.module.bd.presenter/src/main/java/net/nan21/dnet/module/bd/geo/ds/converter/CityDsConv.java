/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.business.service.IRegionService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.CityDs;
import net.nan21.dnet.module.bd.geo.domain.entity.City;

public class CityDsConv extends AbstractDsConverter<CityDs, City> implements
        IDsConverter<CityDs, City> {

    protected void modelToEntityAttributes(CityDs ds, City e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(CityDs ds, City e) throws Exception {

        if (ds.getCountryId() != null) {
            if (e.getCountry() == null
                    || !e.getCountry().getId().equals(ds.getCountryId())) {
                e.setCountry((Country) this.em.getReference(Country.class,
                        ds.getCountryId()));
            }
        } else {
            this.lookup_country_Country(ds, e);
        }
        if (ds.getRegionId() != null) {
            if (e.getRegion() == null
                    || !e.getRegion().getId().equals(ds.getRegionId())) {
                e.setRegion((Region) this.em.getReference(Region.class,
                        ds.getRegionId()));
            }
        } else {
            this.lookup_region_Region(ds, e);
        }
    }

    protected void lookup_country_Country(CityDs ds, City e) throws Exception {
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
        }
    }

    protected void lookup_region_Region(CityDs ds, City e) throws Exception {
        if (ds.getCountryId() != null && !ds.getCountryId().equals("")
                && ds.getRegionCode() != null && !ds.getRegionCode().equals("")) {
            Region x = null;
            try {
                x = ((IRegionService) getService(IRegionService.class))
                        .findByCodeAndCountry(ds.getClientId(),
                                ds.getCountryId(), ds.getRegionCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Region` reference:  `countryId` = "
                                + ds.getCountryId() + " , `regionCode` = "
                                + ds.getRegionCode() + "  ");
            }
            e.setRegion(x);
        }
    }

    @Override
    public void entityToModel(City e, CityDs ds) throws Exception {
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
        ds.setCountryCode(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
        ds.setRegionId(((e.getRegion() != null)) ? e.getRegion().getId() : null);
        ds.setRegionCode(((e.getRegion() != null)) ? e.getRegion().getCode()
                : null);
    }

}
