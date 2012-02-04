Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDataSource", "nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsField"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.ad.system.dc.SysDataSource({}))
		.addDc("fields", new net.nan21.dnet.module.ad.system.dc.SysDsField({}))		
		.linkDc("fields", "m",{fetchMode:"auto",fields:[ {childField:"dataSourceId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnSynchronize",text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with deployed instances.",iconCls:"icon-action-synchronize",disabled:false
			,handler: this.onBtnSynchronize,scope:this	})	
							 	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter",height:120})	 
		.addDcView("m",{ name:"mList", xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnSynchronize") ]}]})	 
		.addDcView("fields",{ name:"listFields", xtype:"net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList",title:"Fields"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "panelDetails", _wrapped_:true, layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:400}}) 	  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mList","panelDetails"] ,["north","center","east"])	
	 	.addChildrenTo("panelDetails", ["listFields"]) 				 		
	 	.addToolbarTo("canvas1","tlbMList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMList", {dc:"m"}).addQuery().addSeparator().addSeparator().addTitle({"text":"Data-sources"}).end(); 	
	}


	,onBtnSynchronize: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getDc_("m").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("m").doServiceFilter("synchronizeCatalog", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
