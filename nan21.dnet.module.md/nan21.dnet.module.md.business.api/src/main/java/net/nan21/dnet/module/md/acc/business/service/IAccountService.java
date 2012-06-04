/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

import net.nan21.dnet.module.md.acc.domain.entity.Account;

public interface IAccountService extends IEntityService<Account> {

    public Account findByCode(String code);

    public List<Account> findByAccSchema(AccSchema accSchema);

    public List<Account> findByAccSchemaId(Long accSchemaId);

}
