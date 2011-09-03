/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttachmentTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachmentType;

public class ProductAttachmentTypeService extends
        AbstractEntityService<ProductAttachmentType> implements
        IProductAttachmentTypeService {

    public ProductAttachmentTypeService() {
        super();
    }

    public ProductAttachmentTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttachmentType> getEntityClass() {
        return ProductAttachmentType.class;
    }

    public ProductAttachmentType findByName(Long clientId, String name) {
        return (ProductAttachmentType) this.em
                .createNamedQuery(ProductAttachmentType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
