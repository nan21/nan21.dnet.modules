/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.domain.service.IImportJobService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

public class ImportJobService extends AbstractEntityService<ImportJob>
        implements IImportJobService {

    public ImportJobService() {
        super();
    }

    public ImportJobService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ImportJob> getEntityClass() {
        return ImportJob.class;
    }

    public ImportJob findByName(Long clientId, String name) {
        return (ImportJob) this.em.createNamedQuery(ImportJob.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
