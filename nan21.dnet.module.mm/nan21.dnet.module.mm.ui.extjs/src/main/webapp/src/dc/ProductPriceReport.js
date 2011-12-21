   

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
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDateField({ name:"validAt", paramIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"product", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"product",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"col3", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["type","currency"])
		.addChildrenTo("col2",["product","productCategory"])
		.addChildrenTo("col3",["validAt","price"])
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
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addNumberColumn({ name:"price", dataIndex:"price",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
