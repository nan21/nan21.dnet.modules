/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

import net.nan21.dnet.module.pj.md.domain.entity.IssueLink;

public interface IIssueLinkService extends IEntityService<IssueLink> {

    public List<IssueLink> findBySourceIssue(Issue sourceIssue);

    public List<IssueLink> findBySourceIssueId(Long sourceIssueId);

    public List<IssueLink> findByTargetIssue(Issue targetIssue);

    public List<IssueLink> findByTargetIssueId(Long targetIssueId);

    public List<IssueLink> findByLinkType(IssueLinkType linkType);

    public List<IssueLink> findByLinkTypeId(Long linkTypeId);

}
