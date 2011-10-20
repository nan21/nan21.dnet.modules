/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IUserService;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import java.security.MessageDigest;
import java.math.BigInteger;

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

    public List<User> findByAccountType(UserType accountType) {
        return this.findByAccountTypeId(accountType.getId());
    }

    public List<User> findByAccountTypeId(Long accountTypeId) {
        return (List<User>) this.em
                .createQuery(
                        "select e from User e where e.accountType.id = :pAccountTypeId",
                        User.class)
                .setParameter("pAccountTypeId", accountTypeId).getResultList();
    }

    public List<User> findByRoles(Role roles) {
        return this.findByRolesId(roles.getId());
    }

    public List<User> findByRolesId(Long rolesId) {
        return (List<User>) this.em
                .createQuery(
                        "select e from User e where e.roles.id = :pRolesId",
                        User.class).setParameter("pRolesId", rolesId)
                .getResultList();
    }

    public List<User> findByGroups(UserGroup groups) {
        return this.findByGroupsId(groups.getId());
    }

    public List<User> findByGroupsId(Long groupsId) {
        return (List<User>) this.em
                .createQuery(
                        "select e from User e where e.groups.id = :pGroupsId",
                        User.class).setParameter("pGroupsId", groupsId)
                .getResultList();
    }

    public void doChangePassword(Long userId, String newPassword)
            throws Exception {
        User u = this.findById(userId);
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(newPassword.getBytes(), 0, newPassword.length());
        String hashedPass = new BigInteger(1, messageDigest.digest())
                .toString(16);
        if (hashedPass.length() < 32) {
            hashedPass = "0" + hashedPass;
        }
        u.setPassword(hashedPass);
        this.em.merge(u);
    }

}
