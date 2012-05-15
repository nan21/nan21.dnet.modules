/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationHierarchy.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OrganizationHierarchyLovDs.fNAME) })
public class OrganizationHierarchyLovDs extends
        AbstractTypeLov<OrganizationHierarchy> {

    public OrganizationHierarchyLovDs() {
        super();
    }

    public OrganizationHierarchyLovDs(OrganizationHierarchy e) {
        super(e);
    }

}
