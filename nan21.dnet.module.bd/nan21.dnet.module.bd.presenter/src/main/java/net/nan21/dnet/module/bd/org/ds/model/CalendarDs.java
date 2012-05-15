/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;

import net.nan21.dnet.module.bd.org.domain.entity.Calendar;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Calendar.class, sort = { @SortField(field = CalendarDs.fNAME) })
public class CalendarDs extends AbstractTypeDs<Calendar> {

    public CalendarDs() {
        super();
    }

    public CalendarDs(Calendar e) {
        super(e);
    }

}
