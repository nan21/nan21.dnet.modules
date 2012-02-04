/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.pj.md.business.service.IIssueAttachmentService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.pj.md.domain.entity.IssueAttachment;

public class IssueAttachmentService extends
        AbstractEntityService<IssueAttachment> implements
        IIssueAttachmentService {

    public IssueAttachmentService() {
        super();
    }

    public IssueAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<IssueAttachment> getEntityClass() {
        return IssueAttachment.class;
    }

    public List<IssueAttachment> findByIssue(Issue issue) {
        return this.findByIssueId(issue.getId());
    }

    public List<IssueAttachment> findByIssueId(Long issueId) {
        return (List<IssueAttachment>) this.em
                .createQuery(
                        "select e from IssueAttachment e where e.issue.id = :pIssueId",
                        IssueAttachment.class)
                .setParameter("pIssueId", issueId).getResultList();
    }

}
