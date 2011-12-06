/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.pj.md.business.service.IIssueService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueAttachmentDs;
import net.nan21.dnet.module.pj.md.domain.entity.IssueAttachment;

public class IssueAttachmentDsConv extends
        AbstractDsConverter<IssueAttachmentDs, IssueAttachment> implements
        IDsConverter<IssueAttachmentDs, IssueAttachment> {

    protected void modelToEntityReferences(IssueAttachmentDs ds,
            IssueAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getIssueId() != null) {
            if (e.getIssue() == null
                    || !e.getIssue().getId().equals(ds.getIssueId())) {
                e.setIssue((Issue) this.em.find(Issue.class, ds.getIssueId()));
            }
        } else {
            this.lookup_issue_Issue(ds, e);
        }
    }

    protected void lookup_type_AttachmentType(IssueAttachmentDs ds,
            IssueAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttachmentType x = null;
            try {
                x = ((IAttachmentTypeService) getService(IAttachmentTypeService.class))
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

    protected void lookup_issue_Issue(IssueAttachmentDs ds, IssueAttachment e)
            throws Exception {
        if (ds.getIssue() != null && !ds.getIssue().equals("")) {
            Issue x = null;
            try {
                x = ((IIssueService) getService(IIssueService.class))
                        .findByCode(ds.getClientId(), ds.getIssue());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Issue` reference:  `issue` = "
                                + ds.getIssue() + "  ");
            }
            e.setIssue(x);

        } else {
            e.setIssue(null);
        }
    }

}
