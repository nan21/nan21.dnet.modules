/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;

public interface IActExecutionService extends IEntityService<ActExecution> {

    public List<ActExecution> findByParent(ActExecution parent);

    public List<ActExecution> findByParentId(String parentId);

    public List<ActExecution> findByProcessDefinition(
            ActProcessDefinition processDefinition);

    public List<ActExecution> findByProcessDefinitionId(
            String processDefinitionId);

}
