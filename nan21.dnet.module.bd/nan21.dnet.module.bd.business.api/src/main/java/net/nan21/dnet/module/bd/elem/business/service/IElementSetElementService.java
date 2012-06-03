/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;

import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

public interface IElementSetElementService extends
        IEntityService<ElementSetElement> {

    public ElementSetElement findBySet_elem(ElementSet elementSet,
            Element element);

    public ElementSetElement findBySet_elem(Long elementSetId, Long elementId);

    public List<ElementSetElement> findByElementSet(ElementSet elementSet);

    public List<ElementSetElement> findByElementSetId(Long elementSetId);

    public List<ElementSetElement> findByElement(Element element);

    public List<ElementSetElement> findByElementId(Long elementId);

}
