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
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

import net.nan21.dnet.module.md.tx.acc.domain.entity.AccOperation;

public interface IAccOperationService extends IEntityService<AccOperation> {

    public List<AccOperation> findByOrg(Organization org);

    public List<AccOperation> findByOrgId(Long orgId);

    public List<AccOperation> findByAccSchema(AccSchema accSchema);

    public List<AccOperation> findByAccSchemaId(Long accSchemaId);

    public List<AccOperation> findByPeriod(FiscalPeriod period);

    public List<AccOperation> findByPeriodId(Long periodId);

    public List<AccOperation> findByAccDoc(AccDoc accDoc);

    public List<AccOperation> findByAccDocId(Long accDocId);

    public List<AccOperation> findByAccDocLine(AccDocLine accDocLine);

    public List<AccOperation> findByAccDocLineId(Long accDocLineId);

}
