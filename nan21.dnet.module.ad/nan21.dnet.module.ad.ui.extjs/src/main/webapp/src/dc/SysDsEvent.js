   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsEvent", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsEventDs",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDsEventDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:100 })   	
	  ;		   
	}
});
 
