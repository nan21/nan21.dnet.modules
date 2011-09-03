/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.mm.md.business.service.IProductAttachmentService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachmentType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachment;

public class ProductAttachmentService extends
        AbstractEntityService<ProductAttachment> implements
        IProductAttachmentService {

    public ProductAttachmentService() {
        super();
    }

    public ProductAttachmentService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttachment> getEntityClass() {
        return ProductAttachment.class;
    }

    public List<ProductAttachment> findByProduct(Product product) {
        return this.findByProductId(product.getId());
    }

    public List<ProductAttachment> findByProductId(Long productId) {
        return (List<ProductAttachment>) this.em
                .createQuery(
                        "select e from ProductAttachment e where e.product.id = :pProductId",
                        ProductAttachment.class)
                .setParameter("pProductId", productId).getResultList();
    }

    public List<ProductAttachment> findByType(ProductAttachmentType type) {
        return this.findByTypeId(type.getId());
    }

    public List<ProductAttachment> findByTypeId(Long typeId) {
        return (List<ProductAttachment>) this.em
                .createQuery(
                        "select e from ProductAttachment e where e.type.id = :pTypeId",
                        ProductAttachment.class)
                .setParameter("pTypeId", typeId).getResultList();
    }

}
