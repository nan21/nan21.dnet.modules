   

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccDocLineCtxDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.acc.ds.param.AccDocLineCtxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$Filter",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addLov({ name:"accSchema", dataIndex:"accSchema",editor:{ xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", selectOnFocus:true,allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]}  })
		.addTextField({ name:"dbAccount", dataIndex:"dbAccount",maxLength:255  })
		.addTextField({ name:"crAccount", dataIndex:"crAccount",maxLength:255  })
		 
		
	}
	
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", hidden:true })  
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema",width:100 })   	
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:130 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:130 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2, width:130 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2, width:130 })  
		.addNumberColumn({ name:"accDocId", dataIndex:"accDocId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
