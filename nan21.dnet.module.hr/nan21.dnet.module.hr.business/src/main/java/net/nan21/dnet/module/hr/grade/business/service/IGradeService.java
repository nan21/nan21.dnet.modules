/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

public interface IGradeService extends IEntityService<Grade> {

    public Grade findByCode(String code);

    public Grade findByName(String name);

}
