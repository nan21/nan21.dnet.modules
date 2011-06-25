Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ReportDs", "nan21.dnet.module.ad.ui.extjs/dc/Report", "nan21.dnet.module.ad.ui.extjs/ds/ReportParamDs", "nan21.dnet.module.ad.ui.extjs/dc/ReportParam", "nan21.dnet.module.ad.ui.extjs/ds/DsReportDs", "nan21.dnet.module.ad.ui.extjs/dc/DsReport", "nan21.dnet.module.ad.ui.extjs/ds/DsReportParamDs", "nan21.dnet.module.ad.ui.extjs/dc/DsReportParam","nan21.dnet.module.ad.ui.extjs/ds/ReportServerLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportServers","nan21.dnet.module.ad.ui.extjs/ds/ReportServerLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportServers","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/ReportParamLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportParams","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields"]);

Ext.ns("net.nan21.dnet.module.ad.report.frame");
net.nan21.dnet.module.ad.report.frame.Reports_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.report.frame.Reports_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("rep", new net.nan21.dnet.module.ad.report.dc.Report())
		.addDc("params", new net.nan21.dnet.module.ad.report.dc.ReportParam({multiEdit:true}))
		.addDc("dsrep", new net.nan21.dnet.module.ad.report.dc.DsReport({multiEdit:true}))
		.addDc("dsparam", new net.nan21.dnet.module.ad.report.dc.DsReportParam({multiEdit:true}))		
		.linkDc("params", "rep",{fields:[ {childField:"reportId", parentField:"id"} ]} )
		.linkDc("dsrep", "rep",{fields:[ {childField:"reportId", parentField:"id"} ]} )
		.linkDc("dsparam", "dsrep",{fields:[ {childField:"dsReportId", parentField:"id"},{childField:"reportId", parentField:"reportId"},{childField:"dataSource", parentField:"dataSource"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("rep",{ name:"repFilter", xtype:"net.nan21.dnet.module.ad.report.dc.Report$Filter"})	 
		.addDcView("rep",{ name:"repList", xtype:"net.nan21.dnet.module.ad.report.dc.Report$List"})	 
		.addDcView("rep",{ name:"repEdit", xtype:"net.nan21.dnet.module.ad.report.dc.Report$Edit",height:120})	 
		.addDcView("params",{ name:"paramEditList", xtype:"net.nan21.dnet.module.ad.report.dc.ReportParam$CtxEditList", frame:true,title:"Parameters"})	 
		.addDcView("dsrep",{ name:"dsrepList", xtype:"net.nan21.dnet.module.ad.report.dc.DsReport$ReportCtxList", frame:true})	 
		.addDcView("dsparam",{ name:"dsparamList", xtype:"net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "repDetailsTab", layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
		.addPanel({name: "dsRep", layout:"border", defaults:{split:true},title:"Data-source links"})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["repFilter","repList"] ,["north","center"])	
		.addChildrenTo("canvas2",["repEdit","repDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("repDetailsTab", ["paramEditList","dsRep"]) 				 		
		.addChildrenTo("dsRep",["dsrepList","dsparamList"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbRepList")	  	
	 	.addToolbarTo("canvas2","tlbRepEdit")	  	
	 	.addToolbarTo("paramEditList","tlbParamList")	  	
	 	.addToolbarTo("dsrepList","tlbDsRepList")	  	
	 	.addToolbarTo("dsparamList","tlbDsParamList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRepList", {dc:"rep"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end();
		this._getBuilder_()
			.beginToolbar("tlbRepEdit", {dc:"rep"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end();
		this._getBuilder_()
			.beginToolbar("tlbParamList", {dc:"params"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbDsRepList", {dc:"dsrep"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbDsParamList", {dc:"dsparam"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.ad.report.frame.Reports_UI", net.nan21.dnet.module.ad.report.frame.Reports_UI);   
