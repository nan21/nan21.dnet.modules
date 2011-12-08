/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.inventory.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryDs;
import net.nan21.dnet.module.mm.inventory.domain.entity.SubInventory;

public class SubInventoryDsConv extends
        AbstractDsConverter<SubInventoryDs, SubInventory> implements
        IDsConverter<SubInventoryDs, SubInventory> {

    protected void modelToEntityReferences(SubInventoryDs ds, SubInventory e)
            throws Exception {
        if (ds.getInventoryId() != null) {
            if (e.getInventory() == null
                    || !e.getInventory().getId().equals(ds.getInventoryId())) {
                e.setInventory((Organization) this.em.find(Organization.class,
                        ds.getInventoryId()));
            }
        } else {
            this.lookup_inventory_Organization(ds, e);
        }
    }

    protected void lookup_inventory_Organization(SubInventoryDs ds,
            SubInventory e) throws Exception {
        if (ds.getInventory() != null && !ds.getInventory().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getClientId(), ds.getInventory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `inventory` = "
                                + ds.getInventory() + "  ");
            }
            e.setInventory(x);

        } else {
            e.setInventory(null);
        }
    }

}
