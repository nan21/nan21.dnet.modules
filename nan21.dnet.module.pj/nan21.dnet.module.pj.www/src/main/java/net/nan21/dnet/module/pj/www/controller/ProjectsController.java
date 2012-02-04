package net.nan21.dnet.module.pj.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.pj.md.ds.filter.ProjectDsFilter;
import net.nan21.dnet.module.pj.md.ds.model.ProjectDs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "request")
@RequestMapping("/projects")
public class ProjectsController extends AbstractWebController {

	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
 		  
			IDsService service = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName());
			
			service.setSystemConfig(this.systemConfig);
			ProjectDsFilter filter = new ProjectDsFilter();
			filter.setActive(true);
			filter.setClientId(Session.user.get().getClientId());
			IQueryBuilder builder = service.createQueryBuilder();			 
			List<ProjectDs> projects =  (List<ProjectDs>)service.find(filter, null, builder);
			
			
			return new ModelAndView("projectList")
//				.addObject("categ_icon_baseurl", this.getSystemConfig().getSysParamValue("MM_PRODCATEG_ICON_BASEURL"))
//				.addObject("categ_icon_ext", this.getSystemConfig().getSysParamValue("MM_PRODCATEG_ICON_EXT"))
//				.addObject("manufact_icon_baseurl", this.getSystemConfig().getSysParamValue("MM_MANUFACT_ICON_BASEURL"))
//				.addObject("manufact_icon_ext", this.getSystemConfig().getSysParamValue("MM_MANUFACT_ICON_EXT"))
//				.addObject("categories", categories)
				.addObject("projects", projects);

		} finally {
			this.finishRequest();
		}
	}
 
}
