/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

public interface IWfDefTransitionService extends
        IEntityService<WfDefTransition> {

    public List<WfDefTransition> findByProcess(WfDefProcess process);

    public List<WfDefTransition> findByProcessId(Long processId);

    public List<WfDefTransition> findBySource(WfDefNode source);

    public List<WfDefTransition> findBySourceId(Long sourceId);

    public List<WfDefTransition> findByTarget(WfDefNode target);

    public List<WfDefTransition> findByTargetId(Long targetId);

}
