/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AbsenceCategory.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AbsenceCategoryLovDs.fNAME) })
public class AbsenceCategoryLovDs extends AbstractTypeLov<AbsenceCategory> {

    public AbsenceCategoryLovDs() {
        super();
    }

    public AbsenceCategoryLovDs(AbsenceCategory e) {
        super(e);
    }

}
