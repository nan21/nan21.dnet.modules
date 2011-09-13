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

    protected void modelToEntityAttributes(RegionDs ds, Region e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setIso(ds.getIso());
    }

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

    @Override
    public void entityToModel(Region e, RegionDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setIso(e.getIso());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
        ds.setCountryCode(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
    }

}
