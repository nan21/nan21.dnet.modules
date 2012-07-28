package net.nan21.dnet.module.md.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Session;

import net.nan21.dnet.module.ad.data.ds.filter.AttachmentDsFilter;
import net.nan21.dnet.module.ad.data.ds.model.AttachmentDs;

import net.nan21.dnet.module.md.mm.prod.ds.filter.ProductAttributeValueDsFilter;
import net.nan21.dnet.module.md.mm.prod.ds.filter.ProductCategoryDsFilter;
import net.nan21.dnet.module.md.mm.prod.ds.filter.ProductDsFilter;
import net.nan21.dnet.module.md.mm.prod.ds.filter.ProductManufacturerDsFilter;

import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeValueDs;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductCategoryDs;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerDs;
import net.nan21.dnet.module.md.mm.prod.ds.param.ProductDsParam;

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

			List categories = this.getCategories();
			List manufacturers = this.getManufacturers();

			return new ModelAndView("home").addObject(
					"categ_icon_baseurl",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODCATEG_ICON_BASEURL")).addObject(
					"categ_icon_ext",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODCATEG_ICON_EXT")).addObject(
					"manufact_icon_baseurl",
					this.getSystemConfig().getSysParamValue(
							"MM_MANUFACT_ICON_BASEURL")).addObject(
					"manufact_icon_ext",
					this.getSystemConfig().getSysParamValue(
							"MM_MANUFACT_ICON_EXT")).addObject("categories",
					categories).addObject("manufacturers", manufacturers);

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
			ProductDsFilter filter = new ProductDsFilter();
			filter.setActive(true);
			filter.setShowInCatalog(true);
			filter.setClientId(Session.user.get().getClientId());

			if (request.getParameter("categoryId") != null) {
				param.setProductCategoryId(Long.parseLong(request
						.getParameter("categoryId")));
			}
			if (request.getParameter("manufacturerId") != null) {
				filter.setManufacturerId(Long.parseLong(request
						.getParameter("manufacturerId")));
			}

			List<ProductDs> products = service.find(filter, param, builder);
			List<ProductCategoryDs> categories = this.getCategories();
			List<ProductManufacturerDs> manufacturers = this.getManufacturers();

			return new ModelAndView("productList").addObject(
					"product_icon_baseurl",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_ICON_BASEURL")).addObject(
					"product_icon_ext",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_ICON_EXT")).addObject(
					"product_icon_suffix",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_ICON_SUFFIX")).addObject("categories",
					categories).addObject("manufacturers", manufacturers)
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
			ProductDs product = (ProductDs) productService.findById(request
					.getParameter("id"));

			if (product == null) {
				throw new Exception("Requested product not found.");
			}

			IDsService attributesService = this
					.findDsService(ProductAttributeValueDs.class);
			ProductAttributeValueDsFilter attributesFilter = new ProductAttributeValueDsFilter();
			attributesFilter.setProductId(product.getId());
			List attributes = attributesService.find(attributesFilter, null,
					attributesService.createQueryBuilder().addSortInfo(
							new String[] { ProductAttributeValueDs.fCATEGORY,
									ProductAttributeValueDs.fTITLE }));

			IDsService attachmentsService = this
					.findDsService(AttachmentDs.class);
			AttachmentDsFilter attachmentsFilter = new AttachmentDsFilter();
			attachmentsFilter.setTargetType(product.getEntityFQN());
			attachmentsFilter.setTargetUuid(product.getUuid());
			// attachmentsFilter.setTargetType(product.getBusinessObject());
			List attachments = attachmentsService.find(attachmentsFilter, null,
					null);

			List categories = this.getCategories();

			return new ModelAndView("productView").addObject(
					"product_image_baseurl",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_IMAGE_BASEURL")).addObject(
					"product_image_ext",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_IMAGE_EXT")).addObject(
					"product_image_suffix",
					this.getSystemConfig().getSysParamValue(
							"MM_PRODUCT_IMAGE_SUFFIX")).addObject("categories",
					categories).addObject("product", product).addObject(
					"attributes", attributes).addObject("attachments",
					attachments);

		} finally {
			this.finishRequest();
		}

	}

	protected List<ProductCategoryDs> getCategories() throws Exception {
		IDsService service = this.serviceLocator
				.findDsService(ProductCategoryDs.class.getSimpleName());
		service.setSystemConfig(this.systemConfig);
		ProductCategoryDsFilter filter = new ProductCategoryDsFilter();
		filter.setActive(true);
		filter.setClientId(Session.user.get().getClientId());
		IQueryBuilder builder = service.createQueryBuilder();
		return (List<ProductCategoryDs>) service.find(filter, null, builder);
	}

	protected List getManufacturers() throws Exception {
		IDsService service = this.serviceLocator
				.findDsService(ProductManufacturerDs.class.getSimpleName());
		service.setSystemConfig(this.systemConfig);
		ProductManufacturerDsFilter filter = new ProductManufacturerDsFilter();
		filter.setActive(true);
		filter.setClientId(Session.user.get().getClientId());
		IQueryBuilder builder = service.createQueryBuilder();
		return service.find(filter, null, builder);
	}

}
