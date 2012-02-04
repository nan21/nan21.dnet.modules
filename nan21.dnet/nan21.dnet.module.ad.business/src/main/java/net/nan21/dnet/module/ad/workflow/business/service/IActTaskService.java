/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

public interface IActTaskService extends IEntityService<ActTask> {

    public List<ActTask> findByProcessDefinition(
            ActProcessDefinition processDefinition);

    public List<ActTask> findByProcessDefinitionId(String processDefinitionId);

    public List<ActTask> findByParent(ActTask parent);

    public List<ActTask> findByParentId(String parentId);

}
