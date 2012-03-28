/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

import net.nan21.dnet.module.ad.usr.domain.entity.User;
import java.security.MessageDigest;
import java.math.BigInteger;

public interface IUserService extends IEntityService<User> {

    public User findByCode(String code);

    public List<User> findByDateFormat(SysDateFormat dateFormat);

    public List<User> findByDateFormatId(Long dateFormatId);

    public List<User> findByAccountType(UserType accountType);

    public List<User> findByAccountTypeId(Long accountTypeId);

    public List<User> findByRoles(Role roles);

    public List<User> findByRolesId(Long rolesId);

    public List<User> findByGroups(UserGroup groups);

    public List<User> findByGroupsId(Long groupsId);

    public void doChangePassword(Long userId, String newPassword)
            throws Exception;

}
