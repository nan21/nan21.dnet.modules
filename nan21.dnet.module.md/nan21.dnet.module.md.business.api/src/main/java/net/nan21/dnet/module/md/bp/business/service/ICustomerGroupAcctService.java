/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

public interface ICustomerGroupAcctService extends
        IEntityService<CustomerGroupAcct> {

    public CustomerGroupAcct findByGroup_schema(CustomerGroup custGroup,
            AccSchema accSchema);

    public CustomerGroupAcct findByGroup_schema(Long custGroupId,
            Long accSchemaId);

    public List<CustomerGroupAcct> findByCustGroup(CustomerGroup custGroup);

    public List<CustomerGroupAcct> findByCustGroupId(Long custGroupId);

    public List<CustomerGroupAcct> findByAccSchema(AccSchema accSchema);

    public List<CustomerGroupAcct> findByAccSchemaId(Long accSchemaId);

    public List<CustomerGroupAcct> findBySalesAccount(Account salesAccount);

    public List<CustomerGroupAcct> findBySalesAccountId(Long salesAccountId);

    public List<CustomerGroupAcct> findByPrepayAccount(Account prepayAccount);

    public List<CustomerGroupAcct> findByPrepayAccountId(Long prepayAccountId);

}
