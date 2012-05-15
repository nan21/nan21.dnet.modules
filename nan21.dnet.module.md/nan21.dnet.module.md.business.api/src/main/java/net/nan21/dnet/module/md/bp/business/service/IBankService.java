/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.bp.domain.entity.Bank;

public interface IBankService extends IEntityService<Bank> {

    public Bank findByCode(String code);

    public Bank findByName(String name);

}
