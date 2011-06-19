/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.domain.service.IImportMapService;

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

}
