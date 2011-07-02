/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

public interface IAbsenceTypeService extends IEntityService<AbsenceType> {

    public AbsenceType findByName(Long clientId, String name);

    public List<AbsenceType> findByCategory(AbsenceCategory category);

    public List<AbsenceType> findByCategoryId(Long categoryId);

}
