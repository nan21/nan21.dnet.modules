/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.module.pj.md.domain.entity.IssueAttachment;

public interface IIssueAttachmentService extends
        IEntityService<IssueAttachment> {

    public List<IssueAttachment> findByIssue(Issue issue);

    public List<IssueAttachment> findByIssueId(Long issueId);

}
