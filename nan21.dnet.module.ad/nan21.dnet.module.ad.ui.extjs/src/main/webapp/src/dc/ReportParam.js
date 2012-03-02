   

Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParam", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportParamDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.ReportParamDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.ReportParamDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.ad.report.dc.ReportParam$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.report.dc.ReportParam$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"reportCode", dataIndex:"reportCode", hidden:true, width:60,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addComboColumn({ name:"dataType", dataIndex:"dataType", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "string", "text", "integer", "decimal", "boolean", "date"] , triggerAction:'all', forceSelection:true }})
		.addTextColumn({ name:"listOfValues", dataIndex:"listOfValues", width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addTextColumn({ name:"defaultValue", dataIndex:"defaultValue", width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addBooleanColumn({ name:"mandatory", dataIndex:"mandatory", width:60})
		.addBooleanColumn({ name:"noEdit", dataIndex:"noEdit", width:60})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:4000} })
	  	.addDefaults()
	  ;  		   
	}  
});
