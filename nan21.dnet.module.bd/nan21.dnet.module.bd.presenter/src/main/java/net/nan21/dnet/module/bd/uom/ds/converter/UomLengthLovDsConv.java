/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomLengthLovDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomLengthLovDsConv extends
        AbstractDsConverter<UomLengthLovDs, Uom> implements
        IDsConverter<UomLengthLovDs, Uom> {

    protected void modelToEntityAttributes(UomLengthLovDs ds, Uom e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomLengthLovDs ds, Uom e)
            throws Exception {
    }

    @Override
    public void entityToModel(Uom e, UomLengthLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
