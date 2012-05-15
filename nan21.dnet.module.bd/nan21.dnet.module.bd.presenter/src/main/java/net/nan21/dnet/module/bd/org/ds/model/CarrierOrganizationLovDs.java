/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Organization.class, jpqlWhere = " e.type.carrier = true ", sort = { @SortField(field = CarrierOrganizationLovDs.fCODE) })
public class CarrierOrganizationLovDs extends
        AbstractTypeWithCodeLov<Organization> {

    public static final String fCARRIER = "carrier";

    @DsField(join = "left", path = "type.carrier")
    private Boolean carrier;

    public CarrierOrganizationLovDs() {
        super();
    }

    public CarrierOrganizationLovDs(Organization e) {
        super(e);
    }

    public Boolean getCarrier() {
        return this.carrier;
    }

    public void setCarrier(Boolean carrier) {
        this.carrier = carrier;
    }

}
