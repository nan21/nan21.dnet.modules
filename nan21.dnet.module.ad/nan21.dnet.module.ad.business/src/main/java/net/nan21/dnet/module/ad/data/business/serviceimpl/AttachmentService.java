/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

public class AttachmentService extends AbstractEntityService<Attachment>
        implements IAttachmentService {

    public AttachmentService() {
        super();
    }

    public AttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Attachment> getEntityClass() {
        return Attachment.class;
    }

    public List<Attachment> findByType(AttachmentType type) {
        return this.findByTypeId(type.getId());
    }

    public List<Attachment> findByTypeId(Long typeId) {
        return (List<Attachment>) this.em
                .createQuery(
                        "select e from Attachment e where e.type.id = :pTypeId",
                        Attachment.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

}
