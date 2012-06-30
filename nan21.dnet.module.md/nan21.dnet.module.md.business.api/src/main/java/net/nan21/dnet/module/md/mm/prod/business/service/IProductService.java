/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

public interface IProductService extends IEntityService<Product> {

    public Product findByCode(String code);

    public Product findByName(String name);

    public List<Product> findByDefaultUom(Uom defaultUom);

    public List<Product> findByDefaultUomId(Long defaultUomId);

    public List<Product> findByWeightUom(Uom weightUom);

    public List<Product> findByWeightUomId(Long weightUomId);

    public List<Product> findByVolumeUom(Uom volumeUom);

    public List<Product> findByVolumeUomId(Long volumeUomId);

    public List<Product> findByDimUom(Uom dimUom);

    public List<Product> findByDimUomId(Long dimUomId);

    public List<Product> findByManufacturer(ProductManufacturer manufacturer);

    public List<Product> findByManufacturerId(Long manufacturerId);

    public List<Product> findByAttributeSet(AttributeSet attributeSet);

    public List<Product> findByAttributeSetId(Long attributeSetId);

    public List<Product> findByCategories(ProductCategory categories);

    public List<Product> findByCategoriesId(Long categoriesId);

    public List<Product> findByAttributeValues(
            ProductAttributeValue attributeValues);

    public List<Product> findByAttributeValuesId(Long attributeValuesId);

    public String getExpenseAcct(Product product, Organization organization,
            AccSchema schema) throws Exception;

    public String getRevenueAcct(Product product, Organization organization,
            AccSchema schema) throws Exception;

}
