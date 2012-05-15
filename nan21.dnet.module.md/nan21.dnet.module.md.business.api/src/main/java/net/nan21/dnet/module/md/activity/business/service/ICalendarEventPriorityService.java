/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.activity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.activity.domain.entity.CalendarEventPriority;

public interface ICalendarEventPriorityService extends
        IEntityService<CalendarEventPriority> {

    public CalendarEventPriority findByType_and_name(String eventType,
            String name);

}
