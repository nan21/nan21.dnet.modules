/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;

public interface IAttributeService extends IEntityService<Attribute> {

    public Attribute findByName(String name);

    public List<Attribute> findByCategory(AttributeCategory category);

    public List<Attribute> findByCategoryId(Long categoryId);

    public List<Attribute> findByUom(Uom uom);

    public List<Attribute> findByUomId(Long uomId);

}
