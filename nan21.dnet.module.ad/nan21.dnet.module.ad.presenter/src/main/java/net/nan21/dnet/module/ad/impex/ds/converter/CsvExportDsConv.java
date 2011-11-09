/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.CsvExportDs;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

public class CsvExportDsConv extends
        AbstractDsConverter<CsvExportDs, CsvExport> implements
        IDsConverter<CsvExportDs, CsvExport> {

    protected void modelToEntityAttributes(CsvExportDs ds, CsvExport e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setDataSource(ds.getDataSource());
    }

    protected void modelToEntityReferences(CsvExportDs ds, CsvExport e)
            throws Exception {
    }

    @Override
    public void entityToModel(CsvExport e, CsvExportDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setDataSource(e.getDataSource());
    }

}
