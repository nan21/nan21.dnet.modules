package net.nan21.dnet.module.pj.www.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.action.SortToken;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Session;

import net.nan21.dnet.module.pj.md.ds.filter.IssueChangelogDsFilter;
import net.nan21.dnet.module.pj.md.ds.filter.IssueDsFilter;
import net.nan21.dnet.module.pj.md.ds.filter.IssueRoadmapDsFilter;
import net.nan21.dnet.module.pj.md.ds.filter.ProjectComponentDsFilter;
import net.nan21.dnet.module.pj.md.ds.filter.ProjectVersionDsFilter;
import net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDs;
import net.nan21.dnet.module.pj.md.ds.model.IssueDs;
import net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs;
import net.nan21.dnet.module.pj.md.ds.model.ProjectComponentDs;
import net.nan21.dnet.module.pj.md.ds.model.ProjectDs;
import net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "request")
@RequestMapping("/project")

public class ProjectController extends AbstractWebController {

	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
			
			IDsService projectService = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName()); 
			projectService.setSystemConfig(this.systemConfig);
			ProjectDs project = (ProjectDs) projectService.findById( request.getParameter("id") );
			
			if (project == null) {
				throw new Exception("Requested project not found.");
			}
			
			Long projectId = project.getId();
			
			 
			//components
			IDsService service = this.serviceLocator.findDsService(ProjectComponentDs.class.getSimpleName()); 
			service.setSystemConfig(this.systemConfig);
			
			ProjectComponentDsFilter filter = new ProjectComponentDsFilter();
			filter.setActive(true);		
			filter.setProjectId(projectId);
			filter.setClientId(Session.user.get().getClientId());
			 
			List<ProjectVersionDs> components = service.find(filter, null, service.createQueryBuilder());
			
			// updated issues
			IDsService issueService = this.serviceLocator.findDsService(IssueDs.class.getSimpleName()); 
			issueService.setSystemConfig(this.systemConfig);
			IssueDsFilter issueFilter = new IssueDsFilter();
			issueFilter.setClientId(Session.user.get().getClientId());
			issueFilter.setProjectId(projectId);
			IQueryBuilder  issueQb = issueService.createQueryBuilder();
			List<SortToken> issueSortTokens = new ArrayList<SortToken>() ;
			issueSortTokens.add(new SortToken(IssueDs.fMODIFIEDAT, "DESC"));
			issueQb.addSortInfo(issueSortTokens);
			issueQb.addFetchLimit(0, 5);
			List<ProjectVersionDs> updIssues = issueService.find(issueFilter, null, issueQb);	
			
			return new ModelAndView("projectView")
				.addObject("projectId", projectId )
				.addObject("project", project )
				.addObject("updIssues", updIssues )
				.addObject("components", components );

		} finally {
			this.finishRequest();
		}
	}
	
	
	
	
	@RequestMapping("/versions")
	public ModelAndView versions(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
			
			IDsService projectService = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName()); 
			projectService.setSystemConfig(this.systemConfig);
			ProjectDs project = (ProjectDs) projectService.findById( request.getParameter("id") );
			
			if (project == null) {
				throw new Exception("Requested project not found.");
			}
			
			Long projectId = project.getId();
			
			IDsService service = this.serviceLocator.findDsService(ProjectVersionDs.class.getSimpleName()); 
			service.setSystemConfig(this.systemConfig);
			
			ProjectVersionDsFilter filter = new ProjectVersionDsFilter();
			filter.setActive(true);		
			filter.setProjectId(projectId);
			filter.setClientId(Session.user.get().getClientId());
			
			List<SortToken> sorts = new ArrayList<SortToken>() ;
			sorts.add(new SortToken(ProjectVersionDs.fPLANDATE, "DESC"));
			
			
			IQueryBuilder  qb = service.createQueryBuilder();
			qb.addSortInfo(sorts);
			 
			List<ProjectVersionDs> versions = service.find(filter, null, qb);
			
			return new ModelAndView("versionsList")
				.addObject("projectId", projectId )
				.addObject("project", project )
				.addObject("versions", versions);
  
		} finally {
			this.finishRequest();
		}
	}
	
	
	@RequestMapping("/components")
	public ModelAndView components(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
			
			IDsService projectService = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName()); 
			projectService.setSystemConfig(this.systemConfig);
			ProjectDs project = (ProjectDs) projectService.findById( request.getParameter("id") );
			
			if (project == null) {
				throw new Exception("Requested project not found.");
			}
			
			Long projectId = project.getId();
			
			IDsService service = this.serviceLocator.findDsService(ProjectComponentDs.class.getSimpleName()); 
			service.setSystemConfig(this.systemConfig);
			
			ProjectComponentDsFilter filter = new ProjectComponentDsFilter();
			filter.setActive(true);		
			filter.setProjectId(projectId);
			filter.setClientId(Session.user.get().getClientId());
			 
			List<ProjectVersionDs> components = service.find(filter, null, service.createQueryBuilder());
			
			return new ModelAndView("componentsList")
				.addObject("projectId", projectId )
				.addObject("project", project )
				.addObject("components", components);
 
		} finally {
			this.finishRequest();
		}
	}
	
	
	@RequestMapping("/roadmap")
	public ModelAndView roadmap(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
			
			IDsService projectService = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName()); 
			projectService.setSystemConfig(this.systemConfig);
			ProjectDs project = (ProjectDs) projectService.findById( request.getParameter("id") );
			
			if (project == null) {
				throw new Exception("Requested project not found.");
			}
			
			Long projectId = project.getId();
			
			IDsService service = this.serviceLocator.findDsService(IssueRoadmapDs.class.getSimpleName()); 
			service.setSystemConfig(this.systemConfig);
			
			IssueRoadmapDsFilter filter = new IssueRoadmapDsFilter();			 
			filter.setProjectId(projectId);
			filter.setClientId(Session.user.get().getClientId());
			 
			List<ProjectVersionDs> issues = service.find(filter, null, service.createQueryBuilder());
			
			return new ModelAndView("roadmap")
				.addObject("projectId", projectId )
				.addObject("project", project )
				.addObject("issues", issues);
 

		} finally {
			this.finishRequest();
		}
	}
	
	
	@RequestMapping("/changelog")
	public ModelAndView changelog(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
			IDsService projectService = this.serviceLocator.findDsService(ProjectDs.class.getSimpleName()); 
			projectService.setSystemConfig(this.systemConfig);
			ProjectDs project = (ProjectDs) projectService.findById( request.getParameter("id") );
			
			if (project == null) {
				throw new Exception("Requested project not found.");
			}
			
			Long projectId = project.getId();
			
			IDsService service = this.serviceLocator.findDsService(IssueChangelogDs.class.getSimpleName()); 
			service.setSystemConfig(this.systemConfig);
			
			IssueChangelogDsFilter filter = new IssueChangelogDsFilter();			 
			filter.setProjectId(projectId);
			filter.setClientId(Session.user.get().getClientId());
			 
			List<ProjectVersionDs> issues = service.find(filter, null, service.createQueryBuilder());
			
			return new ModelAndView("changelog")
				.addObject("projectId", projectId )
				.addObject("project", project )
				.addObject("issues", issues);
			 

		} finally {
			this.finishRequest();
		}
	}
	
	
}
