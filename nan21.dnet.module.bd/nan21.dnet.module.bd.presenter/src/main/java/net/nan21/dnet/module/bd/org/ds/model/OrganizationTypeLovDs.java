/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = OrganizationTypeLovDs.fNAME) })
public class OrganizationTypeLovDs extends AbstractTypeLov<OrganizationType> {

    public OrganizationTypeLovDs() {
        super();
    }

    public OrganizationTypeLovDs(OrganizationType e) {
        super(e);
    }

}
