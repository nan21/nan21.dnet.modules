/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

@Ds(entity = Organization.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OrganizationLovDs.fCODE) })
public class OrganizationLovDs extends AbstractTypeWithCodeLov<Organization> {

    public OrganizationLovDs() {
        super();
    }

    public OrganizationLovDs(Organization e) {
        super(e);
    }

}
