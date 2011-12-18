/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysPluginService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysPlugin;

public class SysPluginService extends AbstractEntityService<SysPlugin>
        implements ISysPluginService {

    public SysPluginService() {
        super();
    }

    public SysPluginService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysPlugin> getEntityClass() {
        return SysPlugin.class;
    }

    public SysPlugin findByName(Long clientId, String name) {
        return (SysPlugin) this.em.createNamedQuery(SysPlugin.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
