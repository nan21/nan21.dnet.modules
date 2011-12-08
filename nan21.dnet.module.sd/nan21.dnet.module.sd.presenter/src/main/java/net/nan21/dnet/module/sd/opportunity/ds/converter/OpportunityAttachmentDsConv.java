/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.opportunity.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.sd.opportunity.domain.entity.Opportunity;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityAttachmentDs;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityAttachment;

public class OpportunityAttachmentDsConv extends
        AbstractDsConverter<OpportunityAttachmentDs, OpportunityAttachment>
        implements IDsConverter<OpportunityAttachmentDs, OpportunityAttachment> {

    protected void modelToEntityReferences(OpportunityAttachmentDs ds,
            OpportunityAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getOpportunityId() != null) {
            if (e.getOpportunity() == null
                    || !e.getOpportunity().getId()
                            .equals(ds.getOpportunityId())) {
                e.setOpportunity((Opportunity) this.em.find(Opportunity.class,
                        ds.getOpportunityId()));
            }
        }
    }

    protected void lookup_type_AttachmentType(OpportunityAttachmentDs ds,
            OpportunityAttachment e) throws Exception {
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
