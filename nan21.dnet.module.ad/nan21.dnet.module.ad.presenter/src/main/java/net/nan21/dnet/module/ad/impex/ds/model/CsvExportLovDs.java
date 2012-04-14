/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = CsvExport.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = CsvExportLovDs.fNAME) })
public class CsvExportLovDs extends AbstractTypeLov<CsvExport> {

    public CsvExportLovDs() {
        super();
    }

    public CsvExportLovDs(CsvExport e) {
        super(e);
    }

}
