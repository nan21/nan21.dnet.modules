package net.nan21.dnet.module.md._businessdelegates.mm.prod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeSetAttributeService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

public class SynchronizeProductAttributeBD extends AbstractBusinessDelegate {

	/**
	 * Add attribute values to a product based on the attribute set specified at
	 * product level.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void addAttributesToProduct(Product product) throws Exception {
		if (product.getAttributeSet() == null) {
			return;
		}
		Collection<ProductAttributeValue> attrValues = new ArrayList<ProductAttributeValue>();

		IAttributeSetAttributeService srv = (IAttributeSetAttributeService) this
				.findEntityService(AttributeSetAttribute.class);

		List<AttributeSetAttribute> asas = srv.findByAttributeSetId(product
				.getAttributeSet().getId());

		for (AttributeSetAttribute asa : asas) {
			ProductAttributeValue attrValue = new ProductAttributeValue();
			attrValue.setAttribute(asa.getAttribute());
			attrValue.setProduct(product);
			attrValues.add(attrValue);
		}
		product.setAttributeValues(attrValues);
	}

	/**
	 * Delete all attribute values linked to a product.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void deleteAttributesFromProduct(Product product) throws Exception {
		String jql = "delete from "
				+ ProductAttributeValue.class.getSimpleName()
				+ " e where e.product.id = :productId ";
		this.em.createQuery(jql).setParameter("productId", product.getId())
				.executeUpdate();
	}

	/**
	 * Synchronize product attributes with the attribute-set attributes. For
	 * performance reasons ensure it is called only when is necessary i.e. when
	 * the attribute set attached to the product is changed.
	 * 
	 * @param product
	 * @throws Exception
	 */
	public void synchronizeProductAttributes(Product product) throws Exception {
		if (product.getAttributeSet() == null) {
			this.deleteAttributesFromProduct(product);
			return;
		}

		Long productId = product.getId();
		Long setId = product.getAttributeSet().getId();

		String deleteJpl = "delete from "
				+ ProductAttributeValue.class.getSimpleName() + " e"
				+ " where e.product.id = :productId "
				+ "  and e.attribute.id not in (" + "select t.attribute.id "
				+ "  from " + AttributeSetAttribute.class.getSimpleName()
				+ " t " + " where t.attributeSet.id = :setId )  ";

		this.em.createQuery(deleteJpl).setParameter("productId", productId)
				.setParameter("setId", setId).executeUpdate();

		this.em.flush();

		// add the missing ones
		Collection<ProductAttributeValue> attrValues = new ArrayList<ProductAttributeValue>();
		String addJpl = "select e from "
				+ AttributeSetAttribute.class.getSimpleName() + " e"
				+ " where e.attributeSet.id = :setId "
				+ "  and e.attribute.id not in ( select v.attribute.id from "
				+ ProductAttributeValue.class.getSimpleName()
				+ " v where v.product.id = :productId ) ";

		List<AttributeSetAttribute> groupAttributes = this.em.createQuery(
				addJpl, AttributeSetAttribute.class).setParameter("productId",
				productId).setParameter("setId", setId).getResultList();

		for (AttributeSetAttribute groupAttribute : groupAttributes) {

			ProductAttributeValue attrValue = new ProductAttributeValue();
			attrValue.setAttribute(groupAttribute.getAttribute());
			attrValue.setProduct(product);
			attrValues.add(attrValue);
			this.em.persist(attrValue);
		}
		product.setAttributeValues(attrValues);

	}
}
