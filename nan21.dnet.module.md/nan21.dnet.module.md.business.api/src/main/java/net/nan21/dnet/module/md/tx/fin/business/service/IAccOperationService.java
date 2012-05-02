/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccOperation;

public interface IAccOperationService extends IEntityService<AccOperation> {

    public List<AccOperation> findByAccDocLine(AccDocLine accDocLine);

    public List<AccOperation> findByAccDocLineId(Long accDocLineId);

}
