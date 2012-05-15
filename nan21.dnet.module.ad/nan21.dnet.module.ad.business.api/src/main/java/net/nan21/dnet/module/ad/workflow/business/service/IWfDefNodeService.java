/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;

public interface IWfDefNodeService extends IEntityService<WfDefNode> {

    public WfDefNode findByName(String name);

    public List<WfDefNode> findByProcess(WfDefProcess process);

    public List<WfDefNode> findByProcessId(Long processId);

    public List<WfDefNode> findByFields(WfDefNodeField fields);

    public List<WfDefNode> findByFieldsId(Long fieldsId);

}
