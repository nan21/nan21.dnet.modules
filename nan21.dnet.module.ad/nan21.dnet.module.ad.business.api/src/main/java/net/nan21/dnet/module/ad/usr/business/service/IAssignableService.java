/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;

public interface IAssignableService extends IEntityService<Assignable> {

    public Assignable findByName(String name);

    public List<Assignable> findByAssignableType(AssignableType assignableType);

    public List<Assignable> findByAssignableTypeId(Long assignableTypeId);

}
