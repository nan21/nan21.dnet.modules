Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysParamDs", "nan21.dnet.module.ad.ui.extjs/dc/SysParam"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysParam_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysParam_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysParam_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("sysparam", new net.nan21.dnet.module.ad.system.dc.SysParam({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnSynchronize",text:"Update cache", tooltip:"Propagate changes to the cached configuration parameters",iconCls:"icon-action-synchronize",disabled:false
			,handler: this.onBtnSynchronize,scope:this	})	
							 	
		.addDcFilterFormView("sysparam",{ name:"sysparamFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysParam$Filter",height:120})	 
		.addDcGridView("sysparam",{ name:"sysparamList", xtype:"net.nan21.dnet.module.ad.system.dc.SysParam$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnSynchronize") ]}]})	 
		.addDcFormView("sysparam",{ name:"sysparamEdit", xtype:"net.nan21.dnet.module.ad.system.dc.SysParam$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["sysparamFilter","sysparamList"] ,["north","center"])	
		.addChildrenTo("canvas2",["sysparamEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbSysparamList")	  	
	 	.addToolbarTo("canvas2","tlbSysparamEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSysparamList", {dc:"sysparam"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"System parameters"}).end()
			.beginToolbar("tlbSysparamEdit", {dc:"sysparam"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"System parameter"}).end(); 	
	}


	,onBtnSynchronize: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("sysparam").doServiceFilter("refreshSysConfig", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
