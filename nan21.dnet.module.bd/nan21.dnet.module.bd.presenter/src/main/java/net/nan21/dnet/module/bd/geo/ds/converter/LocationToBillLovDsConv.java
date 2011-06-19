/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;

public class LocationToBillLovDsConv extends
        AbstractDsConverter<LocationToBillLovDs, Location> implements
        IDsConverter<LocationToBillLovDs, Location> {

    protected void modelToEntityAttributes(LocationToBillLovDs ds, Location e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setTargetId(ds.getTargetId());
        e.setTargetType(ds.getTargetType());
        e.setAsString(ds.getAsString());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(LocationToBillLovDs ds, Location e)
            throws Exception {
    }

    @Override
    public void entityToModel(Location e, LocationToBillLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setTargetId(e.getTargetId());
        ds.setTargetType(e.getTargetType());
        ds.setAsString(e.getAsString());
        ds.setActive(e.getActive());
    }

}
