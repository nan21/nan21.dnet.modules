/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomLovDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomLovDsConv extends AbstractDsConverter<UomLovDs, Uom> implements
        IDsConverter<UomLovDs, Uom> {

    protected void modelToEntityAttributes(UomLovDs ds, Uom e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomLovDs ds, Uom e) throws Exception {
    }

    @Override
    public void entityToModel(Uom e, UomLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
