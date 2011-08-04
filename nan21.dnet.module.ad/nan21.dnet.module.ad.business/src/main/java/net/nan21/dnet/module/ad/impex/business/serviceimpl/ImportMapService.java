/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

public class ImportMapService extends AbstractEntityService<ImportMap>
        implements IImportMapService {

    public ImportMapService() {
        super();
    }

    public ImportMapService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ImportMap> getEntityClass() {
        return ImportMap.class;
    }

    public ImportMap findByName(Long clientId, String name) {
        return (ImportMap) this.em.createNamedQuery(ImportMap.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ImportMap> findByItems(ImportMapItem items) {
        return this.findByItemsId(items.getId());
    }

    public List<ImportMap> findByItemsId(Long itemsId) {
        return (List<ImportMap>) this.em
                .createQuery(
                        "select e from ImportMap e where e.items.id = :pItemsId",
                        ImportMap.class).setParameter("pItemsId", itemsId)
                .getResultList();
    }

}
