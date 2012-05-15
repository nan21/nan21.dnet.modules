/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.business.service.IIssueLinkService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;

public class IssueLinkService extends AbstractEntityService<IssueLink>
        implements IIssueLinkService {

    public IssueLinkService() {
        super();
    }

    public IssueLinkService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueLink> getEntityClass() {
        return IssueLink.class;
    }

    public List<IssueLink> findBySourceIssue(Issue sourceIssue) {
        return this.findBySourceIssueId(sourceIssue.getId());
    }

    public List<IssueLink> findBySourceIssueId(Long sourceIssueId) {
        return (List<IssueLink>) this.em
                .createQuery(
                        "select e from IssueLink e where e.clientId = :pClientId and e.sourceIssue.id = :pSourceIssueId",
                        IssueLink.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pSourceIssueId", sourceIssueId).getResultList();
    }

    public List<IssueLink> findByTargetIssue(Issue targetIssue) {
        return this.findByTargetIssueId(targetIssue.getId());
    }

    public List<IssueLink> findByTargetIssueId(Long targetIssueId) {
        return (List<IssueLink>) this.em
                .createQuery(
                        "select e from IssueLink e where e.clientId = :pClientId and e.targetIssue.id = :pTargetIssueId",
                        IssueLink.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTargetIssueId", targetIssueId).getResultList();
    }

    public List<IssueLink> findByLinkType(IssueLinkType linkType) {
        return this.findByLinkTypeId(linkType.getId());
    }

    public List<IssueLink> findByLinkTypeId(Long linkTypeId) {
        return (List<IssueLink>) this.em
                .createQuery(
                        "select e from IssueLink e where e.clientId = :pClientId and e.linkType.id = :pLinkTypeId",
                        IssueLink.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLinkTypeId", linkTypeId).getResultList();
    }

}
