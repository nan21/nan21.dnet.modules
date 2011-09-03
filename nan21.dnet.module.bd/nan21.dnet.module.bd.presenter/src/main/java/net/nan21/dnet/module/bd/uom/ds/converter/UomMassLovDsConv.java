/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomMassLovDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public class UomMassLovDsConv extends AbstractDsConverter<UomMassLovDs, Uom>
        implements IDsConverter<UomMassLovDs, Uom> {

    protected void modelToEntityAttributes(UomMassLovDs ds, Uom e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setCode(ds.getCode());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomMassLovDs ds, Uom e)
            throws Exception {
    }

    @Override
    public void entityToModel(Uom e, UomMassLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCode(e.getCode());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
