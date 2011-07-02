/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;

public interface IUomConversionService extends IEntityService<UomConversion> {

    public List<UomConversion> findBySource(Uom source);

    public List<UomConversion> findBySourceId(Long sourceId);

    public List<UomConversion> findByTarget(Uom target);

    public List<UomConversion> findByTargetId(Long targetId);

}
