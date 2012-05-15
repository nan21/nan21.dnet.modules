/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.tx.domain.entity.FiscalYear;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = FiscalYear.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = FiscalYearLovDs.fCODE) })
public class FiscalYearLovDs extends AbstractTypeWithCodeLov<FiscalYear> {

    public FiscalYearLovDs() {
        super();
    }

    public FiscalYearLovDs(FiscalYear e) {
        super(e);
    }

}
