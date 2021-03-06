/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

@Ds(entity = BusinessPartner.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = BusinessPartnerLovDs.fCODE) })
public class BusinessPartnerLovDs extends
        AbstractTypeWithCodeLov<BusinessPartner> {

    public BusinessPartnerLovDs() {
        super();
    }

    public BusinessPartnerLovDs(BusinessPartner e) {
        super(e);
    }

}
