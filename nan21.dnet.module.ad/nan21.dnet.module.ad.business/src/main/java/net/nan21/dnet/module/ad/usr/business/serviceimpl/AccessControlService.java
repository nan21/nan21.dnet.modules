/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

public class AccessControlService extends AbstractEntityService<AccessControl>
        implements IAccessControlService {

    public AccessControlService() {
        super();
    }

    public AccessControlService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<AccessControl> getEntityClass() {
        return AccessControl.class;
    }

    public AccessControl findByName(Long clientId, String name) {
        return (AccessControl) this.em
                .createNamedQuery(AccessControl.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<AccessControl> findByDsRules(DsAccessControl dsRules) {
        return this.findByDsRulesId(dsRules.getId());
    }

    public List<AccessControl> findByDsRulesId(Long dsRulesId) {
        return (List<AccessControl>) this.em
                .createQuery(
                        "select distinct e from AccessControl e , IN (e.dsRules) c where c.id = :pDsRulesId",
                        AccessControl.class)
                .setParameter("pDsRulesId", dsRulesId).getResultList();
    }

    public List<AccessControl> findByRoles(Role roles) {
        return this.findByRolesId(roles.getId());
    }

    public List<AccessControl> findByRolesId(Long rolesId) {
        return (List<AccessControl>) this.em
                .createQuery(
                        "select distinct e from AccessControl e , IN (e.roles) c where c.id = :pRolesId",
                        AccessControl.class).setParameter("pRolesId", rolesId)
                .getResultList();
    }

}
