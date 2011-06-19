/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobLovDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

public class ImportJobLovDsConv extends
        AbstractDsConverter<ImportJobLovDs, ImportJob> implements
        IDsConverter<ImportJobLovDs, ImportJob> {

    protected void modelToEntityAttributes(ImportJobLovDs ds, ImportJob e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ImportJobLovDs ds, ImportJob e)
            throws Exception {
    }

    @Override
    public void entityToModel(ImportJob e, ImportJobLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
