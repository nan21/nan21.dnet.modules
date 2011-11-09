/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDs;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;

public class CsvExportSortDsConv extends
        AbstractDsConverter<CsvExportSortDs, CsvExportSort> implements
        IDsConverter<CsvExportSortDs, CsvExportSort> {

    protected void modelToEntityAttributes(CsvExportSortDs ds, CsvExportSort e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
        e.setDsField(ds.getDsField());
        e.setDescend(ds.getDescend());
    }

    protected void modelToEntityReferences(CsvExportSortDs ds, CsvExportSort e)
            throws Exception {

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

    protected void lookup_csvExport_CsvExport(CsvExportSortDs ds,
            CsvExportSort e) throws Exception {
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
    public void entityToModel(CsvExportSort e, CsvExportSortDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
        ds.setDsField(e.getDsField());
        ds.setDescend(e.getDescend());
        ds.setCsvExportId(((e.getCsvExport() != null)) ? e.getCsvExport()
                .getId() : null);
        ds.setCsvExport(((e.getCsvExport() != null)) ? e.getCsvExport()
                .getName() : null);
        ds.setDataSource(((e.getCsvExport() != null)) ? e.getCsvExport()
                .getDataSource() : null);
    }

}
