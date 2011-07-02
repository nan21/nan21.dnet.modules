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
import net.nan21.dnet.module.bd.geo.ds.model.LocationDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;

public class LocationDsConv extends AbstractDsConverter<LocationDs, Location>
        implements IDsConverter<LocationDs, Location> {

    protected void modelToEntityAttributes(LocationDs ds, Location e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setRegionName(ds.getRegionName());
        e.setCityName(ds.getCityName());
        e.setAdress(ds.getAdress());
        e.setNotes(ds.getNotes());
        e.setActive(ds.getActive());
        e.setForShipping(ds.getShipping());
        e.setForBilling(ds.getBilling());
        e.setForMailing(ds.getMailing());
        e.setTargetId(ds.getTargetId());
        e.setTargetType(ds.getTargetType());
    }

    protected void modelToEntityReferences(LocationDs ds, Location e)
            throws Exception {

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

    protected void lookup_country_Country(LocationDs ds, Location e)
            throws Exception {
        Country x = null;
        try {
            x = ((ICountryService) getService(ICountryService.class))
                    .findByCode(ds.getClientId(), ds.getCountryCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCountry(x);
    }

    protected void lookup_region_Region(LocationDs ds, Location e)
            throws Exception {
        Region x = null;
        try {
            x = ((IRegionService) getService(IRegionService.class))
                    .findByCodeAndCountry(ds.getClientId(), ds.getCountryId(),
                            ds.getRegionCode());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setRegion(x);
    }

    @Override
    public void entityToModel(Location e, LocationDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setRegionName(e.getRegionName());
        ds.setCityName(e.getCityName());
        ds.setAdress(e.getAdress());
        ds.setNotes(e.getNotes());
        ds.setActive(e.getActive());
        ds.setShipping(e.getForShipping());
        ds.setBilling(e.getForBilling());
        ds.setMailing(e.getForMailing());
        ds.setTargetId(e.getTargetId());
        ds.setTargetType(e.getTargetType());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
        ds.setCountryCode(((e.getCountry() != null)) ? e.getCountry().getCode()
                : null);
        ds.setRegionId(((e.getRegion() != null)) ? e.getRegion().getId() : null);
        ds.setRegionCode(((e.getRegion() != null)) ? e.getRegion().getCode()
                : null);
        ds.setCityId(((e.getCity() != null)) ? e.getCity().getId() : null);
    }

}
