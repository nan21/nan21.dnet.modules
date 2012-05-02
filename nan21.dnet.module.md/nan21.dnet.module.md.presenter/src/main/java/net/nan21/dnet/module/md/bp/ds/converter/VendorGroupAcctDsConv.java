/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.business.service.IAccountService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupService;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDs;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

public class VendorGroupAcctDsConv extends
        AbstractDsConverter<VendorGroupAcctDs, VendorGroupAcct> implements
        IDsConverter<VendorGroupAcctDs, VendorGroupAcct> {

    @Override
    protected void modelToEntityReferences(VendorGroupAcctDs ds,
            VendorGroupAcct e, boolean isInsert) throws Exception {

        if (ds.getVendorGroupId() != null) {
            if (e.getVendorGroup() == null
                    || !e.getVendorGroup().getId()
                            .equals(ds.getVendorGroupId())) {
                e.setVendorGroup((CustomerGroup) this.em.find(
                        CustomerGroup.class, ds.getVendorGroupId()));
            }
        } else {
            this.lookup_vendorGroup_CustomerGroup(ds, e);
        }

        if (ds.getPurchaseAccountId() != null) {
            if (e.getPurchaseAccount() == null
                    || !e.getPurchaseAccount().getId()
                            .equals(ds.getPurchaseAccountId())) {
                e.setPurchaseAccount((Account) this.em.find(Account.class,
                        ds.getPurchaseAccountId()));
            }
        } else {
            this.lookup_purchaseAccount_Account(ds, e);
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

    protected void lookup_vendorGroup_CustomerGroup(VendorGroupAcctDs ds,
            VendorGroupAcct e) throws Exception {
        if (ds.getVendorGroup() != null && !ds.getVendorGroup().equals("")) {
            CustomerGroup x = null;
            try {
                x = ((ICustomerGroupService) findEntityService(CustomerGroup.class))
                        .findByCode(ds.getVendorGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CustomerGroup` reference:  `vendorGroup` = "
                                + ds.getVendorGroup() + "  ");
            }
            e.setVendorGroup(x);

        } else {
            e.setVendorGroup(null);
        }
    }

    protected void lookup_purchaseAccount_Account(VendorGroupAcctDs ds,
            VendorGroupAcct e) throws Exception {
        if (ds.getPurchaseAccount() != null
                && !ds.getPurchaseAccount().equals("")) {
            Account x = null;
            try {
                x = ((IAccountService) findEntityService(Account.class))
                        .findByCode(ds.getPurchaseAccount());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Account` reference:  `purchaseAccount` = "
                                + ds.getPurchaseAccount() + "  ");
            }
            e.setPurchaseAccount(x);

        } else {
            e.setPurchaseAccount(null);
        }
    }

    protected void lookup_prepayAccount_Account(VendorGroupAcctDs ds,
            VendorGroupAcct e) throws Exception {
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

    protected void lookup_accSchema_AccSchema(VendorGroupAcctDs ds,
            VendorGroupAcct e) throws Exception {
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
