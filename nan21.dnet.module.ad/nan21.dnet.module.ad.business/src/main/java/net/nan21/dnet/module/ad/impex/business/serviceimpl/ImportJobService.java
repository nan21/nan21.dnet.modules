/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

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

    public ImportJob findByName(String name) {
        return (ImportJob) this.em.createNamedQuery(ImportJob.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ImportJob> findByItems(ImportJobItem items) {
        return this.findByItemsId(items.getId());
    }

    public List<ImportJob> findByItemsId(Long itemsId) {
        return (List<ImportJob>) this.em
                .createQuery(
                        "select distinct e from ImportJob e , IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
                        ImportJob.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemsId", itemsId).getResultList();
    }

}
