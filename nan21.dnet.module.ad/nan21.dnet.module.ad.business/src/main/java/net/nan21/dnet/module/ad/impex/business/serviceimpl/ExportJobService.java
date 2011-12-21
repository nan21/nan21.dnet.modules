/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IExportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;

public class ExportJobService extends AbstractEntityService<ExportJob>
        implements IExportJobService {

    public ExportJobService() {
        super();
    }

    public ExportJobService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ExportJob> getEntityClass() {
        return ExportJob.class;
    }

    public ExportJob findByName(Long clientId, String name) {
        return (ExportJob) this.em.createNamedQuery(ExportJob.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ExportJob> findByItems(ExportJobItem items) {
        return this.findByItemsId(items.getId());
    }

    public List<ExportJob> findByItemsId(Long itemsId) {
        return (List<ExportJob>) this.em
                .createQuery(
                        "select e from ExportJob e where e.items.id = :pItemsId",
                        ExportJob.class).setParameter("pItemsId", itemsId)
                .getResultList();
    }

}