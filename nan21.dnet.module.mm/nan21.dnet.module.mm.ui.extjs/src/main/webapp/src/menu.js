
Ext.ns('net.nan21.dnet.module.mm.menu');
var BUNDLE_ID = "nan21.dnet.module.mm.ui.extjs";

net.nan21.dnet.module.mm.menu.crm = [
 
	{"id":"sm_mm", "text":"Material Management", leaf:false, children:[
 
	{"id":"sm_mm_base", "text":"Definitions", leaf:false, children:[
		
		{id:"ProductBaseData_UI", text:Dnet.translate("ui","ProductBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductAttributeDefs_UI", text:Dnet.translate("ui","ProductAttributeDefs_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductAccountGroup_UI", text:Dnet.translate("ui","ProductAccountGroup_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductAccountGroup_UI", _bundle_:BUNDLE_ID},		
		{id:"InventoryBaseData_UI", text:Dnet.translate("ui","InventoryBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_mm_md", "text":"Master-data", leaf:false, children:[
		
		{id:"ProductCategory_UI", text:Dnet.translate("ui","ProductCategory_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductCategory_UI", _bundle_:BUNDLE_ID},		
		{id:"Product_UI", text:Dnet.translate("ui","Product_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.Product_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductAttributeValue_UI", text:Dnet.translate("ui","ProductAttributeValue_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.md.frame.ProductAttributeValue_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_mm_inventory", "text":"Inventory", leaf:false, children:[
		
		{id:"SubInventories_UI", text:Dnet.translate("ui","SubInventories_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI", _bundle_:BUNDLE_ID},		
		{id:"InvTransactions_UI", text:Dnet.translate("ui","InvTransactions_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.inventory.frame.InvTransactions_UI", _bundle_:BUNDLE_ID},		
		{id:"InvOperations_UI", text:Dnet.translate("ui","InvOperations_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.inventory.frame.InvOperations_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_mm_price", "text":"Price", leaf:false, children:[
		
		{id:"PriceList_UI", text:Dnet.translate("ui","PriceList_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.price.frame.PriceList_UI", _bundle_:BUNDLE_ID},		
		{id:"ProductPriceReport_UI", text:Dnet.translate("ui","ProductPriceReport_UI"), leaf:true, _frame_:"net.nan21.dnet.module.mm.price.frame.ProductPriceReport_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.crm == undefined) {
	Dnet.navigationTreeMenus.crm = { name: "mbMenuCRM" , title :"CRM: Customer Relationships", children: [] };
}       
    Dnet.navigationTreeMenus.crm.children = Dnet.navigationTreeMenus.crm.children.concat(net.nan21.dnet.module.mm.menu.crm);
    
