/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

public interface IProductAccountGroupService extends
        IEntityService<ProductAccountGroup> {

    public ProductAccountGroup findByCode(String code);

    public ProductAccountGroup findByName(String name);

}
