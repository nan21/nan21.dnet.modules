/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDs;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;

public class VendorGroupLovDsConv extends
        AbstractDsConverter<VendorGroupLovDs, VendorGroup> implements
        IDsConverter<VendorGroupLovDs, VendorGroup> {

    protected void modelToEntityAttributes(VendorGroupLovDs ds, VendorGroup e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(VendorGroupLovDs ds, VendorGroup e)
            throws Exception {
    }

    @Override
    public void entityToModel(VendorGroup e, VendorGroupLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
