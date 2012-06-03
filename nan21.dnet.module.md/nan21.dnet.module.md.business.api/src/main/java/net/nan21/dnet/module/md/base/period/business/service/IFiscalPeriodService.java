/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import java.util.Date;

public interface IFiscalPeriodService extends IEntityService<FiscalPeriod> {

    public FiscalPeriod findByCode(String code);

    public FiscalPeriod findByName(String name);

    public List<FiscalPeriod> findByYear(FiscalYear year);

    public List<FiscalPeriod> findByYearId(Long yearId);

    public FiscalPeriod getPostingPeriod(Date date, Organization org);

}
