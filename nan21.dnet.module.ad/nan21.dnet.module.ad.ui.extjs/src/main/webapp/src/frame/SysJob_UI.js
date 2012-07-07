Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysJobDs", "nan21.dnet.module.ad.ui.extjs/dc/SysJob", "nan21.dnet.module.ad.ui.extjs/ds/SysJobParamDs", "nan21.dnet.module.ad.ui.extjs/dc/SysJobParam"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysJob_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysJob_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysJob_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("job", new net.nan21.dnet.module.ad.system.dc.SysJob({multiEdit:true}))
		.addDc("params", new net.nan21.dnet.module.ad.system.dc.SysJobParam({multiEdit:true}))		
		.linkDc("params", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnSynchronize",text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with deployed instances.",iconCls:"icon-action-synchronize",disabled:false
			,handler: this.onBtnSynchronize,scope:this	})	
							 	
		.addDcFilterFormView("job",{ name:"jobFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysJob$Filter"})	 
		.addDcEditGridView("job",{ name:"jobList", xtype:"net.nan21.dnet.module.ad.system.dc.SysJob$List", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnSynchronize") ]}]})	 
		.addDcEditGridView("params",{ name:"paramsCtxList", xtype:"net.nan21.dnet.module.ad.system.dc.SysJobParam$CtxList", frame:true,width:300})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["jobFilter","jobList","paramsCtxList"] ,["north","center","east"])	
	 	.addToolbarTo("canvas1","tlbJobList")	  	
	 	.addToolbarTo("paramsCtxList","tlbParamsCtxList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobList", {dc:"job"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Jobs"}).end()
			.beginToolbar("tlbParamsCtxList", {dc:"params"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Params"}).end(); 	
	}


	,onBtnSynchronize: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("job").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("job").doServiceFilter("synchronizeCatalog", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
