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
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

public interface IVendorGroupAcctService extends
        IEntityService<VendorGroupAcct> {

    public VendorGroupAcct findByGroup_schema(VendorGroup vendorGroup,
            AccSchema accSchema);

    public VendorGroupAcct findByGroup_schema(Long vendorGroupId,
            Long accSchemaId);

    public List<VendorGroupAcct> findByVendorGroup(VendorGroup vendorGroup);

    public List<VendorGroupAcct> findByVendorGroupId(Long vendorGroupId);

    public List<VendorGroupAcct> findByAccSchema(AccSchema accSchema);

    public List<VendorGroupAcct> findByAccSchemaId(Long accSchemaId);

    public List<VendorGroupAcct> findByPurchaseAccount(Account purchaseAccount);

    public List<VendorGroupAcct> findByPurchaseAccountId(Long purchaseAccountId);

    public List<VendorGroupAcct> findByPrepayAccount(Account prepayAccount);

    public List<VendorGroupAcct> findByPrepayAccountId(Long prepayAccountId);

}
