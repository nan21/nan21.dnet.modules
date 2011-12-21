   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"dataSource", xtype:"gridcolumn", dataIndex:"dataSource",width:150,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:300,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
