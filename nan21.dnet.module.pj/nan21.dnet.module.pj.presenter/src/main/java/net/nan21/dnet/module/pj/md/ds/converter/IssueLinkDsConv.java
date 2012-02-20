/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IIssueLinkTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs;
import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;

public class IssueLinkDsConv extends
        AbstractDsConverter<IssueLinkDs, IssueLink> implements
        IDsConverter<IssueLinkDs, IssueLink> {

    @Override
    protected void modelToEntityReferences(IssueLinkDs ds, IssueLink e,
            boolean isInsert) throws Exception {

        if (ds.getSourceIssueId() != null) {
            if (e.getSourceIssue() == null
                    || !e.getSourceIssue().getId()
                            .equals(ds.getSourceIssueId())) {
                e.setSourceIssue((Issue) this.em.find(Issue.class,
                        ds.getSourceIssueId()));
            }
        }

        if (ds.getTargetIssueId() != null) {
            if (e.getTargetIssue() == null
                    || !e.getTargetIssue().getId()
                            .equals(ds.getTargetIssueId())) {
                e.setTargetIssue((Issue) this.em.find(Issue.class,
                        ds.getTargetIssueId()));
            }
        }

        if (ds.getLinkTypeId() != null) {
            if (e.getLinkType() == null
                    || !e.getLinkType().getId().equals(ds.getLinkTypeId())) {
                e.setLinkType((IssueLinkType) this.em.find(IssueLinkType.class,
                        ds.getLinkTypeId()));
            }
        } else {
            this.lookup_linkType_IssueLinkType(ds, e);
        }

    }

    protected void lookup_linkType_IssueLinkType(IssueLinkDs ds, IssueLink e)
            throws Exception {
        if (ds.getLinkType() != null && !ds.getLinkType().equals("")) {
            IssueLinkType x = null;
            try {
                x = ((IIssueLinkTypeService) findEntityService(IssueLinkType.class))
                        .findByName(ds.getLinkType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueLinkType` reference:  `linkType` = "
                                + ds.getLinkType() + "  ");
            }
            e.setLinkType(x);

        } else {
            e.setLinkType(null);
        }
    }

}
