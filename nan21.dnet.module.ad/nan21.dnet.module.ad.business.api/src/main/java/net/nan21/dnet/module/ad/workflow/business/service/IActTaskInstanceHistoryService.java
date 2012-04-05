/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

public interface IActTaskInstanceHistoryService extends
        IEntityService<ActTaskInstanceHistory> {

    public List<ActTaskInstanceHistory> findByProcessDefinition(
            ActProcessDefinition processDefinition);

    public List<ActTaskInstanceHistory> findByProcessDefinitionId(
            String processDefinitionId);

    public List<ActTaskInstanceHistory> findByParent(
            ActTaskInstanceHistory parent);

    public List<ActTaskInstanceHistory> findByParentId(String parentId);

}
