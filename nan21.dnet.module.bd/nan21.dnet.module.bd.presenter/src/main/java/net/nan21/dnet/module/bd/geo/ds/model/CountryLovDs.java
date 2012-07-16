/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

@Ds(entity = Country.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CountryLovDs.fCODE) })
public class CountryLovDs extends AbstractTypeWithCodeLov<Country> {

    public CountryLovDs() {
        super();
    }

    public CountryLovDs(Country e) {
        super(e);
    }

}
