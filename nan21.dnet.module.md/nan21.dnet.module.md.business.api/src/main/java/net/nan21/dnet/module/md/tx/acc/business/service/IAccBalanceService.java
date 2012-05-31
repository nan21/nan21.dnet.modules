/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;

import net.nan21.dnet.module.md.tx.acc.domain.entity.AccBalance;

public interface IAccBalanceService extends IEntityService<AccBalance> {

    public List<AccBalance> findByOrg(Organization org);

    public List<AccBalance> findByOrgId(Long orgId);

    public List<AccBalance> findByAccSchema(AccSchema accSchema);

    public List<AccBalance> findByAccSchemaId(Long accSchemaId);

    public List<AccBalance> findByPeriod(FiscalPeriod period);

    public List<AccBalance> findByPeriodId(Long periodId);

}
