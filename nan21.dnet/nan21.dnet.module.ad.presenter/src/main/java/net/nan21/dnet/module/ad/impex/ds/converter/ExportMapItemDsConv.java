/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

public class ExportMapItemDsConv extends
        AbstractDsConverter<ExportMapItemDs, ExportMapItem> implements
        IDsConverter<ExportMapItemDs, ExportMapItem> {

    protected void modelToEntityReferences(ExportMapItemDs ds, ExportMapItem e)
            throws Exception {
        if (ds.getExportMapId() != null) {
            if (e.getExportMap() == null
                    || !e.getExportMap().getId().equals(ds.getExportMapId())) {
                e.setExportMap((ExportMap) this.em.find(ExportMap.class,
                        ds.getExportMapId()));
            }
        } else {
            this.lookup_exportMap_ExportMap(ds, e);
        }
        if (ds.getCsvExportId() != null) {
            if (e.getCsvExport() == null
                    || !e.getCsvExport().getId().equals(ds.getCsvExportId())) {
                e.setCsvExport((CsvExport) this.em.find(CsvExport.class,
                        ds.getCsvExportId()));
            }
        } else {
            this.lookup_csvExport_CsvExport(ds, e);
        }
    }

    protected void lookup_exportMap_ExportMap(ExportMapItemDs ds,
            ExportMapItem e) throws Exception {
        if (ds.getExportMap() != null && !ds.getExportMap().equals("")) {
            ExportMap x = null;
            try {
                x = ((IExportMapService) findEntityService(ExportMap.class))
                        .findByName(ds.getClientId(), ds.getExportMap());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ExportMap` reference:  `exportMap` = "
                                + ds.getExportMap() + "  ");
            }
            e.setExportMap(x);

        } else {
            e.setExportMap(null);
        }
    }

    protected void lookup_csvExport_CsvExport(ExportMapItemDs ds,
            ExportMapItem e) throws Exception {
        if (ds.getCsvExport() != null && !ds.getCsvExport().equals("")) {
            CsvExport x = null;
            try {
                x = ((ICsvExportService) findEntityService(CsvExport.class))
                        .findByName(ds.getClientId(), ds.getCsvExport());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CsvExport` reference:  `csvExport` = "
                                + ds.getCsvExport() + "  ");
            }
            e.setCsvExport(x);

        } else {
            e.setCsvExport(null);
        }
    }

}
