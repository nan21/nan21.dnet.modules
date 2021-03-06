/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysDsEventService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

public class SysDsEventService extends AbstractEntityService<SysDsEvent>
        implements ISysDsEventService {

    public SysDsEventService() {
        super();
    }

    public SysDsEventService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysDsEvent> getEntityClass() {
        return SysDsEvent.class;
    }

    public SysDsEvent findByName(SysDataSource dataSource, String eventType) {
        return (SysDsEvent) this.em
                .createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDataSource", dataSource)
                .setParameter("pEventType", eventType).getSingleResult();
    }

    public SysDsEvent findByName(Long dataSourceId, String eventType) {
        return (SysDsEvent) this.em
                .createNamedQuery(SysDsEvent.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDataSourceId", dataSourceId)
                .setParameter("pEventType", eventType).getSingleResult();
    }

    public List<SysDsEvent> findByDataSource(SysDataSource dataSource) {
        return this.findByDataSourceId(dataSource.getId());
    }

    public List<SysDsEvent> findByDataSourceId(Long dataSourceId) {
        return (List<SysDsEvent>) this.em
                .createQuery(
                        "select e from SysDsEvent e where e.clientId = :pClientId and e.dataSource.id = :pDataSourceId",
                        SysDsEvent.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pDataSourceId", dataSourceId).getResultList();
    }

}
