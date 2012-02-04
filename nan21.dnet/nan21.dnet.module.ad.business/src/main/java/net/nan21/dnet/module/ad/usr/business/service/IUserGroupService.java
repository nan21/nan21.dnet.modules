/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

public interface IUserGroupService extends IEntityService<UserGroup> {

    public UserGroup findByName(Long clientId, String name);

    public List<UserGroup> findByUsers(User users);

    public List<UserGroup> findByUsersId(Long usersId);

}
