package net.nan21.dnet.module.pj.www.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.module.pj.md.ds.model.ProjectDs;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "request")
@RequestMapping("/dc")
public class DcController<M, F, P> extends AbstractWebController {

	@RequestMapping("/view/{resourceName}/{viewName}")
	public ModelAndView view(
			@PathVariable String resourceName,
			@PathVariable String viewName,
			@RequestParam(value = "__resultStart", required = false, defaultValue = "0") int resultStart,
			@RequestParam(value = "__resultSize", required = false, defaultValue = "100") int resultSize,
			@RequestParam(value = "__orderByCol", required = false, defaultValue = "") String orderByCol,
			@RequestParam(value = "__orderBySense", required = false, defaultValue = "") String orderBySense,
			@RequestParam(value = "__orderBy", required = false, defaultValue = "") String orderBy,
			HttpServletRequest request) throws Exception {

		// IDsService projectService =
		// this.serviceLocator.findDsService(ProjectDs.class.getSimpleName());
		IDsService<M, F, P> service = this.findDsService(resourceName);
		service.setSystemConfig(this.systemConfig);
	 
		P params = service.getParamClass().newInstance();
		 
		Object id = request.getParameter("id");
		if (id == null) {
			throw new Exception("Empty ID"); 
		}
		
		Object model = service.findById(id, params);
		  
		return new ModelAndView(resourceName + "$" + viewName).addObject("ds",
				model);

	}

	@RequestMapping("/list/{resourceName}/{viewName}")
	public ModelAndView list(
			@PathVariable String resourceName,
			@PathVariable String viewName,
			@RequestParam(value = "__resultStart", required = false, defaultValue = "0") int resultStart,
			@RequestParam(value = "__resultSize", required = false, defaultValue = "100") int resultSize,
			@RequestParam(value = "__orderByCol", required = false, defaultValue = "") String orderByCol,
			@RequestParam(value = "__orderBySense", required = false, defaultValue = "") String orderBySense,
			@RequestParam(value = "__orderBy", required = false, defaultValue = "") String orderBy,
			HttpServletRequest request) throws Exception {

		// IDsService projectService =
		// this.serviceLocator.findDsService(ProjectDs.class.getSimpleName());
		IDsService<M, F, P> service = this.findDsService(resourceName);
		service.setSystemConfig(this.systemConfig);
		IQueryBuilder<M, F, P> qb = service.createQueryBuilder();
		qb.addFetchLimit(resultStart, resultSize);

		F filter = service.getFilterClass().newInstance();
		P params = service.getParamClass().newInstance();

		BeanUtils.populate(filter, request.getParameterMap());
		BeanUtils.populate(params, request.getParameterMap());
		
		List<M> list = service.find(filter, params, qb);

		return new ModelAndView(resourceName + "$" + viewName).addObject(
				"list", list);

	}

	protected void populateFilter(F filter, HttpServletRequest request)
			throws Exception { 
		BeanUtils.populate(filter, request.getParameterMap());
	}

}
