/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

public interface IAccSchemaService extends IEntityService<AccSchema> {

    public AccSchema findByCode(String code);

    public AccSchema findByName(String name);

}
