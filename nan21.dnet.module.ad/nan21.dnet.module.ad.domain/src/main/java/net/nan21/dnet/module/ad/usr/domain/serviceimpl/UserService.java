/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;
import net.nan21.dnet.module.ad.usr.domain.service.IUserService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

public class UserService extends AbstractEntityService<User> implements
        IUserService {

    public UserService() {
        super();
    }

    public UserService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public User findByCode(Long clientId, String code) {
        return (User) this.em.createNamedQuery(User.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<User> findByRoles(Role roles) {
        return this.findByRolesId(roles.getId());
    }

    public List<User> findByRolesId(Long rolesId) {
        return (List<User>) this.em
                .createQuery("select e from User where e.roles.id = :pRolesId",
                        User.class).setParameter("pRolesId", rolesId)
                .getResultList();
    }

    public List<User> findByGroups(UserGroup groups) {
        return this.findByGroupsId(groups.getId());
    }

    public List<User> findByGroupsId(Long groupsId) {
        return (List<User>) this.em
                .createQuery(
                        "select e from User where e.groups.id = :pGroupsId",
                        User.class).setParameter("pGroupsId", groupsId)
                .getResultList();
    }

}
