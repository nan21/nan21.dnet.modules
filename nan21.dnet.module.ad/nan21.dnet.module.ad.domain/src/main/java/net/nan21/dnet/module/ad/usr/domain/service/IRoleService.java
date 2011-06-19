/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

import net.nan21.dnet.module.ad.usr.domain.entity.Role;

public interface IRoleService extends IEntityService<Role> {

    public Role findByName(Long clientId, String name);

    public List<Role> findByUsers(User users);

    public List<Role> findByUsersId(Long usersId);

}
