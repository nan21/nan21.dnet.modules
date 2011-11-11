   

Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportParam", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.DsReportParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"paramCode", xtype:"gridcolumn", dataIndex:"paramCode",width:100,editor:{xtype:"net.nan21.dnet.module.ad.report.lovs.ReportParams" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "paramId"} ,{lovField:"name", dsField: "paramName"} ],filterFieldMapping: [{lovField:"reportId", dsField: "reportId"} ]} })
		.addTextColumn({ name:"paramName", dataIndex:"paramName",width:200 })
		.addLov({name:"dsField", xtype:"gridcolumn", dataIndex:"dsField",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsFields" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]} })
		.addTextColumn({ name:"staticValue", dataIndex:"staticValue",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
	  ;  		   
	}  
});
