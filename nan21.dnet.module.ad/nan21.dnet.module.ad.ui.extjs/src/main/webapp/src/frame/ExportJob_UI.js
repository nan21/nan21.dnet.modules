Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ExportJobDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportJob", "nan21.dnet.module.ad.ui.extjs/ds/ExportJobItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ExportJobItem","nan21.dnet.module.ad.ui.extjs/ds/ExportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ExportMaps"]);

Ext.define("net.nan21.dnet.module.ad.impex.frame.ExportJob_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.impex.frame.ExportJob_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ExportJob_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("job", new net.nan21.dnet.module.ad.impex.dc.ExportJob({}))
		.addDc("item", new net.nan21.dnet.module.ad.impex.dc.ExportJobItem({multiEdit:true}))		
		.linkDc("item", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnRunExport",text:"Export All", tooltip:"Export all sets included in this job.",iconCls:"icon-action-export",disabled:true
			,handler: this.onBtnRunExport,scope:this,stateManager:{name:"record_status_is_edit", dc:"job" }	})	
							 	
		.addButton({name:"btnRunExportItem",text:"Export selected", tooltip:"Export the selected set (one at a time).",iconCls:"icon-action-export",disabled:true
			,handler: this.onBtnRunExportItem,scope:this,stateManager:{name:"selected_one", dc:"item" }	})	
							 	
		.addDcFilterFormView("job",{ name:"jobFilter", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportJob$Filter",height:120})	 
		.addDcView("job",{ name:"jobList", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportJob$List"})	 
		.addDcFormView("job",{ name:"jobEdit", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportJob$Edit",height:140,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnRunExport") ,this._elems_.get("btnRunExportItem") ]}]})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.ad.impex.dc.ExportJobItem$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
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
			.beginToolbar("tlbJobList", {dc:"job"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Jobs"}).end()
			.beginToolbar("tlbJobEdit", {dc:"job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Job"}).end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"File-sets"}).end(); 	
	}


	,onBtnRunExport: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("job").doService("runExport", s); 
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
