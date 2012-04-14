/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithPeriodDs;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationHierarchy.class, sort = { @SortField(field = OrganizationHierarchyDs.fNAME) })
public class OrganizationHierarchyDs extends
        AbstractTypeWithPeriodDs<OrganizationHierarchy> {

    public OrganizationHierarchyDs() {
        super();
    }

    public OrganizationHierarchyDs(OrganizationHierarchy e) {
        super(e);
    }

}
