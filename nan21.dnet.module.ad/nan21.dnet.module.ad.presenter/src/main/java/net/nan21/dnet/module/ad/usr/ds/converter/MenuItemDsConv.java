/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IMenuItemService;
import net.nan21.dnet.module.ad.usr.business.service.IMenuService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.MenuItemDs;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;

public class MenuItemDsConv extends AbstractDsConverter<MenuItemDs, MenuItem>
        implements IDsConverter<MenuItemDs, MenuItem> {

    @Override
    protected void modelToEntityReferences(MenuItemDs ds, MenuItem e,
            boolean isInsert) throws Exception {

        if (ds.getMenuItemId() != null) {
            if (e.getMenuItem() == null
                    || !e.getMenuItem().getId().equals(ds.getMenuItemId())) {
                e.setMenuItem((MenuItem) this.em.find(MenuItem.class,
                        ds.getMenuItemId()));
            }
        } else {
            this.lookup_menuItem_MenuItem(ds, e);
        }

        if (ds.getMenuId() != null) {
            if (e.getMenu() == null
                    || !e.getMenu().getId().equals(ds.getMenuId())) {
                e.setMenu((Menu) this.em.find(Menu.class, ds.getMenuId()));
            }
        } else {
            this.lookup_menu_Menu(ds, e);
        }

    }

    protected void lookup_menuItem_MenuItem(MenuItemDs ds, MenuItem e)
            throws Exception {
        if (ds.getMenuItem() != null && !ds.getMenuItem().equals("")) {
            MenuItem x = null;
            try {
                x = ((IMenuItemService) findEntityService(MenuItem.class))
                        .findByName(ds.getMenuItem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `MenuItem` reference:  `menuItem` = "
                                + ds.getMenuItem() + "  ");
            }
            e.setMenuItem(x);

        } else {
            e.setMenuItem(null);
        }
    }

    protected void lookup_menu_Menu(MenuItemDs ds, MenuItem e) throws Exception {
        if (ds.getMenu() != null && !ds.getMenu().equals("")) {
            Menu x = null;
            try {
                x = ((IMenuService) findEntityService(Menu.class))
                        .findByName(ds.getMenu());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Menu` reference:  `menu` = "
                                + ds.getMenu() + "  ");
            }
            e.setMenu(x);

        } else {
            e.setMenu(null);
        }
    }

}
