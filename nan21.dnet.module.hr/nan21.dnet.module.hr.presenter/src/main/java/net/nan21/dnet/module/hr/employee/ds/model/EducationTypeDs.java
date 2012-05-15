/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = EducationType.class, sort = { @SortField(field = EducationTypeDs.fNAME) })
public class EducationTypeDs extends AbstractTypeDs<EducationType> {

    public EducationTypeDs() {
        super();
    }

    public EducationTypeDs(EducationType e) {
        super(e);
    }

}
