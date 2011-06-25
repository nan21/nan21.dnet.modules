Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDataSource", "nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsField", "nan21.dnet.module.ad.ui.extjs/ds/SysDsServiceDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsService", "nan21.dnet.module.ad.ui.extjs/ds/SysDsEventDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDsEvent"]);

Ext.ns("net.nan21.dnet.module.ad.system.frame");
net.nan21.dnet.module.ad.system.frame.SysDataSources_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.ad.system.dc.SysDataSource())
		.addDc("fields", new net.nan21.dnet.module.ad.system.dc.SysDsField())
		.addDc("services", new net.nan21.dnet.module.ad.system.dc.SysDsService())
		.addDc("events", new net.nan21.dnet.module.ad.system.dc.SysDsEvent())		
		.linkDc("fields", "m",{fields:[ {childField:"dataSourceId", parentField:"id"} ]} )
		.linkDc("services", "m",{fields:[ {childField:"dataSourceId", parentField:"id"} ]} )
		.linkDc("events", "m",{fields:[ {childField:"dataSourceId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
			.addButton({xtype:"button", name:"btnSynchronize", id:Ext.id(),iconCls:"icon-action-synchronize" 
					,text:"Synchronize", tooltip:"Scan classpath and synchronize catalog with deployed instances."
					,disabled:false
					,handler: function() {}  ,scope:this })	
							 	
		.addDcView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter"})	 
		.addDcView("m",{ name:"mList", xtype:"net.nan21.dnet.module.ad.system.dc.SysDataSource$List",buttons:[ this._elems_.get("btnSynchronize") ]})	 
		.addDcView("fields",{ name:"listFields", xtype:"net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList",title:"Fields"})	 
		.addDcView("services",{ name:"listServices", xtype:"net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList",title:"Services"})	 
		.addDcView("events",{ name:"listEvents", xtype:"net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList",title:"Events"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "panelDetails", layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:400}}) 	  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mList","panelDetails"] ,["north","center","east"])	
	 	.addChildrenTo("panelDetails", ["listFields","listServices","listEvents"]) 				 		
	 	.addToolbarTo("canvas1","tlbMList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMList", {dc:"m"}).addQuery().end();
	}

});
Ext.reg("net.nan21.dnet.module.ad.system.frame.SysDataSources_UI", net.nan21.dnet.module.ad.system.frame.SysDataSources_UI);   
