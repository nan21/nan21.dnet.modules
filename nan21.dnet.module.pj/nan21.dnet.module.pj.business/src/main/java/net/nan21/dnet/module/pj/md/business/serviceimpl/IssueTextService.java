/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.business.service.IIssueTextService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

public class IssueTextService extends AbstractEntityService<IssueText>
        implements IIssueTextService {

    public IssueTextService() {
        super();
    }

    public IssueTextService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueText> getEntityClass() {
        return IssueText.class;
    }

    public List<IssueText> findByIssue(Issue issue) {
        return this.findByIssueId(issue.getId());
    }

    public List<IssueText> findByIssueId(Long issueId) {
        return (List<IssueText>) this.em
                .createQuery(
                        "select e from IssueText e where e.clientId = :pClientId and e.issue.id = :pIssueId",
                        IssueText.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pIssueId", issueId).getResultList();
    }

    public List<IssueText> findByIssueTextType(IssueTextType issueTextType) {
        return this.findByIssueTextTypeId(issueTextType.getId());
    }

    public List<IssueText> findByIssueTextTypeId(Long issueTextTypeId) {
        return (List<IssueText>) this.em
                .createQuery(
                        "select e from IssueText e where e.clientId = :pClientId and e.issueTextType.id = :pIssueTextTypeId",
                        IssueText.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pIssueTextTypeId", issueTextTypeId)
                .getResultList();
    }

}
