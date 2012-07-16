/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

@Ds(entity = ImportJob.class, sort = { @SortField(field = ImportJobDs.fNAME) })
public class ImportJobDs extends AbstractTypeDs<ImportJob> {

    public ImportJobDs() {
        super();
    }

    public ImportJobDs(ImportJob e) {
        super(e);
    }

}
