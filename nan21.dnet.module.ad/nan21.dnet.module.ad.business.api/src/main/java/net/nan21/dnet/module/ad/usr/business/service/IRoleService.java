/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

import net.nan21.dnet.module.ad.usr.domain.entity.Role;

public interface IRoleService extends IEntityService<Role> {

    public Role findByName(String name);

    public List<Role> findByUsers(User users);

    public List<Role> findByUsersId(Long usersId);

    public List<Role> findByAccessControls(AccessControl accessControls);

    public List<Role> findByAccessControlsId(Long accessControlsId);

    public List<Role> findByMenus(Menu menus);

    public List<Role> findByMenusId(Long menusId);

    public List<Role> findByMenuItems(MenuItem menuItems);

    public List<Role> findByMenuItemsId(Long menuItemsId);

}
