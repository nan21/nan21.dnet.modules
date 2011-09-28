/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.BusinessObject;

import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

public interface IAssignableTypeService extends IEntityService<AssignableType> {

    public AssignableType findByName(Long clientId, String name);

    public List<AssignableType> findByBusinessObject(
            BusinessObject businessObject);

    public List<AssignableType> findByBusinessObjectId(Long businessObjectId);

}
