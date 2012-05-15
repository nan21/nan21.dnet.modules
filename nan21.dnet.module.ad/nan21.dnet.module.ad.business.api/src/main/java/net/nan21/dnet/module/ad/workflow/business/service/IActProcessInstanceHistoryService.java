/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;

public interface IActProcessInstanceHistoryService extends
        IEntityService<ActProcessInstanceHistory> {

    public List<ActProcessInstanceHistory> findByProcessDefinition(
            ActProcessDefinition processDefinition);

    public List<ActProcessInstanceHistory> findByProcessDefinitionId(
            String processDefinitionId);

}
