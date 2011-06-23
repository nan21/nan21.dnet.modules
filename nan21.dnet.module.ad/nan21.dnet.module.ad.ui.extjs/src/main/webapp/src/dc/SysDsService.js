   
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 
net.nan21.dnet.module.ad.system.dc.SysDsService = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SysDsService" 		 
			,ds: new net.nan21.dnet.module.ad.system.ds.SysDsServiceDs()			  
		});
	 	net.nan21.dnet.module.ad.system.dc.SysDsService.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 	 
net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList", net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList ); 
