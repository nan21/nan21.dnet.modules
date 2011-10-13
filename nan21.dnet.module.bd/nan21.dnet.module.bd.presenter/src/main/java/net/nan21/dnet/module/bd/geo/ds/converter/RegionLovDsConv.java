/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

public class RegionLovDsConv extends AbstractDsConverter<RegionLovDs, Region>
        implements IDsConverter<RegionLovDs, Region> {

    protected void modelToEntityAttributes(RegionLovDs ds, Region e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(RegionLovDs ds, Region e)
            throws Exception {
    }

    @Override
    public void entityToModel(Region e, RegionLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setCountryId(((e.getCountry() != null)) ? e.getCountry().getId()
                : null);
    }

}
