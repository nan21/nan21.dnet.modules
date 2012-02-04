   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportJobItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ExportJobItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportJobItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportJobItem$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"mapName", xtype:"gridcolumn", dataIndex:"mapName",width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.ExportMaps" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "mapId"} ]} })
		.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true,width:120 })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"mapId", dataIndex:"mapId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
