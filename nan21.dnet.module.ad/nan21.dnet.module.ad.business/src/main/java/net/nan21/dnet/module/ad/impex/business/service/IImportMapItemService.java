/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

public interface IImportMapItemService extends IEntityService<ImportMapItem> {

    public List<ImportMapItem> findByImportMap(ImportMap importMap);

    public List<ImportMapItem> findByImportMapId(Long importMapId);

}
