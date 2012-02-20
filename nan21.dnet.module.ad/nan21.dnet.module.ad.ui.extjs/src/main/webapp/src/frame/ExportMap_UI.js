Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ExportMapDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportMap", "nan21.dnet.module.ad.ui.extjs/ds/ExportMapItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportMapItem","nan21.dnet.module.ad.ui.extjs/ds/CsvExportLovDs","nan21.dnet.module.ad.ui.extjs/lov/CsvExports"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ExportMap_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.impex.frame.ExportMap_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ExportMap_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("map", new net.nan21.dnet.module.ad.impex.dc.ExportMap({}))
		.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ExportMapItem({multiEdit:true}))		
		.linkDc("item", "map",{fields:[ {childField:"exportMapId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnRunExportMap",text:"Export All", tooltip:"Export all items included in this set.",iconCls:"icon-action-export",disabled:true
			,handler: this.onBtnRunExportMap,scope:this,stateManager:{name:"record_is_clean", dc:"map" }	})	
							 	
		.addButton({name:"btnRunExportItem",text:"Export selected", tooltip:"Export the selected item (one at a time).",iconCls:"icon-action-export",disabled:true
			,handler: this.onBtnRunExportItem,scope:this,stateManager:{name:"selected_one", dc:"item" }	})	
							 	
		.addDcFilterFormView("map",{ name:"mapFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMap$Filter",height:120})	 
		.addDcGridView("map",{ name:"mapList", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMap$List"})	 
		.addDcFormView("map",{ name:"mapEdit", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMap$Edit",height:120,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnRunExportMap") ,this._elems_.get("btnRunExportItem") ]}]})	 
		.addDcFilterFormView("item",{ name:"itemFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMapItem$Filter"})	 
		.addDcEditGridView("item",{ name:"itemCtxEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportMapItem$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["mapFilter","mapList"] ,["north","center"])	
		.addChildrenTo("canvas2",["mapEdit","itemCtxEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMapList")	  	
	 	.addToolbarTo("canvas2","tlbMapEdit")	  	
	 	.addToolbarTo("itemCtxEditList","tlbItemCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMapList", {dc:"map"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"File-sets"}).end()
			.beginToolbar("tlbMapEdit", {dc:"map"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"File-set"}).end()
			.beginToolbar("tlbItemCtxEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"CSV exports"}).end(); 	
	}


	,onBtnRunExportMap: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("map").doService("runExport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnRunExportItem: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("item").doService("runExport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
