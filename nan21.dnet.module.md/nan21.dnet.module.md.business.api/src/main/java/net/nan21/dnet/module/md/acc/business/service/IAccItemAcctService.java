/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

import net.nan21.dnet.module.md.acc.domain.entity.AccItemAcct;

public interface IAccItemAcctService extends IEntityService<AccItemAcct> {

    public AccItemAcct findByItem_schema(AccItem accItem, AccSchema accSchema);

    public AccItemAcct findByItem_schema(Long accItemId, Long accSchemaId);

    public List<AccItemAcct> findByAccItem(AccItem accItem);

    public List<AccItemAcct> findByAccItemId(Long accItemId);

    public List<AccItemAcct> findByAccSchema(AccSchema accSchema);

    public List<AccItemAcct> findByAccSchemaId(Long accSchemaId);

    public List<AccItemAcct> findByCrAccount(Account crAccount);

    public List<AccItemAcct> findByCrAccountId(Long crAccountId);

    public List<AccItemAcct> findByDbAccount(Account dbAccount);

    public List<AccItemAcct> findByDbAccountId(Long dbAccountId);

    public String getDbPostingAcct(AccItem accItem, AccSchema accSchema);

    public String getCrPostingAcct(AccItem accItem, AccSchema accSchema);

}
