/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequest;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceRequestItem;

public interface IAbsenceRequestItemService extends
        IEntityService<AbsenceRequestItem> {

    public List<AbsenceRequestItem> findByAbsenceRequest(
            AbsenceRequest absenceRequest);

    public List<AbsenceRequestItem> findByAbsenceRequestId(Long absenceRequestId);

}
