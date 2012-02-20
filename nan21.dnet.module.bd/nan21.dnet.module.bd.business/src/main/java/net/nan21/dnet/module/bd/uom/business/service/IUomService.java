/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

public interface IUomService extends IEntityService<Uom> {

    public Uom findByCode(String code);

    public Uom findByName(String name);

    public List<Uom> findByType(UomType type);

    public List<Uom> findByTypeId(Long typeId);

}
