/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

public interface IImportJobService extends IEntityService<ImportJob> {

    public ImportJob findByName(Long clientId, String name);

}