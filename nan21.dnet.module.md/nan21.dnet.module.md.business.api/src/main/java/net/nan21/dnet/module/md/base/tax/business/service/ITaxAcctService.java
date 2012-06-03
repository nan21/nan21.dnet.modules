/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;

import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;

public interface ITaxAcctService extends IEntityService<TaxAcct> {

    public TaxAcct findByTax_schema(Tax tax, AccSchema accSchema);

    public TaxAcct findByTax_schema(Long taxId, Long accSchemaId);

    public List<TaxAcct> findByTax(Tax tax);

    public List<TaxAcct> findByTaxId(Long taxId);

    public List<TaxAcct> findByAccSchema(AccSchema accSchema);

    public List<TaxAcct> findByAccSchemaId(Long accSchemaId);

    public List<TaxAcct> findBySalesAccount(Account salesAccount);

    public List<TaxAcct> findBySalesAccountId(Long salesAccountId);

    public List<TaxAcct> findByPurchaseAccount(Account purchaseAccount);

    public List<TaxAcct> findByPurchaseAccountId(Long purchaseAccountId);

}
