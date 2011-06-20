/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusLovDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;

public class SalesInvoiceStatusLovDsConv extends
        AbstractDsConverter<SalesInvoiceStatusLovDs, SalesInvoiceStatus>
        implements IDsConverter<SalesInvoiceStatusLovDs, SalesInvoiceStatus> {

    protected void modelToEntityAttributes(SalesInvoiceStatusLovDs ds,
            SalesInvoiceStatus e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(SalesInvoiceStatusLovDs ds,
            SalesInvoiceStatus e) throws Exception {
    }

    @Override
    public void entityToModel(SalesInvoiceStatus e, SalesInvoiceStatusLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
