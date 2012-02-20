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

    @Override
    protected void modelToEntityReferences(CityDs ds, City e, boolean isInsert)
            throws Exception {

        if (ds.getCountryId() != null) {
            if (e.getCountry() == null
                    || !e.getCountry().getId().equals(ds.getCountryId())) {
                e.setCountry((Country) this.em.find(Country.class,
                        ds.getCountryId()));
            }
        } else {
            this.lookup_country_Country(ds, e);
        }

        if (ds.getRegionId() != null) {
            if (e.getRegion() == null
                    || !e.getRegion().getId().equals(ds.getRegionId())) {
                e.setRegion((Region) this.em.find(Region.class,
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
                x = ((ICountryService) findEntityService(Country.class))
                        .findByCode(ds.getCountryCode());
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

    protected void lookup_region_Region(CityDs ds, City e) throws Exception {
        if (ds.getCountryId() != null && !ds.getCountryId().equals("")
                && ds.getRegionCode() != null && !ds.getRegionCode().equals("")) {
            Region x = null;
            try {
                x = ((IRegionService) findEntityService(Region.class))
                        .findByCodeAndCountry(ds.getCountryId(),
                                ds.getRegionCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Region` reference:  `countryId` = "
                                + ds.getCountryId() + " , `regionCode` = "
                                + ds.getRegionCode() + "  ");
            }
            e.setRegion(x);

        } else {
            e.setRegion(null);
        }
    }

}
