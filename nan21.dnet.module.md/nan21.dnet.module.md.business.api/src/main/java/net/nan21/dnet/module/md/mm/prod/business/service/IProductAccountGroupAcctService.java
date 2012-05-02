/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

public interface IProductAccountGroupAcctService extends
        IEntityService<ProductAccountGroupAcct> {

    public ProductAccountGroupAcct findByGroup_schema(
            ProductAccountGroup group, AccSchema accSchema);

    public ProductAccountGroupAcct findByGroup_schema(Long groupId,
            Long accSchemaId);

    public List<ProductAccountGroupAcct> findByGroup(ProductAccountGroup group);

    public List<ProductAccountGroupAcct> findByGroupId(Long groupId);

    public List<ProductAccountGroupAcct> findByAccSchema(AccSchema accSchema);

    public List<ProductAccountGroupAcct> findByAccSchemaId(Long accSchemaId);

    public List<ProductAccountGroupAcct> findByExpenseAccount(
            Account expenseAccount);

    public List<ProductAccountGroupAcct> findByExpenseAccountId(
            Long expenseAccountId);

    public List<ProductAccountGroupAcct> findByRevenueAccount(
            Account revenueAccount);

    public List<ProductAccountGroupAcct> findByRevenueAccountId(
            Long revenueAccountId);

}
