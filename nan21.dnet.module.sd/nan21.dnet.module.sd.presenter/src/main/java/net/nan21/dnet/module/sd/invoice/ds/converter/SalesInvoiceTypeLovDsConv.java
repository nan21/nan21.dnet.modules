/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;

public class SalesInvoiceTypeLovDsConv extends
        AbstractDsConverter<SalesInvoiceTypeLovDs, SalesInvoiceType> implements
        IDsConverter<SalesInvoiceTypeLovDs, SalesInvoiceType> {

    protected void modelToEntityAttributes(SalesInvoiceTypeLovDs ds,
            SalesInvoiceType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SalesInvoiceTypeLovDs ds,
            SalesInvoiceType e) throws Exception {
    }

    @Override
    public void entityToModel(SalesInvoiceType e, SalesInvoiceTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
