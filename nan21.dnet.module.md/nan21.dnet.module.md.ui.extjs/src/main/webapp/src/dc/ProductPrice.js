   

Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDs",
	filterModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.price.ds.param.ProductPriceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.ProductPrice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		.addLov({ name:"uom", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode", dataIndex:"uom",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:280}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["product","productCategory"])
		.addChildrenTo("col2",["uom"])
    	.addAuditFilter()	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$FilterV", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.ProductPrice$FilterV",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:280}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["product","price","productCategory"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.ProductPrice$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"product", xtype:"gridcolumn", dataIndex:"product", width:150,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} ]} })
		.addTextColumn({ name:"productName", dataIndex:"productName", width:250,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"price", dataIndex:"price", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
