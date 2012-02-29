/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IAuditFieldService;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

public class AuditFieldService extends AbstractEntityService<AuditField>
        implements IAuditFieldService {

    public AuditFieldService() {
        super();
    }

    public AuditFieldService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AuditField> getEntityClass() {
        return AuditField.class;
    }

    public List<AuditField> findByAuditEntry(AuditEntry auditEntry) {
        return this.findByAuditEntryId(auditEntry.getId());
    }

    public List<AuditField> findByAuditEntryId(Long auditEntryId) {
        return (List<AuditField>) this.em
                .createQuery(
                        "select e from AuditField e where e.clientId = :pClientId and e.auditEntry.id = :pAuditEntryId",
                        AuditField.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pAuditEntryId", auditEntryId).getResultList();
    }

}
