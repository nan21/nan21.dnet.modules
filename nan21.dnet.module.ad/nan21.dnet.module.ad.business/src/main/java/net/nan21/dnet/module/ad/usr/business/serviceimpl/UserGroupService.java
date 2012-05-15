/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IUserGroupService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

public class UserGroupService extends AbstractEntityService<UserGroup>
        implements IUserGroupService {

    public UserGroupService() {
        super();
    }

    public UserGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<UserGroup> getEntityClass() {
        return UserGroup.class;
    }

    public UserGroup findByName(String name) {
        return (UserGroup) this.em.createNamedQuery(UserGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<UserGroup> findByUsers(User users) {
        return this.findByUsersId(users.getId());
    }

    public List<UserGroup> findByUsersId(Long usersId) {
        return (List<UserGroup>) this.em
                .createQuery(
                        "select distinct e from UserGroup e , IN (e.users) c where e.clientId = :pClientId and c.id = :pUsersId",
                        UserGroup.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUsersId", usersId).getResultList();
    }

}
