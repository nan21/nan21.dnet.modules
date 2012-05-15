/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;

public interface IDsAccessControlService extends
        IEntityService<DsAccessControl> {

    public DsAccessControl findByUnique(AccessControl accessControl,
            String dsName);

    public DsAccessControl findByUnique(Long accessControlId, String dsName);

    public List<DsAccessControl> findByAccessControl(AccessControl accessControl);

    public List<DsAccessControl> findByAccessControlId(Long accessControlId);

}
