/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

public interface IActProcessDefinitionService extends
        IEntityService<ActProcessDefinition> {

    public List<ActProcessDefinition> findByDeployment(ActDeployment deployment);

    public List<ActProcessDefinition> findByDeploymentId(String deploymentId);

}
