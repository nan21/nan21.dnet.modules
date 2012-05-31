/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.period.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;

import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriodStatus;

public interface IFiscalPeriodStatusService extends
        IEntityService<FiscalPeriodStatus> {

    public FiscalPeriodStatus findByOrg_period(Organization org,
            FiscalPeriod period);

    public FiscalPeriodStatus findByOrg_period(Long orgId, Long periodId);

    public List<FiscalPeriodStatus> findByPeriod(FiscalPeriod period);

    public List<FiscalPeriodStatus> findByPeriodId(Long periodId);

    public List<FiscalPeriodStatus> findByOrg(Organization org);

    public List<FiscalPeriodStatus> findByOrgId(Long orgId);

}
