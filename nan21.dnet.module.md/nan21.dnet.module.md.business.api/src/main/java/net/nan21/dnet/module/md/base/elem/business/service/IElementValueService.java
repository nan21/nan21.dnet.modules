/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;

import net.nan21.dnet.module.md.base.elem.domain.entity.ElementValue;

public interface IElementValueService extends IEntityService<ElementValue> {

    public List<ElementValue> findByElement(Element element);

    public List<ElementValue> findByElementId(Long elementId);

    public List<ElementValue> findByOrg(Organization org);

    public List<ElementValue> findByOrgId(Long orgId);

}
