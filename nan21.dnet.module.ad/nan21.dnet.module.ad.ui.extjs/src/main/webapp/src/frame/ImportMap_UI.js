Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportMap", "nan21.dnet.module.ad.ui.extjs/ds/ImportMapItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportMapItemCtx","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource"]);

Ext.ns("net.nan21.dnet.module.ad.impex.frame");
net.nan21.dnet.module.ad.impex.frame.ImportMap_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ImportMap_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("map", new net.nan21.dnet.module.ad.impex.dc.ImportMap())
		.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx({multiEdit:true}))		
		.linkDc("item", "map",{fields:[ {childField:"importMapId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnRunImportMap",text:"Import All", tooltip:"Import all files included in this set.",iconCls:"icon-action-import",disabled:true
			,handler: this.onBtnRunImportMap,scope:this,stateManager:{name:"record_is_clean", dc:"map" }	})	
							 	
		.addButton({name:"btnRunImportItem",text:"Import selected", tooltip:"Import the selected file (one at a time).",iconCls:"icon-action-import",disabled:true
			,handler: this.onBtnRunImportItem,scope:this,stateManager:{name:"selected_one", dc:"item" }	})	
							 	
		.addDcFilterFormView("map",{ name:"mapFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMap$Filter"})	 
		.addDcView("map",{ name:"mapList", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMap$List"})	 
		.addDcFormView("map",{ name:"mapEdit", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMap$Edit",height:120,buttons:[ this._elems_.get("btnRunImportMap") ,this._elems_.get("btnRunImportItem") ]})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["mapFilter","mapList"] ,["north","center"])	
		.addChildrenTo("canvas2",["mapEdit","itemEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMapList")	  	
	 	.addToolbarTo("canvas2","tlbMapEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMapList", {dc:"map"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbMapEdit", {dc:"map"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnRunImportMap: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("map").doService("runImport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnRunImportItem: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("item").doService("runImport", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.impex.frame.ImportMap_UI", net.nan21.dnet.module.ad.impex.frame.ImportMap_UI);   
