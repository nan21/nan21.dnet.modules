/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Role.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = RolesOfUserLovDs.fNAME) })
public class RolesOfUserLovDs extends AbstractTypeLov<Role> {

    public RolesOfUserLovDs() {
        super();
    }

    public RolesOfUserLovDs(Role e) {
        super(e);
    }

}
