/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.module.pj.md.domain.entity.IssueText;

public interface IIssueTextService extends IEntityService<IssueText> {

    public List<IssueText> findByIssue(Issue issue);

    public List<IssueText> findByIssueId(Long issueId);

    public List<IssueText> findByIssueTextType(IssueTextType issueTextType);

    public List<IssueText> findByIssueTextTypeId(Long issueTextTypeId);

}
