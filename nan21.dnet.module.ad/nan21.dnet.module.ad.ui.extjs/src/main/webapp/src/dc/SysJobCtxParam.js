   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobCtxParam", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysJobCtxParamDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysJobCtxParam$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysJobCtxParam$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"jobParam", dataIndex:"jobParam",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"dataType", dataIndex:"dataType",width:150 })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
