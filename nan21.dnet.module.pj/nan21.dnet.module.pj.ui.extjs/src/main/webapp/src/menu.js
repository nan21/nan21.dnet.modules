
Ext.ns('net.nan21.dnet.module.pj.menu');
var BUNDLE_ID = "nan21.dnet.module.pj.ui.extjs";

net.nan21.dnet.module.pj.menu.pim = [
 
	{"id":"pim_base", "text":"Definitions", leaf:false, children:[
		
		{id:"ProjectBaseData_UI", text:Dnet.translate("ui","ProjectBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"IssueBaseData_UI", text:Dnet.translate("ui","IssueBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"pim_project", "text":"Projects", leaf:false, children:[
		
		{id:"Projects_UI", text:Dnet.translate("ui","Projects_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.Projects_UI", _bundle_:BUNDLE_ID},		
		{id:"ProjectVersions_UI", text:Dnet.translate("ui","ProjectVersions_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.ProjectVersions_UI", _bundle_:BUNDLE_ID},		
		{id:"IssueRoadmap_UI", text:Dnet.translate("ui","IssueRoadmap_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI", _bundle_:BUNDLE_ID},		
		{id:"IssueChangelog_UI", text:Dnet.translate("ui","IssueChangelog_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI", _bundle_:BUNDLE_ID}	]}
 ,		 
	{"id":"pim_issue", "text":"Incidents", leaf:false, children:[
		
		{id:"Issues_UI", text:Dnet.translate("ui","Issues_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.Issues_UI", _bundle_:BUNDLE_ID},		
		{id:"IssuesMnt_UI", text:Dnet.translate("ui","IssuesMnt_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI", _bundle_:BUNDLE_ID},		
		{id:"IssueTask_UI", text:Dnet.translate("ui","IssueTask_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.IssueTask_UI", _bundle_:BUNDLE_ID}	]}
 
   ];  
if (Dnet.navigationTreeMenus.pim == undefined) {
	Dnet.navigationTreeMenus.pim = { name: "mbMenuPIM" , title :"PIM: Project & Incident Management", children: [] };
}       
    Dnet.navigationTreeMenus.pim.children = Dnet.navigationTreeMenus.pim.children.concat(net.nan21.dnet.module.pj.menu.pim);
    
