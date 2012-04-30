/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.acc.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.acc.ds.model.AccountDs;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;

public class AccountDsConv extends AbstractDsConverter<AccountDs, Account>
        implements IDsConverter<AccountDs, Account> {

    @Override
    protected void modelToEntityReferences(AccountDs ds, Account e,
            boolean isInsert) throws Exception {

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

    protected void lookup_accSchema_AccSchema(AccountDs ds, Account e)
            throws Exception {
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
