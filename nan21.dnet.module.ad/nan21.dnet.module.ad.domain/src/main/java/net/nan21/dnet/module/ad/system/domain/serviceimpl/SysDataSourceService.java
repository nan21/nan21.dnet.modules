/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.service.ISysDataSourceService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceService extends AbstractEntityService<SysDataSource>
        implements ISysDataSourceService {

    public SysDataSourceService() {
        super();
    }

    public SysDataSourceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysDataSource> getEntityClass() {
        return SysDataSource.class;
    }

    public SysDataSource findByName(Long clientId, String name) {
        return (SysDataSource) this.em
                .createNamedQuery(SysDataSource.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public SysDataSource findByCtrl(Long clientId, String controller) {
        return (SysDataSource) this.em
                .createNamedQuery(SysDataSource.NQ_FIND_BY_CTRL)
                .setParameter("pClientId", clientId)
                .setParameter("pController", controller).getSingleResult();
    }

    public SysDataSource findByModel(Long clientId, String model) {
        return (SysDataSource) this.em
                .createNamedQuery(SysDataSource.NQ_FIND_BY_MODEL)
                .setParameter("pClientId", clientId)
                .setParameter("pModel", model).getSingleResult();
    }

}
