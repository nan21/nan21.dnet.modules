   

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
	
	_noImport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"productCode", xtype:"gridcolumn", dataIndex:"productCode",width:100,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]} })
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"uomCode", xtype:"gridcolumn", dataIndex:"uomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", align:"right",decimals:2})
		.addLov({name:"tax", xtype:"gridcolumn", dataIndex:"tax",width:120,editor:{xtype:"net.nan21.dnet.module.bd.fin.lovs.Taxes" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "taxId"} ]} })
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxList",
	
	_noImport_: true,
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"uomCode", dataIndex:"uomCode",width:100 })   	
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice",decimals:2 })  
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount",decimals:2 })  
		.addTextColumn({ name:"tax", dataIndex:"tax", hidden:true,width:120 })   	
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true,width:70 })   	
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
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductsWithUom", dataIndex:"productCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} ]  })
		.addHiddenField({ name:"productId", dataIndex:"productId",listeners:{change:{scope:this, fn:this.onProductChange}}  })
		.addDisplayFieldText({ name:"productName", dataIndex:"productName"  })
		.addNumberField({ name:"quantity", dataIndex:"quantity",anchor:"-20" ,listeners:{change:{scope:this, fn:this.calcNetAmount}} , style: "text-align:right;" })
		.addLov({ name:"uomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uomCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		.addNumberField({ name:"unitPrice", dataIndex:"unitPrice",anchor:"-20" ,allowBlank:false,listeners:{change:{scope:this, fn:this.calcNetAmount}} , style: "text-align:right;" })
		.addDisplayFieldNumber({name:"netAmount", dataIndex:"netAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"taxAmount", dataIndex:"taxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addLov({ name:"tax", xtype:"net.nan21.dnet.module.bd.fin.lovs.TaxApplicables", dataIndex:"tax",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "taxId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"row2" ])
		.addChildrenTo("col1",["productId","productCode","productName"])
		.addChildrenTo("row2",["col2" ,"col3" ])
		.addChildrenTo("col2",["quantity","uomCode","unitPrice","tax"])
		.addChildrenTo("col3",["netAmount","taxAmount"])
;
	}	
	,onProductChange: function() {	
		
		var r = this._controller_.record;
		r.beginEdit();
		r.set("unitPrice", 0);
		r.set("netAmount", 0);
		r.set("taxAmount", 0);
		if (!r.get("productId")) {
			return ;
		}
		r.endEdit();
		this._controller_.doService("onProductChange")
	}
	,calcNetAmount: function() {	
		
		var r = this._controller_.record;
		r.beginEdit();
		r.set("netAmount", r.get("unitPrice") * r.get("quantity"));
		r.set("taxAmount", "");
		r.endEdit(); 
	}
});
