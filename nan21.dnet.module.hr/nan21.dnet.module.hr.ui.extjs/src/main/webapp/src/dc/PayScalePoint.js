   

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScalePoint", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.PayScalePointDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"payScaleId", dataIndex:"payScaleId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",format:Ext.NUMBER_FORMAT_INT,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
