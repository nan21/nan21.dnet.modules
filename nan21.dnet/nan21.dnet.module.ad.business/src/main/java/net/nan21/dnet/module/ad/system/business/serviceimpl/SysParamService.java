/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysParamService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

public class SysParamService extends AbstractEntityService<SysParam> implements
        ISysParamService {

    public SysParamService() {
        super();
    }

    public SysParamService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysParam> getEntityClass() {
        return SysParam.class;
    }

    public SysParam findByCode(Long clientId, String code) {
        return (SysParam) this.em.createNamedQuery(SysParam.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public SysParam findByName(Long clientId, String name) {
        return (SysParam) this.em.createNamedQuery(SysParam.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
