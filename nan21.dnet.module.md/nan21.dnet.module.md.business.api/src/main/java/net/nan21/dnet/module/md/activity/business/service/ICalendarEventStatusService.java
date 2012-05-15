/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventStatus;

public interface ICalendarEventStatusService extends
        IEntityService<CalendarEventStatus> {

    public CalendarEventStatus findByType_and_name(String eventType, String name);

}
