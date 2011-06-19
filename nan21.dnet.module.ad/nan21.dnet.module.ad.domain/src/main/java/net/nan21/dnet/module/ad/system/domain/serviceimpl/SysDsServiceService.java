/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.service.ISysDsServiceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

public class SysDsServiceService extends AbstractEntityService<SysDsService>
        implements ISysDsServiceService {

    public SysDsServiceService() {
        super();
    }

    public SysDsServiceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysDsService> getEntityClass() {
        return SysDsService.class;
    }

    public SysDsService findByName(Long clientId, SysDataSource dataSource,
            String name) {
        return (SysDsService) this.em
                .createNamedQuery(SysDsService.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pDataSource", dataSource)
                .setParameter("pName", name).getSingleResult();
    }

    public SysDsService findByName(Long clientId, Long dataSourceId, String name) {
        return (SysDsService) this.em
                .createNamedQuery(SysDsService.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pDataSourceId", dataSourceId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<SysDsService> findByDataSource(SysDataSource dataSource) {
        return this.findByDataSourceId(dataSource.getId());
    }

    public List<SysDsService> findByDataSourceId(Long dataSourceId) {
        return (List<SysDsService>) this.em
                .createQuery(
                        "select e from SysDsService where e.dataSource.id = :pDataSourceId",
                        SysDsService.class)
                .setParameter("pDataSourceId", dataSourceId).getResultList();
    }

}
