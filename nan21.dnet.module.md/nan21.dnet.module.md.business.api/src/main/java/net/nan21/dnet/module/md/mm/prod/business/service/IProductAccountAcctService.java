/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;

public interface IProductAccountAcctService extends
        IEntityService<ProductAccountAcct> {

    public ProductAccountAcct findByAccount_schema(ProductAccount prodAccount,
            AccSchema accSchema);

    public ProductAccountAcct findByAccount_schema(Long prodAccountId,
            Long accSchemaId);

    public List<ProductAccountAcct> findByProdAccount(ProductAccount prodAccount);

    public List<ProductAccountAcct> findByProdAccountId(Long prodAccountId);

    public List<ProductAccountAcct> findByAccSchema(AccSchema accSchema);

    public List<ProductAccountAcct> findByAccSchemaId(Long accSchemaId);

    public List<ProductAccountAcct> findByExpenseAccount(Account expenseAccount);

    public List<ProductAccountAcct> findByExpenseAccountId(Long expenseAccountId);

    public List<ProductAccountAcct> findByRevenueAccount(Account revenueAccount);

    public List<ProductAccountAcct> findByRevenueAccountId(Long revenueAccountId);

}
