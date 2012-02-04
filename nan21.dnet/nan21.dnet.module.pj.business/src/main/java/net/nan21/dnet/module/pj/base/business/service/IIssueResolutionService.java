/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;

public interface IIssueResolutionService extends
        IEntityService<IssueResolution> {

    public IssueResolution findByName(Long clientId, String name);

}
