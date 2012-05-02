   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocLineCtxDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocLineCtxDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.AccDocLineCtxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount",width:200 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount",width:200 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2 })  
		.addNumberColumn({ name:"accDocId", dataIndex:"accDocId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
