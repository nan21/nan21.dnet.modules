/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.calendar.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusDs;
import net.nan21.dnet.module.bp.calendar.domain.entity.CalendarEventStatus;

public class CalendarEventStatusDsConv extends
        AbstractDsConverter<CalendarEventStatusDs, CalendarEventStatus>
        implements IDsConverter<CalendarEventStatusDs, CalendarEventStatus> {

    protected void modelToEntityAttributes(CalendarEventStatusDs ds,
            CalendarEventStatus e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setEventType(ds.getEventType());
    }

    protected void modelToEntityReferences(CalendarEventStatusDs ds,
            CalendarEventStatus e) throws Exception {
    }

    @Override
    public void entityToModel(CalendarEventStatus e, CalendarEventStatusDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setEventType(e.getEventType());
    }

}
