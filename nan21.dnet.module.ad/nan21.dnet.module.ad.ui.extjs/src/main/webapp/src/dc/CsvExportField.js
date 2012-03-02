   

Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportField", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.CsvExportFieldDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.CsvExportField$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.CsvExportField$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"csvExport", dataIndex:"csvExport", hidden:true,width:120 })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:60,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"dsField", xtype:"gridcolumn", dataIndex:"dsField", width:120,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsFields" , selectOnFocus:true ,maxLength:255,retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]} })
		.addTextColumn({ name:"alias", dataIndex:"alias", width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
