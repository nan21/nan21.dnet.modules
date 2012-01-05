   

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceDs",
	filterModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceDsFilter",
	paramModel: "net.nan21.dnet.module.mm.price.ds.param.ProductPriceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		.addLov({ name:"uom", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode", dataIndex:"uom",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:280}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["product","productCategory"])
		.addChildrenTo("col2",["uom"])
    	.addAuditFilter({})	
	}
}); 
 	

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice$FilterV", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPrice$FilterV",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:280}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["product","price","productCategory"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"product", xtype:"gridcolumn", dataIndex:"product", width:150,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ]} })
		.addTextColumn({ name:"productName", dataIndex:"productName", width:250,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"price", dataIndex:"price", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
