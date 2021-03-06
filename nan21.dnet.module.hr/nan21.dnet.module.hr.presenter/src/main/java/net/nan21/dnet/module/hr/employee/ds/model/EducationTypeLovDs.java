/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;

@Ds(entity = EducationType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = EducationTypeLovDs.fNAME) })
public class EducationTypeLovDs extends AbstractTypeLov<EducationType> {

    public EducationTypeLovDs() {
        super();
    }

    public EducationTypeLovDs(EducationType e) {
        super(e);
    }

}
