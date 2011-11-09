
Ext.ns('net.nan21.dnet.module.sd.menu');
var BUNDLE_ID = "nan21.dnet.module.sd.ui.extjs";

net.nan21.dnet.module.sd.menu.crm = [
 
	{"id":"sm_sd", "text":"Sales & Distribution", leaf:false, children:[
 
	{"id":"sm_sd_opportunity", "text":"Opportunities", leaf:false, children:[
		
		{id:"OpportunityBaseData_UI", text:Dnet.translate("ui","OpportunityBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"Opportunity_UI", text:Dnet.translate("ui","Opportunity_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.opportunity.frame.Opportunity_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_sd_order", "text":"Orders", leaf:false, children:[
		
		{id:"SalesOrderBaseData_UI", text:Dnet.translate("ui","SalesOrderBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"SalesOrder_UI", text:Dnet.translate("ui","SalesOrder_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.order.frame.SalesOrder_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_sd_invoice", "text":"Invoices", leaf:false, children:[
		
		{id:"SalesInvoiceBaseData_UI", text:Dnet.translate("ui","SalesInvoiceBaseData_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI", _bundle_:BUNDLE_ID},		
		{id:"SalesInvoice_UI", text:Dnet.translate("ui","SalesInvoice_UI"), leaf:true, _frame_:"net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.crm == undefined) {
	Dnet.navigationTreeMenus.crm = { name: "mbMenuCRM" , title :"CRM: Customer Relationships", children: [] };
}       
    Dnet.navigationTreeMenus.crm.children = Dnet.navigationTreeMenus.crm.children.concat(net.nan21.dnet.module.sd.menu.crm);
    
