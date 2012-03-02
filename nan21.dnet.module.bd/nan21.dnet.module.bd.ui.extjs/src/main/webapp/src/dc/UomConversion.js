   

Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs",
	filterModel: "net.nan21.dnet.module.bd.uom.ds.model.UomConversionDsFilter",
	paramModel: "net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.uom.dc.UomConversion$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"sourceCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"sourceCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]  })
		.addLov({ name:"targetCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"targetCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210, height:50}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceCode","targetCode"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.uom.dc.UomConversion$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"sourceCode", xtype:"gridcolumn", dataIndex:"sourceCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]} })
		.addLov({name:"targetCode", xtype:"gridcolumn", dataIndex:"targetCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetId"} ]} })
		.addNumberColumn({ name:"multiplyWith", dataIndex:"multiplyWith", align:"right",decimals:6,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:6 } })
		.addNumberColumn({ name:"divideTo", dataIndex:"divideTo", align:"right",decimals:6,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:6 } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.uom.dc.UomConversion$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"sourceCode", dataIndex:"sourceCode",width:100 })
		.addLov({name:"targetCode", xtype:"gridcolumn", dataIndex:"targetCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetId"} ]} })
		.addNumberColumn({ name:"multiplyWith", dataIndex:"multiplyWith", align:"right",decimals:6,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:6 } })
		.addNumberColumn({ name:"divideTo", dataIndex:"divideTo", align:"right",decimals:6,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:6 } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
