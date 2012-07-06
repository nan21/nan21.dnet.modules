Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExport", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExportField", "nan21.dnet.module.ad.ui.extjs/ds/CsvExportSortDs", "nan21.dnet.module.ad.ui.extjs/dc/CsvExportSort", "nan21.dnet.module.ad.ui.extjs/ds/ExportMapItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportMapItem","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields","nan21.dnet.module.ad.ui.extjs/ds/ExportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ExportMaps"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.CsvExport_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.impex.frame.CsvExport_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.CsvExport_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("csv", new net.nan21.dnet.module.ad.impex.dc.CsvExport({multiEdit:true}))
		.addDc("field", new net.nan21.dnet.module.ad.impex.dc.CsvExportField({multiEdit:true}))
		.addDc("sort", new net.nan21.dnet.module.ad.impex.dc.CsvExportSort({multiEdit:true}))
		.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ExportMapItem({multiEdit:true}))		
		.linkDc("field", "csv",{fields:[ {childField:"csvExportId", parentField:"id"},{childField:"dataSource", parentField:"dataSource"} ]} )
		.linkDc("sort", "csv",{fields:[ {childField:"csvExportId", parentField:"id"},{childField:"dataSource", parentField:"dataSource"} ]} )
		.linkDc("item", "csv",{fields:[ {childField:"csvExportId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnShowCloneWdw",text:"Clone record", tooltip:"Clone record",disabled:true
			,handler: this.onBtnShowCloneWdw,scope:this,stateManager:{name:"selected_one_clean", dc:"csv" }	})	
							 	
		.addButton({name:"btnDoClone",text:"OK", tooltip:"Create clone",disabled:false
			,handler: this.onBtnDoClone,scope:this	})	
							 	
		.addDcFilterFormView("csv",{ name:"csvFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExport$Filter",height:80})	 
		.addDcEditGridView("csv",{ name:"csvEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExport$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnShowCloneWdw") ]}]})	 
		.addDcFormView("csv",{ name:"csvClone", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExport$Clone",height:120})	 
		.addDcEditGridView("field",{ name:"fieldCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExportField$CtxEditList", frame:true,title:"Fields"})	 
		.addDcEditGridView("sort",{ name:"sortCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.CsvExportSort$CtxEditList", frame:true,title:"Sort"})	 
		.addDcEditGridView("item",{ name:"itemCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxCsvExp", frame:true,title:"File-sets"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "detailsAccordion", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id(),width:600}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		
		.addWindow({name:"wdwClone", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("csvClone")]
,title:"Select product category",modal:true,width:400,height:120,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnDoClone") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["csvFilter","csvEditList","detailsAccordion"] ,["north","center","east"])	
	 	.addChildrenTo("detailsAccordion", ["fieldCtxEditList","sortCtxEditList","itemCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbCsvEditList")	  	
	 	.addToolbarTo("fieldCtxEditList","tlbFieldCtxEditList")	  	
	 	.addToolbarTo("sortCtxEditList","tlbSortCtxEditList")	  	
	 	.addToolbarTo("itemCtxEditList","tlbItemCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCsvEditList", {dc:"csv"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"CSV exports"}).end()
			.beginToolbar("tlbFieldCtxEditList", {dc:"field"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Fields"}).end()
			.beginToolbar("tlbSortCtxEditList", {dc:"sort"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Sort"}).end()
			.beginToolbar("tlbItemCtxEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"File-sets"}).end(); 	
	}


	,onBtnShowCloneWdw: function() {
		this._getWindow_("wdwClone").show();			 	
	}					 	

	,onBtnDoClone: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwClone").close();			 	
;			this._getDc_("csv").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("csv").doService("cloneCsvExport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
