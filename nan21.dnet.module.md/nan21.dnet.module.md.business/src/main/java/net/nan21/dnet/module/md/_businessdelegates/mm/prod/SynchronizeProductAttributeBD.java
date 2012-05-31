package net.nan21.dnet.module.md._businessdelegates.mm.prod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeGroupAttributeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public class SynchronizeProductAttributeBD extends AbstractBusinessDelegate {

	/**
	 * Add attributes to a product based on the group-attribute specified at
	 * product level.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addAttributesToProduct(Product product) throws Exception {
		if (product.getAttributeGroup() == null) {
			return;
		}
		Collection<ProductAttribute> attrValues = new ArrayList<ProductAttribute>();

		IAttributeGroupAttributeService srv = (IAttributeGroupAttributeService) this
				.findEntityService(AttributeGroupAttribute.class);

		List<AttributeGroupAttribute> groupAttributes = srv
				.findByGroupId(product.getAttributeGroup().getId());
		// Collection<ProductAttribute> attributes =
		// product.getAttributeGroup().getAttributes();
		for (AttributeGroupAttribute groupAttribute : groupAttributes) {
			ProductAttribute attrValue = new ProductAttribute();
			attrValue.setGroupAttribute(groupAttribute);
			attrValue.setProduct(product);
			attrValues.add(attrValue);
		}
		product.setAttributes(attrValues);
	}

	/**
	 * Delete all attributes linked to a product.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void deleteAttributesFromProduct(Product product) throws Exception {
		String jql = "delete from " + ProductAttribute.class.getSimpleName()
				+ " e where e.product.id = :productId ";
		this.em.createQuery(jql).setParameter("groupAttrId", product.getId())
				.executeUpdate();
	}

	/**
	 * Synchronize product attributes with the attribute-group attributes. For
	 * performance reasons ensure it is called only when is necessary i.e. when
	 * the attribute group attached to the product is changed.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void synchronizeProductAttributes(Product product) throws Exception {
		if (product.getAttributeGroup() == null) {
			this.deleteAttributesFromProduct(product);
			return;
		}

		Long productId = product.getId();
		Long groupId = product.getAttributeGroup().getId();

		String deleteJpl = "delete from "
				+ ProductAttribute.class.getSimpleName()
				+ " e"
				+ " where e.product.id = :productId "
				+ "  and e.groupAttribute.group.id != e.product.attributeGroup.id ";

		this.em.createQuery(deleteJpl).setParameter("productId", productId)
		// .setParameter("groupId", groupId )
				.executeUpdate();

		// this.em.createQuery("delete from ProductAttributeValue e where e.product.id = :productId"
		// +
		// " and e.attribute.id not in " +
		// "(select attr.id from ProductAttributeGroup pag, IN(pag.attributes) attr  where pag.id = :groupId  ) ")
		// .setParameter("productId", productId)
		// .setParameter("groupId", groupId )
		// .executeUpdate();
		this.em.flush();

		// add the missing ones
		Collection<ProductAttribute> attrValues = new ArrayList<ProductAttribute>();
		String addJpl = "select e from "
				+ AttributeGroupAttribute.class.getSimpleName() + " e"
				+ " where e.group.id = :groupId "
				+ "  and e.id not in ( select v.groupAttribute.id from "
				+ ProductAttribute.class.getSimpleName()
				+ " v where v.product.id = :productId ) ";

		List<AttributeGroupAttribute> groupAttributes = this.em.createQuery(
				addJpl).setParameter("productId", productId).setParameter(
				"groupId", groupId).getResultList();

		for (AttributeGroupAttribute groupAttribute : groupAttributes) {

			ProductAttribute attrValue = new ProductAttribute();
			attrValue.setGroupAttribute(groupAttribute);
			attrValue.setProduct(product);
			attrValues.add(attrValue);
			this.em.persist(attrValue);
		}
		product.setAttributes(attrValues);

		/*
		 * "" +
		 * "select attr from ProductAttributeGroup pag, IN(pag.attributes) attr"
		 * + "  where pag.id = :groupId  " +
		 * "  and attr.id not in (select val.attribute.id from ProductAttributeValue val where val.product.id = :productId) "
		 */

	}
}
