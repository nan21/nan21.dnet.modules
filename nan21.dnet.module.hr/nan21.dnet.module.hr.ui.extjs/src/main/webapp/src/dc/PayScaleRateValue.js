   

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"scaleRateId", dataIndex:"scaleRateId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"scalePointId", dataIndex:"scalePointId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"scalePointCode", xtype:"gridcolumn", dataIndex:"scalePointCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.grade.lovs.PayScalePoints" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "scalePointId"} ]} })
		.addNumberColumn({ name:"value", dataIndex:"value", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
