/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
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

    public SysParam findByCode(String code) {
        return (SysParam) this.em.createNamedQuery(SysParam.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public SysParam findByName(String name) {
        return (SysParam) this.em.createNamedQuery(SysParam.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
