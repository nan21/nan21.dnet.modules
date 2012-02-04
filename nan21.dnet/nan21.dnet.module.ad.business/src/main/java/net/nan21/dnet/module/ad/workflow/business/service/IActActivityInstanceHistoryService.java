/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActActivityInstanceHistory;

public interface IActActivityInstanceHistoryService extends
        IEntityService<ActActivityInstanceHistory> {

    public List<ActActivityInstanceHistory> findByProcessDefinition(
            ActProcessDefinition processDefinition);

    public List<ActActivityInstanceHistory> findByProcessDefinitionId(
            String processDefinitionId);

}
