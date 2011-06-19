/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

import net.nan21.dnet.module.ad.usr.domain.entity.User;

public interface IUserService extends IEntityService<User> {

    public User findByCode(Long clientId, String code);

    public List<User> findByRoles(Role roles);

    public List<User> findByRolesId(Long rolesId);

    public List<User> findByGroups(UserGroup groups);

    public List<User> findByGroupsId(Long groupsId);

}
