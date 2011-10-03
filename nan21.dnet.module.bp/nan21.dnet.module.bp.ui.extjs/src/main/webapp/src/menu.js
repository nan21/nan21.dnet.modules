
Ext.ns('net.nan21.dnet.module.bp.menu');
var BUNDLE_ID = "nan21.dnet.module.bp.ui.extjs";

net.nan21.dnet.module.bp.menu.crm = [
 
	{"id":"sm_bp", "text":"Business partners", leaf:false, children:[
 
	{"id":"sm_bp_base", "text":"Definitions", leaf:false, children:[
		
		{id:"BP_BaseData_UI", text:Dnet.translate("ui","BP_BaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"Bank_UI", text:Dnet.translate("ui","Bank_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.base.frame.Bank_UI", _bundle_:BUNDLE_ID},		
		{id:"CalendarEventTypeDef_UI", text:Dnet.translate("ui","CalendarEventTypeDef_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI", _bundle_:BUNDLE_ID}	]}
,		
		{id:"BPartner_UI", text:Dnet.translate("ui","BPartner_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.md.frame.BPartner_UI", _bundle_:BUNDLE_ID},		
		{id:"Contact_UI", text:Dnet.translate("ui","Contact_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.md.frame.Contact_UI", _bundle_:BUNDLE_ID},		
		{id:"BpAccount_UI", text:Dnet.translate("ui","BpAccount_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bp.md.frame.BpAccount_UI", _bundle_:BUNDLE_ID}	]}
 
   ];  
if (Dnet.navigationTreeMenus.crm == undefined) {
	Dnet.navigationTreeMenus.crm = { name: "mbMenuCRM" , title :"CRM: Customer Relationships", children: [] };
}       
    Dnet.navigationTreeMenus.crm.children = Dnet.navigationTreeMenus.crm.children.concat(net.nan21.dnet.module.bp.menu.crm);
    
