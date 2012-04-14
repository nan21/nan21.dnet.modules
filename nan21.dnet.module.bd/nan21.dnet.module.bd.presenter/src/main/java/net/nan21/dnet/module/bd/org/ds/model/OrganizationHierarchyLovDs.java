/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithPeriodLov;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationHierarchy.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OrganizationHierarchyLovDs.fNAME) })
public class OrganizationHierarchyLovDs extends
        AbstractTypeWithPeriodLov<OrganizationHierarchy> {

    public OrganizationHierarchyLovDs() {
        super();
    }

    public OrganizationHierarchyLovDs(OrganizationHierarchy e) {
        super(e);
    }

}
