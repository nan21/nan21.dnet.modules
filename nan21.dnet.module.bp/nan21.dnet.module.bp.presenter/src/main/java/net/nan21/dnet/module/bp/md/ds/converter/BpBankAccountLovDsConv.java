/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpBankAccountLovDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpBankAccount;

public class BpBankAccountLovDsConv extends
        AbstractDsConverter<BpBankAccountLovDs, BpBankAccount> implements
        IDsConverter<BpBankAccountLovDs, BpBankAccount> {

    protected void modelToEntityAttributes(BpBankAccountLovDs ds,
            BpBankAccount e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setAccountNo(ds.getAccountNo());
    }

    protected void modelToEntityReferences(BpBankAccountLovDs ds,
            BpBankAccount e) throws Exception {
    }

    @Override
    public void entityToModel(BpBankAccount e, BpBankAccountLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setAccountNo(e.getAccountNo());
    }

}
