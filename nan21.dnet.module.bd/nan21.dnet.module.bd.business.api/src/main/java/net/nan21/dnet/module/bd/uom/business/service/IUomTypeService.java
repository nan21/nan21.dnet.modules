/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

public interface IUomTypeService extends IEntityService<UomType> {

    public UomType findByName(String name);

}
