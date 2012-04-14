/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.geo.domain.entity.Region;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Region.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = RegionLovDs.fCODE) })
public class RegionLovDs extends AbstractTypeWithCodeLov<Region> {

    public static final String fCOUNTRYID = "countryId";

    @DsField(join = "left", path = "country.id")
    private Long countryId;

    public RegionLovDs() {
        super();
    }

    public RegionLovDs(Region e) {
        super(e);
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

}
