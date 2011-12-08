/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderAttachmentDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderAttachment;

public class SalesOrderAttachmentDsConv extends
        AbstractDsConverter<SalesOrderAttachmentDs, SalesOrderAttachment>
        implements IDsConverter<SalesOrderAttachmentDs, SalesOrderAttachment> {

    protected void modelToEntityReferences(SalesOrderAttachmentDs ds,
            SalesOrderAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getOrderId() != null) {
            if (e.getOrder() == null
                    || !e.getOrder().getId().equals(ds.getOrderId())) {
                e.setOrder((SalesOrder) this.em.find(SalesOrder.class,
                        ds.getOrderId()));
            }
        }
    }

    protected void lookup_type_AttachmentType(SalesOrderAttachmentDs ds,
            SalesOrderAttachment e) throws Exception {
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
