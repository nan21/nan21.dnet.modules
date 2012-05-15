/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public class ProductAttributeService extends
        AbstractEntityService<ProductAttribute> implements
        IProductAttributeService {

    public ProductAttributeService() {
        super();
    }

    public ProductAttributeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<ProductAttribute> getEntityClass() {
        return ProductAttribute.class;
    }

    public ProductAttribute findByName(String name) {
        return (ProductAttribute) this.em
                .createNamedQuery(ProductAttribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductAttribute> findByType(ProductAttributeType type) {
        return this.findByTypeId(type.getId());
    }

    public List<ProductAttribute> findByTypeId(Long typeId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.clientId = :pClientId and e.type.id = :pTypeId",
                        ProductAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pTypeId", typeId).getResultList();
    }

    public List<ProductAttribute> findByUom(Uom uom) {
        return this.findByUomId(uom.getId());
    }

    public List<ProductAttribute> findByUomId(Long uomId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.clientId = :pClientId and e.uom.id = :pUomId",
                        ProductAttribute.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pUomId", uomId).getResultList();
    }

}
