/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ImportJob.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ImportJobLovDs.fNAME) })
public class ImportJobLovDs extends AbstractTypeLov<ImportJob> {

    public ImportJobLovDs() {
        super();
    }

    public ImportJobLovDs(ImportJob e) {
        super(e);
    }

}
