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
                x = ((IIssueTextTypeService) findEntityService(IssueTextType.class))
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

}
