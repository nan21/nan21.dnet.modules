/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;
import net.nan21.dnet.module.mm.md.domain.entity.ProductManufacturer;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

public class ProductService extends AbstractEntityService<Product> {

    public ProductService() {
        super();
    }

    public ProductService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    public Product findByCode(Long clientId, String code) {
        return (Product) this.em.createNamedQuery(Product.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public Product findByName(Long clientId, String name) {
        return (Product) this.em.createNamedQuery(Product.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<Product> findByDefaultUom(Uom defaultUom) {
        return this.findByDefaultUomId(defaultUom.getId());
    }

    public List<Product> findByDefaultUomId(Long defaultUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.defaultUom.id = :pDefaultUomId",
                        Product.class)
                .setParameter("pDefaultUomId", defaultUomId).getResultList();
    }

    public List<Product> findByWeightUom(Uom weightUom) {
        return this.findByWeightUomId(weightUom.getId());
    }

    public List<Product> findByWeightUomId(Long weightUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.weightUom.id = :pWeightUomId",
                        Product.class)
                .setParameter("pWeightUomId", weightUomId).getResultList();
    }

    public List<Product> findByVolumeUom(Uom volumeUom) {
        return this.findByVolumeUomId(volumeUom.getId());
    }

    public List<Product> findByVolumeUomId(Long volumeUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.volumeUom.id = :pVolumeUomId",
                        Product.class)
                .setParameter("pVolumeUomId", volumeUomId).getResultList();
    }

    public List<Product> findByDimUom(Uom dimUom) {
        return this.findByDimUomId(dimUom.getId());
    }

    public List<Product> findByDimUomId(Long dimUomId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.dimUom.id = :pDimUomId",
                        Product.class).setParameter("pDimUomId", dimUomId)
                .getResultList();
    }

    public List<Product> findByManufacturer(ProductManufacturer manufacturer) {
        return this.findByManufacturerId(manufacturer.getId());
    }

    public List<Product> findByManufacturerId(Long manufacturerId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.manufacturer.id = :pManufacturerId",
                        Product.class)
                .setParameter("pManufacturerId", manufacturerId)
                .getResultList();
    }

    public List<Product> findByCategories(ProductCategory categories) {
        return this.findByCategoriesId(categories.getId());
    }

    public List<Product> findByCategoriesId(Long categoriesId) {
        return (List<Product>) this.em
                .createQuery(
                        "select distinct e from Product e , IN (e.categories) c where c.id = :pCategoriesId",
                        Product.class)
                .setParameter("pCategoriesId", categoriesId).getResultList();
    }

    public List<Product> findByAttributeGroup(
            ProductAttributeGroup attributeGroup) {
        return this.findByAttributeGroupId(attributeGroup.getId());
    }

    public List<Product> findByAttributeGroupId(Long attributeGroupId) {
        return (List<Product>) this.em
                .createQuery(
                        "select e from Product e where e.attributeGroup.id = :pAttributeGroupId",
                        Product.class)
                .setParameter("pAttributeGroupId", attributeGroupId)
                .getResultList();
    }

    public List<Product> findByAttributes(ProductAttributeValue attributes) {
        return this.findByAttributesId(attributes.getId());
    }

    public List<Product> findByAttributesId(Long attributesId) {
        return (List<Product>) this.em
                .createQuery(
                        "select distinct e from Product e , IN (e.attributes) c where c.id = :pAttributesId",
                        Product.class)
                .setParameter("pAttributesId", attributesId).getResultList();
    }

}
