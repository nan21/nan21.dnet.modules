/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

public interface IAccessControlService extends IEntityService<AccessControl> {

    public AccessControl findByName(String name);

    public List<AccessControl> findByDsRules(DsAccessControl dsRules);

    public List<AccessControl> findByDsRulesId(Long dsRulesId);

    public List<AccessControl> findByRoles(Role roles);

    public List<AccessControl> findByRolesId(Long rolesId);

}
