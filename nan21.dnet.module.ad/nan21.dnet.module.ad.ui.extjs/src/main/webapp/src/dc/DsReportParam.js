   
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
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("paramCode", { xtype:"gridcolumn", dataIndex:"paramCode", sortable:true, hidden:false,width:100,editor:{xtype:"net.nan21.dnet.module.ad.report.lovs.ReportParams" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "paramId"} ,{lovField:"name", dsField: "paramName"} ],filterFieldMapping: [{lovField:"reportId", dsField: "reportId"} ]} });
		this._columns_.add("paramName", { xtype:"gridcolumn", dataIndex:"paramName", sortable:true, hidden:false,width:200,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("dsField", { xtype:"gridcolumn", dataIndex:"dsField", sortable:true, hidden:false,width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsFields" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dataSource"} ]} });
	}  
});
Ext.reg("net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList ); 
