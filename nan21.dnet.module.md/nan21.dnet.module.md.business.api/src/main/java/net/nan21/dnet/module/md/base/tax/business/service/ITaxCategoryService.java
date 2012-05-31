/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

public interface ITaxCategoryService extends IEntityService<TaxCategory> {

    public TaxCategory findByName(String name);

}
