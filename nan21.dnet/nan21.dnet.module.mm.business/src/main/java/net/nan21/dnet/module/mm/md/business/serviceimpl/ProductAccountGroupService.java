/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAccountGroupService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAccountGroup;

public class ProductAccountGroupService extends
        AbstractEntityService<ProductAccountGroup> implements
        IProductAccountGroupService {

    public ProductAccountGroupService() {
        super();
    }

    public ProductAccountGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAccountGroup> getEntityClass() {
        return ProductAccountGroup.class;
    }

    public ProductAccountGroup findByCode(Long clientId, String code) {
        return (ProductAccountGroup) this.em
                .createNamedQuery(ProductAccountGroup.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public ProductAccountGroup findByName(Long clientId, String name) {
        return (ProductAccountGroup) this.em
                .createNamedQuery(ProductAccountGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
