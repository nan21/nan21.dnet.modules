/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.fin.domain.entity.Tax;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxCategory;

import net.nan21.dnet.module.bd.fin.domain.entity.Tax;

public interface ITaxService extends IEntityService<Tax> {

    public Tax findByName(String name);

    public List<Tax> findByCategory(TaxCategory category);

    public List<Tax> findByCategoryId(Long categoryId);

    public List<Tax> findByParentTax(Tax parentTax);

    public List<Tax> findByParentTaxId(Long parentTaxId);

    public List<Tax> findByChildren(Tax children);

    public List<Tax> findByChildrenId(Long childrenId);

}
