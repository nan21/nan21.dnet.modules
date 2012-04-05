/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;

import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;

public interface IAsgnAccessControlService extends
        IEntityService<AsgnAccessControl> {

    public AsgnAccessControl findByUnique(AccessControl accessControl,
            String dsName);

    public AsgnAccessControl findByUnique(Long accessControlId, String dsName);

    public List<AsgnAccessControl> findByAccessControl(
            AccessControl accessControl);

    public List<AsgnAccessControl> findByAccessControlId(Long accessControlId);

}
