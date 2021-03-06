/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.opportunity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;

public interface IOpportunitySourceService extends
        IEntityService<OpportunitySource> {

    public OpportunitySource findByName(String name);

}
