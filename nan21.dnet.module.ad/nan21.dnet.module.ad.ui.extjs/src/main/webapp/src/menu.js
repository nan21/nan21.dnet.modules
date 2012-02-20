
Ext.ns('net.nan21.dnet.module.ad.menu');
var BUNDLE_ID = "nan21.dnet.module.ad.ui.extjs";

net.nan21.dnet.module.ad.menu.ad = [
 
	{"id":"sm_ad_sys", "text":"System", leaf:false, children:[
 
	{"id":"sm_ad_client", "text":"Client", leaf:false, children:[
		
		{id:"MyClient_UI", text:Dnet.translate("ui","MyClient_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.client.frame.MyClient_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_user", "text":"User management", leaf:false, children:[
		
		{id:"UserGroups_UI", text:Dnet.translate("ui","UserGroups_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", _bundle_:BUNDLE_ID},		
		{id:"UserTypes_UI", text:Dnet.translate("ui","UserTypes_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.UserTypes_UI", _bundle_:BUNDLE_ID},		
		{id:"Roles", text:Dnet.translate("ui","Role_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Role_UI", _bundle_:BUNDLE_ID},		
		{id:"Users", text:Dnet.translate("ui","Users_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Users_UI", _bundle_:BUNDLE_ID},		
		{id:"Menu_UI", text:Dnet.translate("ui","Menu_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Menu_UI", _bundle_:BUNDLE_ID},		
		{id:"AccessControl_UI", text:Dnet.translate("ui","AccessControl_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.AccessControl_UI", _bundle_:BUNDLE_ID},		
		{id:"DsAccessControl_UI", text:Dnet.translate("ui","DsAccessControl_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI", _bundle_:BUNDLE_ID},		
		{id:"DsMethodAccessControl_UI", text:Dnet.translate("ui","DsMethodAccessControl_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.DsMethodAccessControl_UI", _bundle_:BUNDLE_ID},		
		{id:"AsgnAccessControl_UI", text:Dnet.translate("ui","AsgnAccessControl_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI", _bundle_:BUNDLE_ID},		
		{id:"Assignables_UI", text:Dnet.translate("ui","Assignables_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Assignables_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_system", "text":"System components", leaf:false, children:[
		
		{id:"SysDataSources_UI", text:Dnet.translate("ui","SysDataSources_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", _bundle_:BUNDLE_ID},		
		{id:"SysParam_UI", text:Dnet.translate("ui","SysParam_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.SysParam_UI", _bundle_:BUNDLE_ID},		
		{id:"SysDateFormat_UI", text:Dnet.translate("ui","SysDateFormat_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI", _bundle_:BUNDLE_ID},		
		{id:"UiViewState_UI", text:Dnet.translate("ui","UiViewState_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.UiViewState_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_report", "text":"Report integration", leaf:false, children:[
		
		{id:"ReportServers_UI", text:Dnet.translate("ui","ReportServers_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.report.frame.ReportServers_UI", _bundle_:BUNDLE_ID},		
		{id:"Reports_UI", text:Dnet.translate("ui","Reports_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.report.frame.Reports_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_data", "text":"Data", leaf:false, children:[
		
		{id:"AttachmentType_UI", text:Dnet.translate("ui","AttachmentType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.data.frame.AttachmentType_UI", _bundle_:BUNDLE_ID},		
		{id:"Attachments_UI", text:Dnet.translate("ui","Attachments_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.data.frame.Attachments_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_impex", "text":"Import-Export", leaf:false, children:[
 
	{"id":"sm_ad_impex_imp", "text":"Import", leaf:false, children:[
		
		{id:"ImportMapItem_UI", text:Dnet.translate("ui","ImportMapItem_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportMap_UI", text:Dnet.translate("ui","ImportMap_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMap_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportJob_UI", text:Dnet.translate("ui","ImportJob_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_impex_exp", "text":"Export", leaf:false, children:[
		
		{id:"CsvExport_UI", text:Dnet.translate("ui","CsvExport_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.CsvExport_UI", _bundle_:BUNDLE_ID},		
		{id:"ExportMap_UI", text:Dnet.translate("ui","ExportMap_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ExportMap_UI", _bundle_:BUNDLE_ID},		
		{id:"ExportJob_UI", text:Dnet.translate("ui","ExportJob_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ExportJob_UI", _bundle_:BUNDLE_ID}	]}
	]}
,		 
	{"id":"sm_ad_workflow", "text":"Workflow", leaf:false, children:[
		
		{id:"WorkflowDef_UI", text:Dnet.translate("ui","WorkflowDef_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", _bundle_:BUNDLE_ID},		
		{id:"Workflow_UI", text:Dnet.translate("ui","WorkflowAdmin_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI", _bundle_:BUNDLE_ID},		
		{id:"WorkflowTodo_UI", text:Dnet.translate("ui","WorkflowTodo_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.ad == undefined) {
	Dnet.navigationTreeMenus.ad = { name: "mbMenuAD" , title :"AD: Administration", children: [] };
}       
    Dnet.navigationTreeMenus.ad.children = Dnet.navigationTreeMenus.ad.children.concat(net.nan21.dnet.module.ad.menu.ad);
    
