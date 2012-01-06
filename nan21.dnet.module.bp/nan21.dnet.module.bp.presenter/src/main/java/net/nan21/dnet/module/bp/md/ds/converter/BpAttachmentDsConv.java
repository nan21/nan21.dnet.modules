/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.BpAttachmentDs;
import net.nan21.dnet.module.bp.md.domain.entity.BpAttachment;

public class BpAttachmentDsConv extends
        AbstractDsConverter<BpAttachmentDs, BpAttachment> implements
        IDsConverter<BpAttachmentDs, BpAttachment> {

    protected void modelToEntityReferences(BpAttachmentDs ds, BpAttachment e)
            throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getBusinessPartnerId() != null) {
            if (e.getBpartner() == null
                    || !e.getBpartner().getId()
                            .equals(ds.getBusinessPartnerId())) {
                e.setBpartner((BusinessPartner) this.em.find(
                        BusinessPartner.class, ds.getBusinessPartnerId()));
            }
        } else {
            this.lookup_bpartner_BusinessPartner(ds, e);
        }
    }

    protected void lookup_type_AttachmentType(BpAttachmentDs ds, BpAttachment e)
            throws Exception {
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

    protected void lookup_bpartner_BusinessPartner(BpAttachmentDs ds,
            BpAttachment e) throws Exception {
        if (ds.getBusinessPartner() != null
                && !ds.getBusinessPartner().equals("")) {
            BusinessPartner x = null;
            try {
                x = ((IBusinessPartnerService) findEntityService(BusinessPartner.class))
                        .findByCode(ds.getClientId(), ds.getBusinessPartner());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `BusinessPartner` reference:  `businessPartner` = "
                                + ds.getBusinessPartner() + "  ");
            }
            e.setBpartner(x);

        } else {
            e.setBpartner(null);
        }
    }

}
