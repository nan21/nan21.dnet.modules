   

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$FilterCtx",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addLov({ name:"productCode", dataIndex:"productCode",editor:{ xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]}  })
		 
		
	}
	
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxEditList",
	
	_noImport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"productCode", xtype:"gridcolumn", dataIndex:"productCode",width:100,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]} })
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"uomCode", xtype:"gridcolumn", dataIndex:"uomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 		 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxList",
	
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
		.addNumberColumn({ name:"lineAmount", dataIndex:"lineAmount",decimals:2 })  
		.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true,width:70 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$EditForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$EditForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addHiddenField({ name:"productId", dataIndex:"productId",listeners:{change:{scope:this, fn:this.onProductChange}}  })
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom", dataIndex:"productCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uom", dsField: "uomCode"} ,{lovField:"uomId", dsField: "uomId"} ]  })
		.addDisplayFieldText({ name:"productName", dataIndex:"productName"  })
		.addNumberField({ name:"quantity", dataIndex:"quantity" ,allowBlank:false,listeners:{change:{scope:this, fn:this.calcNetAmount}} , style: "text-align:right;" })
		.addLov({ name:"uomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uomCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		.addLov({ name:"tax", xtype:"net.nan21.dnet.module.md.base.tax.lovs.TaxApplicables", dataIndex:"tax" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "taxId"} ]  })
		.addNumberField({ name:"unitPrice", dataIndex:"unitPrice" ,allowBlank:false,listeners:{change:{scope:this, fn:this.calcNetAmount}} , style: "text-align:right;" })
		.addDisplayFieldNumber({name:"netAmount", dataIndex:"netAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"taxAmount", dataIndex:"taxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"lineAmount", dataIndex:"lineAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60   })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col4", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row1",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ])
		.addChildrenTo("row1",["col1" ,"col4" ])
		.addChildrenTo("col1",["productId","productCode","productName"])
		.addChildrenTo("col4",["description"])
		.addChildrenTo("row2",["col2" ,"col3" ])
		.addChildrenTo("col2",["quantity","uomCode","unitPrice","tax"])
		.addChildrenTo("col3",["netAmount","taxAmount","lineAmount"])
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
 	
