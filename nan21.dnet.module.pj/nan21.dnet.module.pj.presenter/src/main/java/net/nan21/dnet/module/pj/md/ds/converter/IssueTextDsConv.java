/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IIssueTextTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.IssueTextDs;
import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

public class IssueTextDsConv extends
        AbstractDsConverter<IssueTextDs, IssueText> implements
        IDsConverter<IssueTextDs, IssueText> {

    protected void modelToEntityAttributes(IssueTextDs ds, IssueText e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setContent(ds.getContent());
    }

    protected void modelToEntityReferences(IssueTextDs ds, IssueText e)
            throws Exception {

        if (ds.getIssueId() != null) {
            if (e.getIssue() == null
                    || !e.getIssue().getId().equals(ds.getIssueId())) {
                e.setIssue((Issue) this.em.find(Issue.class, ds.getIssueId()));
            }
        }
        if (ds.getIssueTextTypeId() != null) {
            if (e.getIssueTextType() == null
                    || !e.getIssueTextType().getId()
                            .equals(ds.getIssueTextTypeId())) {
                e.setIssueTextType((IssueTextType) this.em.find(
                        IssueTextType.class, ds.getIssueTextTypeId()));
            }
        } else {
            this.lookup_issueTextType_IssueTextType(ds, e);
        }
    }

    protected void lookup_issueTextType_IssueTextType(IssueTextDs ds,
            IssueText e) throws Exception {
        if (ds.getIssueTextType() != null && !ds.getIssueTextType().equals("")) {
            IssueTextType x = null;
            try {
                x = ((IIssueTextTypeService) getService(IIssueTextTypeService.class))
                        .findByName(ds.getClientId(), ds.getIssueTextType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueTextType` reference:  `issueTextType` = "
                                + ds.getIssueTextType() + "  ");
            }
            e.setIssueTextType(x);
        } else {
            e.setIssueTextType(null);
        }
    }

    @Override
    public void entityToModel(IssueText e, IssueTextDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setContent(e.getContent());
        ds.setIssueId(((e.getIssue() != null)) ? e.getIssue().getId() : null);
        ds.setIssueTextTypeId(((e.getIssueTextType() != null)) ? e
                .getIssueTextType().getId() : null);
        ds.setIssueTextType(((e.getIssueTextType() != null)) ? e
                .getIssueTextType().getName() : null);
    }

}
