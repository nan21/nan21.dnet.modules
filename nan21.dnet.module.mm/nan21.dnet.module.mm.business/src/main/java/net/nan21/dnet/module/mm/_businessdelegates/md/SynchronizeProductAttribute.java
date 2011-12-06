package net.nan21.dnet.module.mm._businessdelegates.md;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeValue;

public class SynchronizeProductAttribute extends AbstractBusinessDelegate{

	public void addAttributesToProduct(Product product) {
//		if (product.getAttributeGroup() == null) {
//			return;
//		}
//		Collection<ProductAttributeValue> attrValues = new ArrayList<ProductAttributeValue>();
//		Collection<ProductAttribute> attributes = product.getAttributeGroup().getAttributes();
//		for (ProductAttribute attribute: attributes) {
//			ProductAttributeValue attrValue = new ProductAttributeValue();
//			attrValue.setAttribute(attribute);
//			attrValue.setProduct(product);
//			attrValues.add(attrValue);
//		}
//		product.setAttributes(attrValues);
	}
	
	
	//"+ProductAttributeValue.class.getSimpleName()+ "
	//"+ProductAttribute.class.getSimpleName()+"
	public void synchronizeProductAttributes(Product product) {
//		Long productId = product.getId();
//		Long groupId = product.getAttributeGroup().getId();
//		
//		this.em.createQuery("delete from ProductAttributeValue e where e.product.id = :productId" +
//				" and e.attribute.id not in " +
//				"(select attr.id from ProductAttributeGroup pag, IN(pag.attributes) attr  where pag.id = :groupId  ) ")
//				.setParameter("productId", productId)
//				.setParameter("groupId", groupId )
//				.executeUpdate();		
//		this.em.flush();
//		List<ProductAttribute> attributes = this.em.createQuery("" +
//				"select attr from ProductAttributeGroup pag, IN(pag.attributes) attr" +
//				"  where pag.id = :groupId  " +
//				"  and attr.id not in (select val.attribute.id from ProductAttributeValue val where val.product.id = :productId) ")
//				.setParameter("productId", productId )
//				.setParameter("groupId", groupId )
//				.getResultList();
//		Collection<ProductAttributeValue> attrValues = new ArrayList<ProductAttributeValue>();		 
//		  
//		for (ProductAttribute attribute: attributes) {
//			System.out.print("attribute  name = "+attribute.getName() + " , id = " + attribute.getId());
//			ProductAttributeValue attrValue = new ProductAttributeValue();
//			attrValue.setAttribute(attribute);
//			attrValue.setProduct(product);
//			attrValues.add(attrValue);
//			this.em.persist(attrValue);
//		}

	} 
}
