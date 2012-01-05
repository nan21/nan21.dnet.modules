   

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPriceReport", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceReportDs",
	filterModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceReportDsFilter",
	paramModel: "net.nan21.dnet.module.mm.price.ds.param.ProductPriceReportDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPriceReport$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPriceReport$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceList", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"priceListVersion", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListVersion", dataIndex:"priceListVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListVersionId"} ],filterFieldMapping: [{lovField:"priceListId", dsField: "priceListId"} ]  })
		.addDateField({ name:"validAt", paramIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:280}) 
		.addPanel({ name:"col3", layout:"anchor", width:200, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["priceList","priceListVersion","currency"])
		.addChildrenTo("col2",["product","productCategory"])
		.addChildrenTo("col3",["validAt","price"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPriceReport$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.price.dc.ProductPriceReport$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"product", dataIndex:"product",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })   	
		.addNumberColumn({ name:"price", dataIndex:"price",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"priceList", dataIndex:"priceList",width:120 })   	
		.addTextColumn({ name:"priceListVersion", dataIndex:"priceListVersion",width:120 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
