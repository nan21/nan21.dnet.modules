/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

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

    public ProductAttribute findByName(Long clientId, String name) {
        return (ProductAttribute) this.em
                .createNamedQuery(ProductAttribute.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<ProductAttribute> findByType(ProductAttributeType type) {
        return this.findByTypeId(type.getId());
    }

    public List<ProductAttribute> findByTypeId(Long typeId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.type.id = :pTypeId",
                        ProductAttribute.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<ProductAttribute> findByUomType(UomType uomType) {
        return this.findByUomTypeId(uomType.getId());
    }

    public List<ProductAttribute> findByUomTypeId(Long uomTypeId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.uomType.id = :pUomTypeId",
                        ProductAttribute.class)
                .setParameter("pUomTypeId", uomTypeId).getResultList();
    }

    public List<ProductAttribute> findByGroups(ProductAttributeGroup groups) {
        return this.findByGroupsId(groups.getId());
    }

    public List<ProductAttribute> findByGroupsId(Long groupsId) {
        return (List<ProductAttribute>) this.em
                .createQuery(
                        "select e from ProductAttribute e where e.groups.id = :pGroupsId",
                        ProductAttribute.class)
                .setParameter("pGroupsId", groupsId).getResultList();
    }

}
