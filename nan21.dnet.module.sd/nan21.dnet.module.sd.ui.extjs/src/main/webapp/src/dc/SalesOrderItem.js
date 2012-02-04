   

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesOrderItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxEditList",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"productCode", xtype:"gridcolumn", dataIndex:"productCode",width:100,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]} })
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })
		.addNumberColumn({ name:"qtyOrdered", dataIndex:"qtyOrdered", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"uomCode", xtype:"gridcolumn", dataIndex:"uomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"netUnitPrice", dataIndex:"netUnitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxList",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })   	
		.addNumberColumn({ name:"qtyOrdered", dataIndex:"qtyOrdered",decimals:2 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"uomCode", dataIndex:"uomCode",width:100 })   	
		.addNumberColumn({ name:"netUnitPrice", dataIndex:"netUnitPrice",decimals:2 })  
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount",decimals:2 })  
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"productCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]  })
		.addTextField({ name:"productName", dataIndex:"productName",anchor:"-20",noEdit:true  ,maxLength:255  })
		.addNumberField({ name:"qtyOrdered", dataIndex:"qtyOrdered",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"uomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uomCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		.addNumberField({ name:"netUnitPrice", dataIndex:"netUnitPrice",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"netAmount", dataIndex:"netAmount",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["productCode","productName"])
		.addChildrenTo("col2",["qtyOrdered","uomCode","netUnitPrice","netAmount"])
;
	}	
});
