/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

public interface IIssueTaskStatusService extends
        IEntityService<IssueTaskStatus> {

    public IssueTaskStatus findByName(String name);

}
