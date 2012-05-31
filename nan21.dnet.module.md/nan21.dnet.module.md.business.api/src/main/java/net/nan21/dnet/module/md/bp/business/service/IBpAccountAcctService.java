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
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

public interface IBpAccountAcctService extends IEntityService<BpAccountAcct> {

    public BpAccountAcct findByAccount_schema(BpAccount bpAccount,
            AccSchema accSchema);

    public BpAccountAcct findByAccount_schema(Long bpAccountId, Long accSchemaId);

    public List<BpAccountAcct> findByBpAccount(BpAccount bpAccount);

    public List<BpAccountAcct> findByBpAccountId(Long bpAccountId);

    public List<BpAccountAcct> findByAccSchema(AccSchema accSchema);

    public List<BpAccountAcct> findByAccSchemaId(Long accSchemaId);

    public List<BpAccountAcct> findByCustSalesAccount(Account custSalesAccount);

    public List<BpAccountAcct> findByCustSalesAccountId(Long custSalesAccountId);

    public List<BpAccountAcct> findByCustPrepayAccount(Account custPrepayAccount);

    public List<BpAccountAcct> findByCustPrepayAccountId(
            Long custPrepayAccountId);

    public List<BpAccountAcct> findByVendorPurchaseAccount(
            Account vendorPurchaseAccount);

    public List<BpAccountAcct> findByVendorPurchaseAccountId(
            Long vendorPurchaseAccountId);

    public List<BpAccountAcct> findByVendorPrepayAccount(
            Account vendorPrepayAccount);

    public List<BpAccountAcct> findByVendorPrepayAccountId(
            Long vendorPrepayAccountId);

}
