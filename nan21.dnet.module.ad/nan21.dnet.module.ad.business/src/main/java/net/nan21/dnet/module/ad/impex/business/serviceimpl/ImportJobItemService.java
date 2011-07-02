/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

public class ImportJobItemService extends AbstractEntityService<ImportJobItem>
        implements IImportJobItemService {

    public ImportJobItemService() {
        super();
    }

    public ImportJobItemService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ImportJobItem> getEntityClass() {
        return ImportJobItem.class;
    }

    public ImportJobItem findByJob_map(Long clientId, ImportJob job,
            ImportMap map) {
        return (ImportJobItem) this.em
                .createNamedQuery(ImportJobItem.NQ_FIND_BY_JOB_MAP)
                .setParameter("pClientId", clientId).setParameter("pJob", job)
                .setParameter("pMap", map).getSingleResult();
    }

    public ImportJobItem findByJob_map(Long clientId, Long jobId, Long mapId) {
        return (ImportJobItem) this.em
                .createNamedQuery(ImportJobItem.NQ_FIND_BY_JOB_MAP_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pJobId", jobId).setParameter("pMapId", mapId)
                .getSingleResult();
    }

    public List<ImportJobItem> findByJob(ImportJob job) {
        return this.findByJobId(job.getId());
    }

    public List<ImportJobItem> findByJobId(Long jobId) {
        return (List<ImportJobItem>) this.em
                .createQuery(
                        "select e from ImportJobItem where e.job.id = :pJobId",
                        ImportJobItem.class).setParameter("pJobId", jobId)
                .getResultList();
    }

    public List<ImportJobItem> findByMap(ImportMap map) {
        return this.findByMapId(map.getId());
    }

    public List<ImportJobItem> findByMapId(Long mapId) {
        return (List<ImportJobItem>) this.em
                .createQuery(
                        "select e from ImportJobItem where e.map.id = :pMapId",
                        ImportJobItem.class).setParameter("pMapId", mapId)
                .getResultList();
    }

}
