
Ext.ns('net.nan21.dnet.module.ad.menu');
var BUNDLE_ID = "nan21.dnet.module.ad.ui.extjs";

net.nan21.dnet.module.ad.menu.ad = [
 
	{"id":"sm_ad_sys", "text":"System", leaf:false, children:[
 
	{"id":"sm_ad_client", "text":"Client", leaf:false, children:[
		
		{id:"Client_UI", text:Dnet.translate("ui","Client_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.client.frame.Client_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_user", "text":"User management", leaf:false, children:[
		
		{id:"UserGroups_UI", text:Dnet.translate("ui","UserGroups_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", _bundle_:BUNDLE_ID},		
		{id:"UserTypes_UI", text:Dnet.translate("ui","UserTypes_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.UserTypes_UI", _bundle_:BUNDLE_ID},		
		{id:"Roles", text:Dnet.translate("ui","Role_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Role_UI", _bundle_:BUNDLE_ID},		
		{id:"Users", text:Dnet.translate("ui","Users_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Users_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_system", "text":"System components", leaf:false, children:[
		
		{id:"SysDataSources_UI", text:Dnet.translate("ui","SysDataSources_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_impex", "text":"Import-Export", leaf:false, children:[
		
		{id:"ImportMapItem_UI", text:Dnet.translate("ui","ImportMapItem_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportMap_UI", text:Dnet.translate("ui","ImportMap_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMap_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportJob_UI", text:Dnet.translate("ui","ImportJob_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_ad_workflow", "text":"Workflow", leaf:false, children:[
		
		{id:"WorkflowDef_UI", text:Dnet.translate("ui","WorkflowDef_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", _bundle_:BUNDLE_ID},		
		{id:"Workflow_UI", text:Dnet.translate("ui","WorkflowAdmin_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.ad == undefined) {
	Dnet.navigationTreeMenus.ad = { name: "mbMenuAD" , title :"AD: Administration", children: [] };
}       
    Dnet.navigationTreeMenus.ad.children = Dnet.navigationTreeMenus.ad.children.concat(net.nan21.dnet.module.ad.menu.ad);
   
Ext.ns('net.nan21.dnet.module.ad.menu');
var BUNDLE_ID = "nan21.dnet.module.ad.ui.extjs";

net.nan21.dnet.module.ad.menu.my = [
		
		{id:"WorkflowTodo_UI", text:Dnet.translate("ui","WorkflowTodo_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI", _bundle_:BUNDLE_ID} 
   ];  
if (Dnet.navigationTreeMenus.my == undefined) {
	Dnet.navigationTreeMenus.my = { name: "mbMenuMY" , title :"MY: My Dnet", children: [] };
}       
    Dnet.navigationTreeMenus.my.children = Dnet.navigationTreeMenus.my.children.concat(net.nan21.dnet.module.ad.menu.my);
    
