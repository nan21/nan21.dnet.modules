/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AbsenceCategory.class, sort = { @SortField(field = AbsenceCategoryDs.fNAME) })
public class AbsenceCategoryDs extends AbstractTypeDs<AbsenceCategory> {

    public AbsenceCategoryDs() {
        super();
    }

    public AbsenceCategoryDs(AbsenceCategory e) {
        super(e);
    }

}
