/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;

import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;

public interface IAccountGroupService extends IEntityService<AccountGroup> {

    public AccountGroup findByCode(String code);

    public AccountGroup findByName(String name);

    public List<AccountGroup> findByAccSchema(AccSchema accSchema);

    public List<AccountGroup> findByAccSchemaId(Long accSchemaId);

}
