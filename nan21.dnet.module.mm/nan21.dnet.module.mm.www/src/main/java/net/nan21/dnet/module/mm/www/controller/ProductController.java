package net.nan21.dnet.module.mm.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
 
import net.nan21.dnet.module.ad.data.ds.model.AttachmentDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductCategoryDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerDs;
import net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerLovDs;
import net.nan21.dnet.module.mm.md.ds.param.ProductDsParam;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "request")
@RequestMapping("/product")
public class ProductController extends AbstractWebController {

	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
 
//			IDsService service = this.findDsService(ProductDs.class);			 
//			IQueryBuilder builder = service.createQueryBuilder().addFetchLimit(
//					0, 20);		
//			ProductDsParam param = new ProductDsParam();
//			ProductDs filter = new ProductDs();
//			filter.setActive(true);
//			
//			if( request.getParameter("categoryId") != null) {
//				param.setProductCategoryId( Long.parseLong( request.getParameter("categoryId") ));
//			} 
//			if( request.getParameter("manufacturerId") != null) {
//				filter.setManufacturerId( Long.parseLong( request.getParameter("manufacturerId") ));
//			} 
//			
//			List products = service.find(filter, param, builder);			 
			List categories = this.getCategories();
			List manufacturers = this.getManufacturers();
			
			return new ModelAndView("home")
				.addObject("categories", categories)
				.addObject("manufacturers", manufacturers);
				//.addObject("products", products);

		} finally {
			this.finishRequest();
		}
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
 
			IDsService service = this.findDsService(ProductDs.class);			 
			IQueryBuilder builder = service.createQueryBuilder().addFetchLimit(
					0, 20);		
			ProductDsParam param = new ProductDsParam();
			ProductDs filter = new ProductDs();
			filter.setActive(true);
			
			if( request.getParameter("categoryId") != null) {
				param.setProductCategoryId( Long.parseLong( request.getParameter("categoryId") ));
			} 
			if( request.getParameter("manufacturerId") != null) {
				filter.setManufacturerId( Long.parseLong( request.getParameter("manufacturerId") ));
			} 
			
			List products = service.find(filter, param, builder);			 
			List categories = this.getCategories();
			List manufacturers = this.getManufacturers();
			
			return new ModelAndView("productList")
				.addObject("categories", categories)
				.addObject("manufacturers", manufacturers)
				.addObject("products", products);

		} finally {
			this.finishRequest();
		}
	}

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest();
 
			IDsService productService = this.findDsService(ProductDs.class);	 
			ProductDs product = (ProductDs) productService.findById( request.getParameter("id") );
			
			if (product == null) {
				throw new Exception("Requested product not found.");
			}
			 
			IDsService attributesService = this.findDsService(ProductAttributeValueDs.class);
			ProductAttributeValueDs attributesFilter = new ProductAttributeValueDs();			
			attributesFilter.setProductId(product.getId());			
			List attributes = attributesService.find(attributesFilter, null, 
					attributesService.createQueryBuilder()
					.addSortInfo(new String[] { ProductAttributeValueDs.fTYPE, ProductAttributeValueDs.fTITLE  }));
			 
			IDsService attachmentsService = this.findDsService(ProductAttachmentDs.class);
			ProductAttachmentDs attachmentsFilter = new ProductAttachmentDs();			
			attachmentsFilter.setProductId(product.getId());	
			//attachmentsFilter.setTargetType(product.getBusinessObject());	
			List attachments = attachmentsService.find(attachmentsFilter, null, null);
			 
			List categories = this.getCategories();
			
			return new ModelAndView("productView")
				.addObject("categories", categories)
				.addObject("product", product )
				.addObject("attributes", attributes)			 
				.addObject("attachments", attachments);

		} finally {
			this.finishRequest();
		}

	}
 
	protected List getCategories() throws Exception {
		IDsService service = this.serviceLocator.findDsService(ProductCategoryDs.class.getSimpleName());
		service.setSystemConfig(this.systemConfig);
		ProductCategoryDs filter = new ProductCategoryDs();
		filter.setActive(true);
		IQueryBuilder builder = service.createQueryBuilder();			 
		return service.find(filter, null, builder);
	}
	
	protected List getManufacturers() throws Exception {
		IDsService service = this.serviceLocator.findDsService(ProductManufacturerDs.class.getSimpleName());
		service.setSystemConfig(this.systemConfig);
		ProductManufacturerDs filter = new ProductManufacturerDs();
		filter.setActive(true);
		IQueryBuilder builder = service.createQueryBuilder();			 
		return service.find(filter, null, builder);
	}
	
}
