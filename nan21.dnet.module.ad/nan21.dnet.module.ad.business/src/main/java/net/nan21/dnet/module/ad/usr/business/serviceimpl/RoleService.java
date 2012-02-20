/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IRoleService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

public class RoleService extends AbstractEntityService<Role> implements
        IRoleService {

    public RoleService() {
        super();
    }

    public RoleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    public Role findByName(String name) {
        return (Role) this.em.createNamedQuery(Role.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<Role> findByUsers(User users) {
        return this.findByUsersId(users.getId());
    }

    public List<Role> findByUsersId(Long usersId) {
        return (List<Role>) this.em
                .createQuery(
                        "select distinct e from Role e , IN (e.users) c where e.clientId = :pClientId and c.id = :pUsersId",
                        Role.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUsersId", usersId).getResultList();
    }

    public List<Role> findByAccessControls(AccessControl accessControls) {
        return this.findByAccessControlsId(accessControls.getId());
    }

    public List<Role> findByAccessControlsId(Long accessControlsId) {
        return (List<Role>) this.em
                .createQuery(
                        "select distinct e from Role e , IN (e.accessControls) c where e.clientId = :pClientId and c.id = :pAccessControlsId",
                        Role.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAccessControlsId", accessControlsId)
                .getResultList();
    }

    public List<Role> findByMenus(Menu menus) {
        return this.findByMenusId(menus.getId());
    }

    public List<Role> findByMenusId(Long menusId) {
        return (List<Role>) this.em
                .createQuery(
                        "select distinct e from Role e , IN (e.menus) c where e.clientId = :pClientId and c.id = :pMenusId",
                        Role.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pMenusId", menusId).getResultList();
    }

    public List<Role> findByMenuItems(MenuItem menuItems) {
        return this.findByMenuItemsId(menuItems.getId());
    }

    public List<Role> findByMenuItemsId(Long menuItemsId) {
        return (List<Role>) this.em
                .createQuery(
                        "select distinct e from Role e , IN (e.menuItems) c where e.clientId = :pClientId and c.id = :pMenuItemsId",
                        Role.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pMenuItemsId", menuItemsId).getResultList();
    }

}
