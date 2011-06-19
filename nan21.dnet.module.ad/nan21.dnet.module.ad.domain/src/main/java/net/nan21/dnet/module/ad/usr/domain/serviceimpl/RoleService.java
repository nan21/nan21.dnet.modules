/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.service.IRoleService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

public class RoleService extends AbstractEntityService<Role> implements
        IRoleService {

    public RoleService() {
        super();
    }

    public RoleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    public Role findByName(Long clientId, String name) {
        return (Role) this.em.createNamedQuery(Role.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Role> findByUsers(User users) {
        return this.findByUsersId(users.getId());
    }

    public List<Role> findByUsersId(Long usersId) {
        return (List<Role>) this.em
                .createQuery("select e from Role where e.users.id = :pUsersId",
                        Role.class).setParameter("pUsersId", usersId)
                .getResultList();
    }

}
