/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = VendorGroup.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = VendorGroupLovDs.fCODE) })
public class VendorGroupLovDs extends AbstractTypeWithCodeLov<VendorGroup> {

    public VendorGroupLovDs() {
        super();
    }

    public VendorGroupLovDs(VendorGroup e) {
        super(e);
    }

}
