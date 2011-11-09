/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapLovDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

public class ExportMapLovDsConv extends
        AbstractDsConverter<ExportMapLovDs, ExportMap> implements
        IDsConverter<ExportMapLovDs, ExportMap> {

    protected void modelToEntityAttributes(ExportMapLovDs ds, ExportMap e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ExportMapLovDs ds, ExportMap e)
            throws Exception {
    }

    @Override
    public void entityToModel(ExportMap e, ExportMapLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
