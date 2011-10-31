
Ext.ns('net.nan21.dnet.module.pj.menu');
var BUNDLE_ID = "nan21.dnet.module.pj.ui.extjs";

net.nan21.dnet.module.pj.menu.crm = [
 
	{"id":"sm_pj", "text":"Project Management", leaf:false, children:[
 
	{"id":"sm_pj_base", "text":"Definitions", leaf:false, children:[
		
		{id:"ProjectBaseData_UI", text:Dnet.translate("ui","ProjectBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"ItemBaseData_UI", text:Dnet.translate("ui","ItemBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI", _bundle_:BUNDLE_ID}	]}
,		
		{id:"Projects_UI", text:Dnet.translate("ui","Projects_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.base.frame.Projects_UI", _bundle_:BUNDLE_ID},		
		{id:"Items_UI", text:Dnet.translate("ui","Items_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.Items_UI", _bundle_:BUNDLE_ID},		
		{id:"ItemTask_UI", text:Dnet.translate("ui","ItemTask_UI"), leaf:true, _frame_:"net.nan21.dnet.module.pj.md.frame.ItemTask_UI", _bundle_:BUNDLE_ID}	]}
 
   ];  
if (Dnet.navigationTreeMenus.crm == undefined) {
	Dnet.navigationTreeMenus.crm = { name: "mbMenuCRM" , title :"CRM: Customer Relationships", children: [] };
}       
    Dnet.navigationTreeMenus.crm.children = Dnet.navigationTreeMenus.crm.children.concat(net.nan21.dnet.module.pj.menu.crm);
    
