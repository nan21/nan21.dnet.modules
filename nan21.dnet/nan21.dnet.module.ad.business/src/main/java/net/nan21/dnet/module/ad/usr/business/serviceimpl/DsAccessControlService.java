/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IDsAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;

public class DsAccessControlService extends
        AbstractEntityService<DsAccessControl> implements
        IDsAccessControlService {

    public DsAccessControlService() {
        super();
    }

    public DsAccessControlService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DsAccessControl> getEntityClass() {
        return DsAccessControl.class;
    }

    public DsAccessControl findByUnique(Long clientId,
            AccessControl accessControl, String dsName) {
        return (DsAccessControl) this.em
                .createNamedQuery(DsAccessControl.NQ_FIND_BY_UNIQUE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControl", accessControl)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public DsAccessControl findByUnique(Long clientId, Long accessControlId,
            String dsName) {
        return (DsAccessControl) this.em
                .createNamedQuery(DsAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControlId", accessControlId)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public List<DsAccessControl> findByAccessControl(AccessControl accessControl) {
        return this.findByAccessControlId(accessControl.getId());
    }

    public List<DsAccessControl> findByAccessControlId(Long accessControlId) {
        return (List<DsAccessControl>) this.em
                .createQuery(
                        "select e from DsAccessControl e where e.accessControl.id = :pAccessControlId",
                        DsAccessControl.class)
                .setParameter("pAccessControlId", accessControlId)
                .getResultList();
    }

}
