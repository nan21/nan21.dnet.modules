/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IMenuItemService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

public class MenuItemService extends AbstractEntityService<MenuItem> implements
        IMenuItemService {

    public MenuItemService() {
        super();
    }

    public MenuItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<MenuItem> getEntityClass() {
        return MenuItem.class;
    }

    public MenuItem findByName(String name) {
        return (MenuItem) this.em.createNamedQuery(MenuItem.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<MenuItem> findByMenuItem(MenuItem menuItem) {
        return this.findByMenuItemId(menuItem.getId());
    }

    public List<MenuItem> findByMenuItemId(Long menuItemId) {
        return (List<MenuItem>) this.em
                .createQuery(
                        "select e from MenuItem e where e.clientId = :pClientId and e.menuItem.id = :pMenuItemId",
                        MenuItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pMenuItemId", menuItemId).getResultList();
    }

    public List<MenuItem> findByMenu(Menu menu) {
        return this.findByMenuId(menu.getId());
    }

    public List<MenuItem> findByMenuId(Long menuId) {
        return (List<MenuItem>) this.em
                .createQuery(
                        "select e from MenuItem e where e.clientId = :pClientId and e.menu.id = :pMenuId",
                        MenuItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pMenuId", menuId).getResultList();
    }

    public List<MenuItem> findByRoles(Role roles) {
        return this.findByRolesId(roles.getId());
    }

    public List<MenuItem> findByRolesId(Long rolesId) {
        return (List<MenuItem>) this.em
                .createQuery(
                        "select distinct e from MenuItem e , IN (e.roles) c where e.clientId = :pClientId and c.id = :pRolesId",
                        MenuItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pRolesId", rolesId).getResultList();
    }

}
