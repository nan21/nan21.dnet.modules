/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = LicenseType.class, sort = { @SortField(field = LicenseTypeDs.fNAME) })
public class LicenseTypeDs extends AbstractTypeDs<LicenseType> {

    public LicenseTypeDs() {
        super();
    }

    public LicenseTypeDs(LicenseType e) {
        super(e);
    }

}
