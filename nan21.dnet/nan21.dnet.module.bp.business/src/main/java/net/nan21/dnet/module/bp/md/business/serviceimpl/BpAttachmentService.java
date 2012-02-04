/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bp.md.business.service.IBpAttachmentService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BpAttachment;

public class BpAttachmentService extends AbstractEntityService<BpAttachment>
        implements IBpAttachmentService {

    public BpAttachmentService() {
        super();
    }

    public BpAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BpAttachment> getEntityClass() {
        return BpAttachment.class;
    }

    public List<BpAttachment> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<BpAttachment> findByBpartnerId(Long bpartnerId) {
        return (List<BpAttachment>) this.em
                .createQuery(
                        "select e from BpAttachment e where e.bpartner.id = :pBpartnerId",
                        BpAttachment.class)
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

}
