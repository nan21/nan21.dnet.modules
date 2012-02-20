/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IExportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

public class ExportJobItemService extends AbstractEntityService<ExportJobItem>
        implements IExportJobItemService {

    public ExportJobItemService() {
        super();
    }

    public ExportJobItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ExportJobItem> getEntityClass() {
        return ExportJobItem.class;
    }

    public ExportJobItem findByJob_map(ExportJob job, ExportMap map) {
        return (ExportJobItem) this.em
                .createNamedQuery(ExportJobItem.NQ_FIND_BY_JOB_MAP)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJob", job).setParameter("pMap", map)
                .getSingleResult();
    }

    public ExportJobItem findByJob_map(Long jobId, Long mapId) {
        return (ExportJobItem) this.em
                .createNamedQuery(ExportJobItem.NQ_FIND_BY_JOB_MAP_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).setParameter("pMapId", mapId)
                .getSingleResult();
    }

    public List<ExportJobItem> findByJob(ExportJob job) {
        return this.findByJobId(job.getId());
    }

    public List<ExportJobItem> findByJobId(Long jobId) {
        return (List<ExportJobItem>) this.em
                .createQuery(
                        "select e from ExportJobItem e where e.clientId = :pClientId and e.job.id = :pJobId",
                        ExportJobItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pJobId", jobId).getResultList();
    }

    public List<ExportJobItem> findByMap(ExportMap map) {
        return this.findByMapId(map.getId());
    }

    public List<ExportJobItem> findByMapId(Long mapId) {
        return (List<ExportJobItem>) this.em
                .createQuery(
                        "select e from ExportJobItem e where e.clientId = :pClientId and e.map.id = :pMapId",
                        ExportJobItem.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pMapId", mapId).getResultList();
    }

}
