/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.RegionDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

public class RegionDsConv extends AbstractDsConverter<RegionDs, Region>
        implements IDsConverter<RegionDs, Region> {

    protected void modelToEntityReferences(RegionDs ds, Region e)
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
    }

    protected void lookup_country_Country(RegionDs ds, Region e)
            throws Exception {
        if (ds.getCountryCode() != null && !ds.getCountryCode().equals("")) {
            Country x = null;
            try {
                x = ((ICountryService) findEntityService(Country.class))
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

}
