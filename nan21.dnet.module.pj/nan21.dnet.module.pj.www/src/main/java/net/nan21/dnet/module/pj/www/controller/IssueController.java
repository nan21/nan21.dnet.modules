package net.nan21.dnet.module.pj.www.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "request")
@RequestMapping("/issue")

public class IssueController extends AbstractWebController {


	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request) throws Exception {

		try {
			this.prepareRequest(); 
 		  
			return new ModelAndView("home");
//				.addObject("categ_icon_baseurl", this.getSystemConfig().getSysParamValue("MM_PRODCATEG_ICON_BASEURL"))
//				.addObject("categ_icon_ext", this.getSystemConfig().getSysParamValue("MM_PRODCATEG_ICON_EXT"))
//				.addObject("manufact_icon_baseurl", this.getSystemConfig().getSysParamValue("MM_MANUFACT_ICON_BASEURL"))
//				.addObject("manufact_icon_ext", this.getSystemConfig().getSysParamValue("MM_MANUFACT_ICON_EXT"))
//				.addObject("categories", categories)
//				.addObject("manufacturers", manufacturers);

		} finally {
			this.finishRequest();
		}
	}
	
}
