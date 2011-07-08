Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportJob", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportJobItem","nan21.dnet.module.ad.ui.extjs/ds/ImportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ImportMap"



]);

Ext.ns("net.nan21.dnet.module.ad.impex.frame");
net.nan21.dnet.module.ad.impex.frame.ImportJob_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ImportJob_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("job", new net.nan21.dnet.module.ad.impex.dc.ImportJob())
		.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ImportJobItem({multiEdit:true}))		
		.linkDc("item", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addButton({name:"btnRunImport",text:"Import All", tooltip:"Import all sets included in this job.",iconCls:"icon-action-import",disabled:true
			,handler: this.onBtnRunImport,scope:this,stateManager:{name:"record_status_is_edit", dc:"job"}	})	
							 	
		.addButton({name:"btnRunImportItem",text:"Import selected", tooltip:"Import the selected set (one at a time).",iconCls:"icon-action-import",disabled:true
			,handler: this.onBtnRunImportItem,scope:this,stateManager:{name:"selected_one", dc:"item"}	})	
							 	
		.addDcView("job",{ name:"jobFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$Filter"})	 
		.addDcView("job",{ name:"jobList", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$List"})	 
		.addDcView("job",{ name:"jobEdit", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$Edit",height:100,buttons:[ this._elems_.get("btnRunImport") ,this._elems_.get("btnRunImportItem") ]})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["jobFilter","jobList"] ,["north","center"])	
		.addChildrenTo("canvas2",["jobEdit","itemEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbJobList")	  	
	 	.addToolbarTo("canvas2","tlbJobEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobList", {dc:"job"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbJobEdit", {dc:"job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}


	,onBtnRunImport: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("job").doService("runImport", s); 
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
Ext.reg("net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", net.nan21.dnet.module.ad.impex.frame.ImportJob_UI);   
