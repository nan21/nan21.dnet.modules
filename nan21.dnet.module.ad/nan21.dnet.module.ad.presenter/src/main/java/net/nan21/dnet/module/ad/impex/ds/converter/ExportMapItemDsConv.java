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

    protected void modelToEntityAttributes(ExportMapItemDs ds, ExportMapItem e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
        e.setFileName(ds.getFileName());
        e.setActive(ds.getActive());
    }

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
                x = ((IExportMapService) getService(IExportMapService.class))
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
                x = ((ICsvExportService) getService(ICsvExportService.class))
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

    @Override
    public void entityToModel(ExportMapItem e, ExportMapItemDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
        ds.setFileName(e.getFileName());
        ds.setActive(e.getActive());
        ds.setExportMapId(((e.getExportMap() != null)) ? e.getExportMap()
                .getId() : null);
        ds.setExportMap(((e.getExportMap() != null)) ? e.getExportMap()
                .getName() : null);
        ds.setCsvExportId(((e.getCsvExport() != null)) ? e.getCsvExport()
                .getId() : null);
        ds.setCsvExport(((e.getCsvExport() != null)) ? e.getCsvExport()
                .getName() : null);
    }

}
