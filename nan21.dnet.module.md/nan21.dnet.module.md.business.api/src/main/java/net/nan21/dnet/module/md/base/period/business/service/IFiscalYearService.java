/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Calendar;

import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

public interface IFiscalYearService extends IEntityService<FiscalYear> {

    public FiscalYear findByCode(String code);

    public FiscalYear findByName(String name);

    public List<FiscalYear> findByCalendar(Calendar calendar);

    public List<FiscalYear> findByCalendarId(Long calendarId);

}
