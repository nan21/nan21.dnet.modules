/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeGroupService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;

public class ProductAttributeGroupService extends
        AbstractEntityService<ProductAttributeGroup> implements
        IProductAttributeGroupService {

    public ProductAttributeGroupService() {
        super();
    }

    public ProductAttributeGroupService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttributeGroup> getEntityClass() {
        return ProductAttributeGroup.class;
    }

    public ProductAttributeGroup findByName(String name) {
        return (ProductAttributeGroup) this.em
                .createNamedQuery(ProductAttributeGroup.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
