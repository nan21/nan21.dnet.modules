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
import net.nan21.dnet.module.bd.acc.ds.model.AccountGroupDs;
import net.nan21.dnet.module.bd.acc.domain.entity.AccountGroup;

public class AccountGroupDsConv extends
        AbstractDsConverter<AccountGroupDs, AccountGroup> implements
        IDsConverter<AccountGroupDs, AccountGroup> {

    protected void modelToEntityAttributes(AccountGroupDs ds, AccountGroup e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(AccountGroupDs ds, AccountGroup e)
            throws Exception {

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

    protected void lookup_accSchema_AccSchema(AccountGroupDs ds, AccountGroup e)
            throws Exception {
        if (ds.getAccSchema() != null && !ds.getAccSchema().equals("")) {
            AccSchema x = null;
            try {
                x = ((IAccSchemaService) getService(IAccSchemaService.class))
                        .findByCode(ds.getClientId(), ds.getAccSchema());
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

    @Override
    public void entityToModel(AccountGroup e, AccountGroupDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setAccSchemaId(((e.getAccSchema() != null)) ? e.getAccSchema()
                .getId() : null);
        ds.setAccSchema(((e.getAccSchema() != null)) ? e.getAccSchema()
                .getCode() : null);
    }

}
