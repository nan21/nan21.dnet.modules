/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;

import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

public interface IAuditFieldService extends IEntityService<AuditField> {

    public List<AuditField> findByAuditEntry(AuditEntry auditEntry);

    public List<AuditField> findByAuditEntryId(Long auditEntryId);

}
