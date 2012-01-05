/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAsgnAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;

public class AsgnAccessControlService extends
        AbstractEntityService<AsgnAccessControl> implements
        IAsgnAccessControlService {

    public AsgnAccessControlService() {
        super();
    }

    public AsgnAccessControlService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AsgnAccessControl> getEntityClass() {
        return AsgnAccessControl.class;
    }

    public AsgnAccessControl findByUnique(Long clientId,
            AccessControl accessControl, String dsName) {
        return (AsgnAccessControl) this.em
                .createNamedQuery(AsgnAccessControl.NQ_FIND_BY_UNIQUE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControl", accessControl)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public AsgnAccessControl findByUnique(Long clientId, Long accessControlId,
            String dsName) {
        return (AsgnAccessControl) this.em
                .createNamedQuery(AsgnAccessControl.NQ_FIND_BY_UNIQUE_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pAccessControlId", accessControlId)
                .setParameter("pDsName", dsName).getSingleResult();
    }

    public List<AsgnAccessControl> findByAccessControl(
            AccessControl accessControl) {
        return this.findByAccessControlId(accessControl.getId());
    }

    public List<AsgnAccessControl> findByAccessControlId(Long accessControlId) {
        return (List<AsgnAccessControl>) this.em
                .createQuery(
                        "select e from AsgnAccessControl e where e.accessControl.id = :pAccessControlId",
                        AsgnAccessControl.class)
                .setParameter("pAccessControlId", accessControlId)
                .getResultList();
    }

}
