Ext.ns('net.nan21.dnet.module.ad.menu');
var BUNDLE_ID = "nan21.dnet.module.ad.ui.extjs";
net.nan21.dnet.module.ad.menu.ad = [
 
	{"id":"sm_sys", "text":"System", leaf:false, children:[
 
	{"id":"sm_sys_impex", "text":"Import-Export", leaf:false, children:[
		
		{id:"ImportMapItem_UI", text:Dnet.translate("ui","ImportMapItem_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportMap_UI", text:Dnet.translate("ui","ImportMap_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportMap_UI", _bundle_:BUNDLE_ID},		
		{id:"ImportJob_UI", text:Dnet.translate("ui","ImportJob_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_sys_system", "text":"System components", leaf:false, children:[
		
		{id:"SysDataSources_UI", text:Dnet.translate("ui","SysDataSources_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_sys_report", "text":"Report integration", leaf:false, children:[
		
		{id:"ReportServers_UI", text:Dnet.translate("ui","ReportServers_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.report.frame.ReportServers_UI", _bundle_:BUNDLE_ID},		
		{id:"Reports_UI", text:Dnet.translate("ui","Reports_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.report.frame.Reports_UI", _bundle_:BUNDLE_ID}	]}
	]}
 ,		 
	{"id":"sm_org", "text":"Organization", leaf:false, children:[
 
	{"id":"sm_org_usr", "text":"User management", leaf:false, children:[
		
		{id:"UserGroups_UI", text:Dnet.translate("ui","UserGroups_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", _bundle_:BUNDLE_ID},		
		{id:"Roles", text:Dnet.translate("ui","Role_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Role_UI", _bundle_:BUNDLE_ID},		
		{id:"Users", text:Dnet.translate("ui","Users_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.usr.frame.Users_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_org_org", "text":"Organizations", leaf:false, children:[
		
		{id:"OrgType_UI", text:Dnet.translate("ui","OrgType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.org.frame.OrgType_UI", _bundle_:BUNDLE_ID},		
		{id:"Org_UI", text:Dnet.translate("ui","Org_UI"), leaf:true, _frame_:"net.nan21.dnet.module.ad.org.frame.Org_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.ad == undefined) {
	Dnet.navigationTreeMenus.ad = { name: "mbMenuAD" , title :"AD: Administration", children: [] };
}       
    Dnet.navigationTreeMenus.ad.children = Dnet.navigationTreeMenus.ad.children.concat(net.nan21.dnet.module.ad.menu.ad);
