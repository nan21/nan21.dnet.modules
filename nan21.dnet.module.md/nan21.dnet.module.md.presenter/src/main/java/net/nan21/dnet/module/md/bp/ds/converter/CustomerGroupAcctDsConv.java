/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.business.service.IAccountService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDs;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

public class CustomerGroupAcctDsConv extends
        AbstractDsConverter<CustomerGroupAcctDs, CustomerGroupAcct> implements
        IDsConverter<CustomerGroupAcctDs, CustomerGroupAcct> {

    @Override
    protected void modelToEntityReferences(CustomerGroupAcctDs ds,
            CustomerGroupAcct e, boolean isInsert) throws Exception {

        if (ds.getCustGroupId() != null) {
            if (e.getCustGroup() == null
                    || !e.getCustGroup().getId().equals(ds.getCustGroupId())) {
                e.setCustGroup((CustomerGroup) this.em.find(
                        CustomerGroup.class, ds.getCustGroupId()));
            }
        } else {
            this.lookup_custGroup_CustomerGroup(ds, e);
        }

        if (ds.getSalesAccountId() != null) {
            if (e.getSalesAccount() == null
                    || !e.getSalesAccount().getId()
                            .equals(ds.getSalesAccountId())) {
                e.setSalesAccount((Account) this.em.find(Account.class,
                        ds.getSalesAccountId()));
            }
        } else {
            this.lookup_salesAccount_Account(ds, e);
        }

        if (ds.getPrepayAccountId() != null) {
            if (e.getPrepayAccount() == null
                    || !e.getPrepayAccount().getId()
                            .equals(ds.getPrepayAccountId())) {
                e.setPrepayAccount((Account) this.em.find(Account.class,
                        ds.getPrepayAccountId()));
            }
        } else {
            this.lookup_prepayAccount_Account(ds, e);
        }

        if (ds.getAccSchemaId() != null) {
            if (e.getAccSchema() == null
                    || !e.getAccSchema().getId().equals(ds.getAccSchemaId())) {
                e.setAccSchema((AccSchema) this.em.find(AccSchema.class,
                        ds.getAccSchemaId()));
            }
        } else {
            this.lookup_accSchema_AccSchema(ds, e);
        }

    }

    protected void lookup_custGroup_CustomerGroup(CustomerGroupAcctDs ds,
            CustomerGroupAcct e) throws Exception {
        if (ds.getCustGroup() != null && !ds.getCustGroup().equals("")) {
            CustomerGroup x = null;
            try {
                x = ((ICustomerGroupService) findEntityService(CustomerGroup.class))
                        .findByCode(ds.getCustGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CustomerGroup` reference:  `custGroup` = "
                                + ds.getCustGroup() + "  ");
            }
            e.setCustGroup(x);

        } else {
            e.setCustGroup(null);
        }
    }

    protected void lookup_salesAccount_Account(CustomerGroupAcctDs ds,
            CustomerGroupAcct e) throws Exception {
        if (ds.getSalesAccount() != null && !ds.getSalesAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getSalesAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `salesAccount` = "
                                + ds.getSalesAccount() + "  ");
            }
            e.setSalesAccount(x);

        } else {
            e.setSalesAccount(null);
        }
    }

    protected void lookup_prepayAccount_Account(CustomerGroupAcctDs ds,
            CustomerGroupAcct e) throws Exception {
        if (ds.getPrepayAccount() != null && !ds.getPrepayAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getPrepayAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `prepayAccount` = "
                                + ds.getPrepayAccount() + "  ");
            }
            e.setPrepayAccount(x);

        } else {
            e.setPrepayAccount(null);
        }
    }

    protected void lookup_accSchema_AccSchema(CustomerGroupAcctDs ds,
            CustomerGroupAcct e) throws Exception {
        if (ds.getAccSchema() != null && !ds.getAccSchema().equals("")) {
            AccSchema x = null;
            try {
                x = ((IAccSchemaService) findEntityService(AccSchema.class))
                        .findByCode(ds.getAccSchema());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccSchema` reference:  `accSchema` = "
                                + ds.getAccSchema() + "  ");
            }
            e.setAccSchema(x);

        } else {
            e.setAccSchema(null);
        }
    }

}
