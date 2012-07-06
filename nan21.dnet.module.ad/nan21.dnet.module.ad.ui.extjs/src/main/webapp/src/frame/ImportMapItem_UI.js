Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportMapItem","nan21.dnet.module.ad.ui.extjs/ds/ImportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ImportMap","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/ImportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ImportMap","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ImportMapItem_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("mapItem", new net.nan21.dnet.module.ad.impex.dc.ImportMapItem({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnRunImport",text:"Import selected", tooltip:"Import the selected file (one at a time).",iconCls:"icon-action-import",disabled:true
			,handler: this.onBtnRunImport,scope:this,stateManager:{name:"selected_one_clean", dc:"mapItem" }	})	
							 	
		.addButton({name:"btnImportFileShow",text:"Import ad-hoc", tooltip:"Specify a file on server to import",disabled:false
			,handler: this.onBtnImportFileShow,scope:this	})	
							 	
		.addButton({name:"btnImportFileRun",text:"Execute", tooltip:"Execute",disabled:false
			,handler: this.onBtnImportFileRun,scope:this	})	
							 	
		.addDcFilterFormView("mapItem",{ name:"mapItemFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter",height:80})	 
		.addDcEditGridView("mapItem",{ name:"mapItemEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnRunImport") ,this._elems_.get("btnImportFileShow") ]}]})	 
		.addDcFilterFormView("mapItem",{ name:"importFileForm", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMapItem$ImportFileForm"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		
		.addWindow({name:"wdwImportFile", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("importFileForm")]
,title:"Import file from server",modal:true,width:500,height:170,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnImportFileRun") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mapItemFilter","mapItemEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMapItemEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMapItemEditList", {dc:"mapItem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Import files"}).end(); 	
	}


	,onBtnRunImport: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("mapItem").doService("runImport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnImportFileShow: function() {
		this._getWindow_("wdwImportFile").show();			 	
	}					 	

	,onBtnImportFileRun: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwImportFile").close();			 	
;			this.clearImportFileForm();
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		var failureFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwImportFile").close();			 	
			}; 
		s.callbacks['failureFn'] = failureFn; 
		s.callbacks['failureScope'] = this;
		try{ 
			this._getDc_("mapItem").doServiceFilter("runImportFile", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,clearImportFileForm: function() {	
		
		var mapItem = this._getDc_("mapItem");
		mapItem.setParamValue("importDataSource",null);
		mapItem.setParamValue("importFileLocation",null);
		mapItem.setParamValue("importUkFieldName",null);
		
	}
});  
