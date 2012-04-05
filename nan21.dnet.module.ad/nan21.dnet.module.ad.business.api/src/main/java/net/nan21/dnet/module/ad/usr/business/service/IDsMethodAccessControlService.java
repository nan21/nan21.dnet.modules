/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import net.nan21.dnet.module.ad.usr.domain.entity.DsMethodAccessControl;

public interface IDsMethodAccessControlService extends
        IEntityService<DsMethodAccessControl> {

    public DsMethodAccessControl findByUnique(AccessControl accessControl,
            String dsName);

    public DsMethodAccessControl findByUnique(Long accessControlId,
            String dsName);

    public List<DsMethodAccessControl> findByAccessControl(
            AccessControl accessControl);

    public List<DsMethodAccessControl> findByAccessControlId(
            Long accessControlId);

}
