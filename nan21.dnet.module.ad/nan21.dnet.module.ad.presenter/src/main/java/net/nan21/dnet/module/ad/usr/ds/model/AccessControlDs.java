/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

@Ds(entity = AccessControl.class, sort = { @SortField(field = AccessControlDs.fNAME) })
public class AccessControlDs extends AbstractTypeDs<AccessControl> {

    public AccessControlDs() {
        super();
    }

    public AccessControlDs(AccessControl e) {
        super(e);
    }

}
