/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

@Ds(entity = UserGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = UserGroupLovDs.fNAME) })
public class UserGroupLovDs extends AbstractTypeLov<UserGroup> {

    public UserGroupLovDs() {
        super();
    }

    public UserGroupLovDs(UserGroup e) {
        super(e);
    }

}
