   

Ext.define("net.nan21.dnet.module.ad.report.dc.DsReport", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.DsReportDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.report.dc.DsReport$ReportCtxList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.report.dc.DsReport$ReportCtxList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"reportId", dataIndex:"reportId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"dataSource", xtype:"gridcolumn", dataIndex:"dataSource", width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true ,noUpdate:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
	  	.addDefaults()
	  ;  		   
	}  
});
