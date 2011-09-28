
Ext.ns('net.nan21.dnet.module.bd.menu');
var BUNDLE_ID = "nan21.dnet.module.bd.ui.extjs";

net.nan21.dnet.module.bd.menu.ad = [
 
	{"id":"sm_bd", "text":"Base data", leaf:false, children:[
 
	{"id":"sm_bd_uom", "text":"Measuring units", leaf:false, children:[
		
		{id:"UomType_UI", text:Dnet.translate("ui","UomType_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.uom.frame.UomType_UI", _bundle_:BUNDLE_ID},		
		{id:"Uoms", text:Dnet.translate("ui","Uoms_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.uom.frame.Uoms_UI", _bundle_:BUNDLE_ID},		
		{id:"UomMD_UI", text:Dnet.translate("ui","UomMD_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.uom.frame.UomMD_UI", _bundle_:BUNDLE_ID},		
		{id:"UomConversion_UI", text:Dnet.translate("ui","UomConversion_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.uom.frame.UomConversion_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_bd_currency", "text":"Currencies", leaf:false, children:[
		
		{id:"Currencies_UI", text:Dnet.translate("ui","Currencies_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.currency.frame.Currencies_UI", _bundle_:BUNDLE_ID},		
		{id:"CurrencyXrateProvider_UI", text:Dnet.translate("ui","CurrencyXrateProvider_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI", _bundle_:BUNDLE_ID},		
		{id:"CurrencyXRate", text:Dnet.translate("ui","CurrencyXRates_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_bd_geo", "text":"Geography", leaf:false, children:[
		
		{id:"Countries_UI", text:Dnet.translate("ui","Countries_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.geo.frame.Countries_UI", _bundle_:BUNDLE_ID},		
		{id:"CountryMD_UI", text:Dnet.translate("ui","CountryMD_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.geo.frame.CountryMD_UI", _bundle_:BUNDLE_ID},		
		{id:"Regions_UI", text:Dnet.translate("ui","Regions_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.geo.frame.Regions_UI", _bundle_:BUNDLE_ID},		
		{id:"RegionMD_UI", text:Dnet.translate("ui","RegionMD_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.geo.frame.RegionMD_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_bd_org", "text":"Organizations", leaf:false, children:[
		
		{id:"Org_UI", text:Dnet.translate("ui","Org_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.org.frame.Org_UI", _bundle_:BUNDLE_ID}	]}
,		 
	{"id":"sm_bd_stds", "text":"Standards", leaf:false, children:[
		
		{id:"Classifications_UI", text:Dnet.translate("ui","Classifications_UI"), leaf:true, _frame_:"net.nan21.dnet.module.bd.standards.frame.Classifications_UI", _bundle_:BUNDLE_ID}	]}
	]}
 
   ];  
if (Dnet.navigationTreeMenus.ad == undefined) {
	Dnet.navigationTreeMenus.ad = { name: "mbMenuAD" , title :"AD: Administration", children: [] };
}       
    Dnet.navigationTreeMenus.ad.children = Dnet.navigationTreeMenus.ad.children.concat(net.nan21.dnet.module.bd.menu.ad);
    
