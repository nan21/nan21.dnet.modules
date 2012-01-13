   

Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportSort", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.CsvExportSortDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportSort$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.CsvExportSort$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"csvExport", dataIndex:"csvExport", hidden:true,width:120 })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"dsField", xtype:"gridcolumn", dataIndex:"dsField", width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsFields" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]} })
		.addBooleanColumn({ name:"descend", dataIndex:"descend"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
