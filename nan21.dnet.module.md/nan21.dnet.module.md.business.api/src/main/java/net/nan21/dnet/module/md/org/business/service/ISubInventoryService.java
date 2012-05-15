/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

public interface ISubInventoryService extends IEntityService<SubInventory> {

    public SubInventory findByName(String name);

    public List<SubInventory> findByInventory(Organization inventory);

    public List<SubInventory> findByInventoryId(Long inventoryId);

}
