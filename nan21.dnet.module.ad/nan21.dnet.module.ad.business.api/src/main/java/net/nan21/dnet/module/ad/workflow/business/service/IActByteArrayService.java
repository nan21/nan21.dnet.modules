/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;

public interface IActByteArrayService extends IEntityService<ActByteArray> {

    public List<ActByteArray> findByDeployment(ActDeployment deployment);

    public List<ActByteArray> findByDeploymentId(String deploymentId);

}
