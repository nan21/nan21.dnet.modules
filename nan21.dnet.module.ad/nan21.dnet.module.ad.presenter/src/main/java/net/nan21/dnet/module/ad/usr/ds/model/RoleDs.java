/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Role.class, sort = { @SortField(field = RoleDs.fNAME) })
public class RoleDs extends AbstractTypeDs<Role> {

    public RoleDs() {
        super();
    }

    public RoleDs(Role e) {
        super(e);
    }

}
