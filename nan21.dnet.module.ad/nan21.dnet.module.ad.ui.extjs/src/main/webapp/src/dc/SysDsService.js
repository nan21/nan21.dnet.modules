   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsService", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsServiceDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsServiceDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDsServiceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysDsService$CtxList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
