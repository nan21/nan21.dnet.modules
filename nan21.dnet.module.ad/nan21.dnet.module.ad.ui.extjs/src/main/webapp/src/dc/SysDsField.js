   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsField", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsFieldDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsFieldDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDsFieldDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:200 })   	
		.addTextColumn({ name:"dataType", dataIndex:"dataType",width:150 })   	
	  ;		   
	}
});
 
