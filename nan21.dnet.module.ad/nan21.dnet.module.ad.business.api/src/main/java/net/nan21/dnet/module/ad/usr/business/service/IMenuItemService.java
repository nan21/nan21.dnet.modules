/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

public interface IMenuItemService extends IEntityService<MenuItem> {

    public MenuItem findByName(String name);

    public List<MenuItem> findByMenuItem(MenuItem menuItem);

    public List<MenuItem> findByMenuItemId(Long menuItemId);

    public List<MenuItem> findByMenu(Menu menu);

    public List<MenuItem> findByMenuId(Long menuId);

    public List<MenuItem> findByRoles(Role roles);

    public List<MenuItem> findByRolesId(Long rolesId);

}
