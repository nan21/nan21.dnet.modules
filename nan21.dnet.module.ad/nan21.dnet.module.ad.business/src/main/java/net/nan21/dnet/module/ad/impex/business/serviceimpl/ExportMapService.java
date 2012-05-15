/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

public class ExportMapService extends AbstractEntityService<ExportMap>
        implements IExportMapService {

    public ExportMapService() {
        super();
    }

    public ExportMapService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ExportMap> getEntityClass() {
        return ExportMap.class;
    }

    public ExportMap findByName(String name) {
        return (ExportMap) this.em.createNamedQuery(ExportMap.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ExportMap> findByItems(ExportMapItem items) {
        return this.findByItemsId(items.getId());
    }

    public List<ExportMap> findByItemsId(Long itemsId) {
        return (List<ExportMap>) this.em
                .createQuery(
                        "select distinct e from ExportMap e , IN (e.items) c where e.clientId = :pClientId and c.id = :pItemsId",
                        ExportMap.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pItemsId", itemsId).getResultList();
    }

}
