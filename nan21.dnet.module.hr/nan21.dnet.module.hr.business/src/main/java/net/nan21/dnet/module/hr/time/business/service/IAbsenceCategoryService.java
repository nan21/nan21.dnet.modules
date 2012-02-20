/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.time.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

public interface IAbsenceCategoryService extends
        IEntityService<AbsenceCategory> {

    public AbsenceCategory findByName(String name);

}
