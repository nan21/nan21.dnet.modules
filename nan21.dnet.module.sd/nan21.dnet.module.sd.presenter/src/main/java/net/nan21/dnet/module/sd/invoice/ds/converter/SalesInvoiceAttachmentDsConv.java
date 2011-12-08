/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceAttachmentDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceAttachment;

public class SalesInvoiceAttachmentDsConv extends
        AbstractDsConverter<SalesInvoiceAttachmentDs, SalesInvoiceAttachment>
        implements
        IDsConverter<SalesInvoiceAttachmentDs, SalesInvoiceAttachment> {

    protected void modelToEntityReferences(SalesInvoiceAttachmentDs ds,
            SalesInvoiceAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getInvoiceId() != null) {
            if (e.getInvoice() == null
                    || !e.getInvoice().getId().equals(ds.getInvoiceId())) {
                e.setInvoice((SalesInvoice) this.em.find(SalesInvoice.class,
                        ds.getInvoiceId()));
            }
        }
    }

    protected void lookup_type_AttachmentType(SalesInvoiceAttachmentDs ds,
            SalesInvoiceAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttachmentType x = null;
            try {
                x = ((IAttachmentTypeService) findEntityService(AttachmentType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
