   
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 
net.nan21.dnet.module.ad.system.dc.SysDsField = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SysDsField" 		 
			,ds: new net.nan21.dnet.module.ad.system.ds.SysDsFieldDs()			  
		});
	 	net.nan21.dnet.module.ad.system.dc.SysDsField.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 	 
net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:200 })   	
		.addTextColumn({ name:"dataType", dataIndex:"dataType",width:150 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList", net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList ); 
