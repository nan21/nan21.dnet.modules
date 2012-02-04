/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysParamValueService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

public class SysParamValueService extends AbstractEntityService<SysParamValue>
        implements ISysParamValueService {

    public SysParamValueService() {
        super();
    }

    public SysParamValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysParamValue> getEntityClass() {
        return SysParamValue.class;
    }

    public List<SysParamValue> findBySysParam(SysParam sysParam) {
        return this.findBySysParamId(sysParam.getId());
    }

    public List<SysParamValue> findBySysParamId(Long sysParamId) {
        return (List<SysParamValue>) this.em
                .createQuery(
                        "select e from SysParamValue e where e.sysParam.id = :pSysParamId",
                        SysParamValue.class)
                .setParameter("pSysParamId", sysParamId).getResultList();
    }

}
