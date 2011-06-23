   
Ext.ns('net.nan21.dnet.module.ad.report.dc');	 
net.nan21.dnet.module.ad.report.dc.DsReportParam = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"DsReportParam" 		 
			,ds: new net.nan21.dnet.module.ad.report.ds.DsReportParamDs()			  
		});
	 	net.nan21.dnet.module.ad.report.dc.DsReportParam.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.report.dc');	 	 
net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addLov({name:"paramCode", xtype:"gridcolumn", dataIndex:"paramCode",width:100,editor:{xtype:"net.nan21.dnet.module.ad.report.lovs.ReportParams" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "paramId"} ,{lovField:"name", dsField: "paramName"} ],filterFieldMapping: [{lovField:"reportId", dsField: "reportId"} ]} })
		.addTextColumn({ name:"paramName", dataIndex:"paramName",width:200,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addLov({name:"dsField", xtype:"gridcolumn", dataIndex:"dsField",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsFields" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList ); 
