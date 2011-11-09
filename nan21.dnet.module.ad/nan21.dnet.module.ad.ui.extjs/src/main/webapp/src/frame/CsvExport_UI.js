Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExport", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExportField", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportSortDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExportSort","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.CsvExport_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.impex.frame.CsvExport_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.CsvExport_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("csv", new net.nan21.dnet.module.ad.impex.dc.CsvExport({multiEdit:true}))
		.addDc("field", new net.nan21.dnet.module.ad.impex.dc.CsvExportField({multiEdit:true}))
		.addDc("sort", new net.nan21.dnet.module.ad.impex.dc.CsvExportSort({multiEdit:true}))		
		.linkDc("field", "csv",{fields:[ {childField:"csvExportId", parentField:"id"},{childField:"dataSource", parentField:"dataSource"} ]} )
		.linkDc("sort", "csv",{fields:[ {childField:"csvExportId", parentField:"id"},{childField:"dataSource", parentField:"dataSource"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("csv",{ name:"csvFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExport$Filter",height:50})	 
		.addDcView("csv",{ name:"csvEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExport$EditList", frame:true})	 
		.addDcView("field",{ name:"fieldCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExportField$CtxEditList", frame:true,title:"Fields"})	 
		.addDcView("sort",{ name:"sortCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExportSort$CtxEditList", frame:true,title:"Sort"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "detailsAccordion", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id(),width:500}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["csvFilter","csvEditList","detailsAccordion"] ,["north","center","east"])	
	 	.addChildrenTo("detailsAccordion", ["fieldCtxEditList","sortCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbCsvEditList")	  	
	 	.addToolbarTo("fieldCtxEditList","tlbFieldCtxEditList")	  	
	 	.addToolbarTo("sortCtxEditList","tlbSortCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCsvEditList", {dc:"csv"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbFieldCtxEditList", {dc:"field"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Fields"}).end()
			.beginToolbar("tlbSortCtxEditList", {dc:"sort"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Sort"}).end(); 	
	}

});  
