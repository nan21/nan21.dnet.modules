/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;

public interface IActIdentityGroupService extends
        IEntityService<ActIdentityGroup> {

    public List<ActIdentityGroup> findByUsers(ActIdentityUser users);

    public List<ActIdentityGroup> findByUsersId(String usersId);

}
