/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.benefit.domain.entity.OptionType;

public interface IOptionTypeService extends IEntityService<OptionType> {

    public OptionType findByName(String name);

}
