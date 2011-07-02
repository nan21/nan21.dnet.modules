/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeType;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public interface IWfDefNodeService extends IEntityService<WfDefNode> {

    public WfDefNode findByName(Long clientId, String name);

    public List<WfDefNode> findByProcess(WfDefProcess process);

    public List<WfDefNode> findByProcessId(Long processId);

    public List<WfDefNode> findByTaskType(WfDefNodeType taskType);

    public List<WfDefNode> findByTaskTypeId(Long taskTypeId);

}
