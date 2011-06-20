/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;

public class SalesInvoiceTypeDsConv extends
        AbstractDsConverter<SalesInvoiceTypeDs, SalesInvoiceType> implements
        IDsConverter<SalesInvoiceTypeDs, SalesInvoiceType> {

    protected void modelToEntityAttributes(SalesInvoiceTypeDs ds,
            SalesInvoiceType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(SalesInvoiceTypeDs ds,
            SalesInvoiceType e) throws Exception {
    }

    @Override
    public void entityToModel(SalesInvoiceType e, SalesInvoiceTypeDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}
