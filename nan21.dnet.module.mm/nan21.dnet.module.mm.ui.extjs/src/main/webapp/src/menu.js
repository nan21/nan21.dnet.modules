Ext.ns('net.nan21.dnet.module.mm.menu');
var BUNDLE_ID = "nan21.dnet.module.mm.ui.extjs";
net.nan21.dnet.module.mm.menu.crm = [
 
	{"id":"sm_mm", "text":"Material Management", leaf:false, children:[
 
	{"id":"sm_mm_base", "text":"Definitions", leaf:false, children:[
		
		{id:"ProductAccountGroup_UI", text:Dnet.translate("ui","ProductAccountGroup_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductAccountGroup_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductManufacturer_UI", text:Dnet.translate("ui","ProductManufacturer_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductManufacturer_UI", _bundle_:BUNDLE_ID}	]}
,		
		{id:"Product_UI", text:Dnet.translate("ui","Product_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.Product_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductCategory_UI", text:Dnet.translate("ui","ProductCategory_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductCategory_UI", _bundle_:BUNDLE_ID}	]}
 
   ];  
if (Dnet.navigationTreeMenus.crm == undefined) {
	Dnet.navigationTreeMenus.crm = { name: "mbMenuCRM" , title :"CRM: Customer Relationships", children: [] };
}       
    Dnet.navigationTreeMenus.crm.children = Dnet.navigationTreeMenus.crm.children.concat(net.nan21.dnet.module.mm.menu.crm);
