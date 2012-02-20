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
import net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDs;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;

public class CsvExportFieldDsConv extends
        AbstractDsConverter<CsvExportFieldDs, CsvExportField> implements
        IDsConverter<CsvExportFieldDs, CsvExportField> {

    @Override
    protected void modelToEntityReferences(CsvExportFieldDs ds,
            CsvExportField e, boolean isInsert) throws Exception {

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

    protected void lookup_csvExport_CsvExport(CsvExportFieldDs ds,
            CsvExportField e) throws Exception {
        if (ds.getCsvExport() != null && !ds.getCsvExport().equals("")) {
            CsvExport x = null;
            try {
                x = ((ICsvExportService) findEntityService(CsvExport.class))
                        .findByName(ds.getCsvExport());
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
