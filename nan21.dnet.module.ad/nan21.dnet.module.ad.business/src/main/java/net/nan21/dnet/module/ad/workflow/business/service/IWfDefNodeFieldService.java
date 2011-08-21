/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;

public interface IWfDefNodeFieldService extends IEntityService<WfDefNodeField> {

    public WfDefNodeField findByName(Long clientId, String name);

    public List<WfDefNodeField> findByNode(WfDefNode node);

    public List<WfDefNodeField> findByNodeId(Long nodeId);

}
