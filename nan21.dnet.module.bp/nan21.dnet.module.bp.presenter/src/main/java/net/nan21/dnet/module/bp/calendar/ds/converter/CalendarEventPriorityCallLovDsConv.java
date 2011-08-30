/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityCallLovDs;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventPriority;

public class CalendarEventPriorityCallLovDsConv
        extends
        AbstractDsConverter<CalendarEventPriorityCallLovDs, CalendarEventPriority>
        implements
        IDsConverter<CalendarEventPriorityCallLovDs, CalendarEventPriority> {

    protected void modelToEntityAttributes(CalendarEventPriorityCallLovDs ds,
            CalendarEventPriority e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setEventType(ds.getEventType());
    }

    protected void modelToEntityReferences(CalendarEventPriorityCallLovDs ds,
            CalendarEventPriority e) throws Exception {
    }

    @Override
    public void entityToModel(CalendarEventPriority e,
            CalendarEventPriorityCallLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setEventType(e.getEventType());
    }

}
