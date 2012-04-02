   

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScalePoint", {
	extend: "dnet.core.dc.AbstractDc",
 
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
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"payScaleId", dataIndex:"payScaleId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
