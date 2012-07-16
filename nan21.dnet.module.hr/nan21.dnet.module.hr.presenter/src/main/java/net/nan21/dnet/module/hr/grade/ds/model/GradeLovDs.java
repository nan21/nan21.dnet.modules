/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

@Ds(entity = Grade.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = GradeLovDs.fCODE) })
public class GradeLovDs extends AbstractTypeWithCodeLov<Grade> {

    public GradeLovDs() {
        super();
    }

    public GradeLovDs(Grade e) {
        super(e);
    }

}
