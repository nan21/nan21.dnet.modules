/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.ICalendarService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.tx.ds.model.FiscalYearDs;
import net.nan21.dnet.module.bd.tx.domain.entity.FiscalYear;

public class FiscalYearDsConv extends
        AbstractDsConverter<FiscalYearDs, FiscalYear> implements
        IDsConverter<FiscalYearDs, FiscalYear> {

    @Override
    protected void modelToEntityReferences(FiscalYearDs ds, FiscalYear e,
            boolean isInsert) throws Exception {

        if (ds.getCalendarId() != null) {
            if (e.getCalendar() == null
                    || !e.getCalendar().getId().equals(ds.getCalendarId())) {
                e.setCalendar((Calendar) this.em.find(Calendar.class,
                        ds.getCalendarId()));
            }
        } else {
            this.lookup_calendar_Calendar(ds, e);
        }

    }

    protected void lookup_calendar_Calendar(FiscalYearDs ds, FiscalYear e)
            throws Exception {
        if (ds.getCalendar() != null && !ds.getCalendar().equals("")) {
            Calendar x = null;
            try {
                x = ((ICalendarService) findEntityService(Calendar.class))
                        .findByName(ds.getCalendar());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Calendar` reference:  `calendar` = "
                                + ds.getCalendar() + "  ");
            }
            e.setCalendar(x);

        } else {
            e.setCalendar(null);
        }
    }

}
