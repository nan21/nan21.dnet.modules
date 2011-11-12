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

    protected void modelToEntityAttributes(IssueLinkDs ds, IssueLink e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(IssueLinkDs ds, IssueLink e)
            throws Exception {

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
                x = ((IIssueLinkTypeService) getService(IIssueLinkTypeService.class))
                        .findByName(ds.getClientId(), ds.getLinkType());
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

    @Override
    public void entityToModel(IssueLink e, IssueLinkDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSourceIssueId(((e.getSourceIssue() != null)) ? e.getSourceIssue()
                .getId() : null);
        ds.setSourceIssue(((e.getSourceIssue() != null)) ? e.getSourceIssue()
                .getCode() : null);
        ds.setSourceSummary(((e.getSourceIssue() != null)) ? e.getSourceIssue()
                .getSummary() : null);
        ds.setTargetIssueId(((e.getTargetIssue() != null)) ? e.getTargetIssue()
                .getId() : null);
        ds.setTargetIssue(((e.getTargetIssue() != null)) ? e.getTargetIssue()
                .getCode() : null);
        ds.setTargetSummary(((e.getTargetIssue() != null)) ? e.getTargetIssue()
                .getSummary() : null);
        ds.setLinkTypeId(((e.getLinkType() != null)) ? e.getLinkType().getId()
                : null);
        ds.setLinkType(((e.getLinkType() != null)) ? e.getLinkType().getName()
                : null);
    }

}
