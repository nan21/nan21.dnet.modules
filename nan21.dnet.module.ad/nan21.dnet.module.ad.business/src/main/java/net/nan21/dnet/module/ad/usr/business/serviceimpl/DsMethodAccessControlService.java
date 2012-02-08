/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IDsMethodAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.DsMethodAccessControl;

public class DsMethodAccessControlService extends
        AbstractEntityService<DsMethodAccessControl> implements
        IDsMethodAccessControlService {

    public DsMethodAccessControlService() {
        super();
    }

    public DsMethodAccessControlService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DsMethodAccessControl> getEntityClass() {
        return DsMethodAccessControl.class;
    }

    public DsMethodAccessControl findByUnique(Long clientId,
            AccessControl accessControl, String dsName) {
        return (DsMethodAccessControl) this.em
                .createNamedQuery(DsMethodAccessControl.NQ_FIND_BY_UNIQUE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControl", accessControl)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public DsMethodAccessControl findByUnique(Long clientId,
            Long accessControlId, String dsName) {
        return (DsMethodAccessControl) this.em
                .createNamedQuery(
                        DsMethodAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControlId", accessControlId)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public List<DsMethodAccessControl> findByAccessControl(
            AccessControl accessControl) {
        return this.findByAccessControlId(accessControl.getId());
    }

    public List<DsMethodAccessControl> findByAccessControlId(
            Long accessControlId) {
        return (List<DsMethodAccessControl>) this.em
                .createQuery(
                        "select e from DsMethodAccessControl e where e.accessControl.id = :pAccessControlId",
                        DsMethodAccessControl.class)
                .setParameter("pAccessControlId", accessControlId)
                .getResultList();
    }

}
