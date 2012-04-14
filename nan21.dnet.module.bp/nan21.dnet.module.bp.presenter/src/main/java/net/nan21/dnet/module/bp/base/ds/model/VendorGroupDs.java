/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;

import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = VendorGroup.class, sort = { @SortField(field = VendorGroupDs.fNAME) })
public class VendorGroupDs extends AbstractTypeWithCodeDs<VendorGroup> {

    public VendorGroupDs() {
        super();
    }

    public VendorGroupDs(VendorGroup e) {
        super(e);
    }

}
